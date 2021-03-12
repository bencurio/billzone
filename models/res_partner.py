from odoo import api, fields, models, _

class billzone_res_partner(models.Model):
    _inherit = 'res.partner'

    huvat = fields.Char(string='Adószám (HU)')

