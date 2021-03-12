from odoo import api, fields, models, _

class billzone_res_partner(models.Model):
    _inherit = 'uom.uom'

    BillzoneEntityUnitIdentifier = fields.Char(string='Interfész (API) mennyiségi egység azonosító')

