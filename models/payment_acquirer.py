from odoo import api, fields, models, _
from odoo.exceptions import UserError

class billzone_payment_acquirer(models.Model):
    _inherit = 'payment.acquirer'

    BillzoneEnable = fields.Boolean(string="BillZone integráció engedélyezése", groups='base.group_system')
    BillzoneEntityBankIdentifier = fields.Char(string="Fizetési mód azonosító (API)", help="Az összekapcsoláshoz meg kell adni a Billzone.eu -> Törzsadatok -> Fizetési módok menüpontban található interfészhez (API) kapcsolódó fizetósi mód azonosítók egyikét.", groups='base.group_system')

