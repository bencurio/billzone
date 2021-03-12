from odoo import api, fields, models, _


class billzone_account_journal(models.Model):
    _inherit = 'account.journal'

    BillzoneEnable = fields.Boolean(string="BillZone integráció engedélyezése", groups='base.group_system')
    BillzoneAccountBlockPrefix = fields.Char(string="Számlatömb jele",
                                             help="Az összekapcsoláshoz meg kell adni a Billzone.eu -> Törzsadatok -> Számlatömbök menüpontban található számlatömb jelét.",
                                             groups='base.group_system')
    BillzoneEntityInvoiceIssuerIdentifier = fields.Char(string="Telephelyazonosító",
                                                        help="Az összekapcsoláshoz meg kell adni a Billzone.eu -> Törzsadatok -> Telephelyek menüpontban található telephelyazonosító egyikét.",
                                                        groups='base.group_system')
    BillzoneEntityBankIdentifier = fields.Char(string="Fizetési mód azonosító (API)",
                                               help="Az összekapcsoláshoz meg kell adni a Billzone.eu -> Törzsadatok -> Fizetési módok menüpontban található interfészhez (API) kapcsolódó fizetósi mód azonosítók egyikét.",
                                               groups='base.group_system')
