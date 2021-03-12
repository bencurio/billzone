from odoo import api, fields, models, _

class billzone_account_tax(models.Model):
    _inherit = 'account.tax'

    BillzoneVatTaxRateCode = fields.Char(string="ÁFA kód", groups='base.group_system')
    BillzoneVatTaxRateName = fields.Char(string="Leírás", groups='base.group_system')
