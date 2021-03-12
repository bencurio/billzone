from odoo import api, fields, models, _

class billzone_res_currency(models.Model):
    _inherit = 'res.currency'

    BillzoneSupport = fields.Boolean(string='BillZone', help='Bekapcsolt állapot esetén támogatja a BillZone rendszere ezt a devizát.')
