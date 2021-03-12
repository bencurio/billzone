from odoo import api, fields, models
import logging
import uuid

from odoo import api, fields, models
from odoo.exceptions import UserError

from ..libs.billzone.billzone import BILLZONE_DOCTYPE_NORMAL, BILLZONE_DOCTYPE_STORNO, BILLZONE_INVOICE_DOCUMENT_TYPES
from ..libs.billzone.billzone import Billzone

ACCOUNT_INVOICE_TYPE_OUT = "out_invoice"
ACCOUNT_INVOICE_TYPE_REFUND = "out_refund"

_logger = logging.getLogger(__name__)

class billzone_account_invoice(models.Model):
    _inherit = 'account.invoice'

    BillzoneInvoiceNo = fields.Char(string="BillZone számlaszám", store=True, readonly=True, copy=False)
    BillzoneInvoiceDocumentType = fields.Selection(string="Számla típusa", selection=BILLZONE_INVOICE_DOCUMENT_TYPES, default=BILLZONE_DOCTYPE_NORMAL)

    BillzoneIsDomesticDelivery = fields.Boolean(string="Belföldi teljesítés", default=True)
    BillzoneInterEUVatExempt = fields.Boolean(string="EU-n belüli 0%-os ÁFÁs", default=False)
    BillzoneInvoiceHasElectronicServiceInEU = fields.Boolean(string="Távértékesítés a 2011/83/EU irányelv és az Áfa tv. 45/A§-a szerint", default=False)
    BillzoneForceLocalForeignCurrencyExchangeRate = fields.Boolean(string="Árfolyam doboz megjelenítése", default=False)
    BillzoneLocalForeignCurrencyExchangeRate = fields.Float(string="Árfolyam")

    BillzoneReferenceInvoiceNumber = fields.Many2one(string="Hivatkozott számlasorszám", comodel_name="account.invoice")
    BillzoneReferenceInvoiceNumberExternal = fields.Char(string="BillZone számlaszám")
    BillzoneReferenceInvoiceFulfillmentDate = fields.Date(string="Hivatkozott számla teljesítési ideje")

    BillzoneCustomPDFEnable = fields.Boolean(string="Külső számlakép használata")
    BillzoneCustomPDF = fields.Binary(string="PDF számla")
    BillzoneCustomInvoiceNo = fields.Char(string="Külső számlaszám")

    @api.onchange('BillzoneReferenceInvoiceNumber')
    def onchange_BillzoneReferenceInvoiceNumber(self):
        if self.BillzoneReferenceInvoiceNumber:
            if not self.BillzoneReferenceInvoiceFulfillmentDate:
                if not self.BillzoneReferenceInvoiceNumber.date_invoice:
                    raise UserError('A választott számla nem tartalmaz kiállítási időpontot!')
                if not self.BillzoneInvoiceNo:
                    raise UserError('A választott számla nem került még kiállításra!')
                self.BillzoneReferenceInvoiceNumberExternal = self.BillzoneInvoiceNo
                self.BillzoneReferenceInvoiceFulfillmentDate = self.BillzoneReferenceInvoiceNumber.date_invoice.strftime("%Y-%m-%d")

    @api.onchange('BillzoneInterEUVatExempt')
    def onchange_BillzoneInterEUVatExempt(self):
        """
        EU-n belüli 0%-os ÁFAs

        :return:
        """
        if self.BillzoneInterEUVatExempt:
            for line in self.invoice_line_ids:
                line.invoice_line_tax_ids = self.env['account.tax'].search([('description', '=', 'EU')])
        else:
            for line in self.invoice_line_ids:
                line.invoice_line_tax_ids = line.product_id.taxes_id

    @api.multi
    def action_invoice_open(self):
        """
        Számla érvényesítés kiegészítése

        Kiegészíti a számla érvényesítési folyamatát azzal, hogy ha elfogadásra kerül a számla, akkor API-n keresztül
        elkészíti a számlát a rendszer és lekérdezi a PDF számlát.

        :return:
        """
        res = super(billzone_account_invoice, self).action_invoice_open()

        if not self:
            return res

        # Generate Invoice
        for invoice in self:
            if invoice.BillzoneCustomPDFEnable is True:
                invoice.BillzoneInvoiceNo = invoice.BillzoneCustomInvoiceNo
            if invoice.journal_id.BillzoneEnable and invoice.BillzoneCustomPDFEnable is False:
                try:
                    # Kimenő számla
                    if invoice.type == ACCOUNT_INVOICE_TYPE_OUT:
                        self._create_billzone_out(type=ACCOUNT_INVOICE_TYPE_OUT, invoice=invoice)
                    # Kimenő sztornó számla
                    if invoice.type == ACCOUNT_INVOICE_TYPE_REFUND:
                        self._create_billzone_out(type=ACCOUNT_INVOICE_TYPE_REFUND, invoice=invoice)
                except Exception as msg:
                    raise UserError(str(msg))

        return res

    def _create_billzone_out(self, type, invoice):
        """
        Számla kiállítás

        :param type: out_invoice|out_refund
        :param invoice: account.invoice
        :return:
        """

        # Billzone
        config_parameter = self.env['ir.config_parameter'].sudo()
        billzone = Billzone(config_parameter=config_parameter)

        # Számla típusa
        doctype = None
        if type == ACCOUNT_INVOICE_TYPE_OUT:  # Normál számla
            doctype = BILLZONE_DOCTYPE_NORMAL
        elif type == ACCOUNT_INVOICE_TYPE_REFUND:  # Sztornó számla
            doctype = BILLZONE_DOCTYPE_STORNO

        # Fejléc
        header = billzone.invoice_header_factory(
            journal=invoice.journal_id,
            invoice=invoice,
            customer=billzone.customer_factory(partner=invoice.partner_id),
            bank=billzone.bank_factory(journal=invoice.journal_id),
            issuer=billzone.issuer_factory(journal=invoice.journal_id),
            currency=billzone.currency_factory(currency=invoice.currency_id),
            doctype=doctype
        )

        # Tételek
        lines = billzone.lines_factory(invoice=invoice, doctype=doctype)

        # Tranzakció
        transaction = billzone.invoice_transaction_factory(header=header, invoice=invoice, lines=lines)
        _logger.debug(transaction)

        # Generálás
        invoice_number = billzone.create_invoice_transaction(create_invoice_transaction=transaction)

        # Külsős számlaszám rögzítése
        invoice.BillzoneInvoiceNo = invoice_number

    # @api.multi
    # def action_invoice_re_open(self):
    #     res = super(billzone_account_invoice, self).action_invoice_cancel()
    #     if not self:
    #         return res
    #     for invoice in self:
    #         if invoice.journal_id.BillzoneEnable:
    #             if invoice.BillzoneInvoiceNo:
    #                 raise UserError('Nincs lehetőség a számla újranyitására! Új számlát kell kiállítani.')
    #     return res

    @api.multi
    def action_invoice_cancel(self):
        res = super(billzone_account_invoice, self).action_invoice_cancel()
        if not self:
            return res
        for invoice in self:
            if invoice.journal_id.BillzoneEnable:
                if invoice.BillzoneInvoiceNo:
                    raise UserError('Nincs lehetőség a számla visszavonására, mivel már az kiállításra került!')
        return res

