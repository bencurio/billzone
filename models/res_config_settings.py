from odoo import api, fields, models, _


class res_config_settings(models.TransientModel):
    _inherit = 'res.config.settings'

    BillzoneServerMode = fields.Selection(
        string="Üzemmód",
        selection=[
            ('sandbox.billzone.eu', 'Tesztelési mód'),
            ('billzone.eu', 'Éles mód'),
        ],
        config_parameter='billzone_server_mode',
        default='sandbox.billzone.eu',
        agroups='base.group_system'
    )
    BillzoneSecurityToken = fields.Char(
        string="API kulcs",
        config_parameter='billzone_security_token',
        groups='base.group_system'
    )
    BillzoneSecurityTokenForLive = fields.Char(
        string="API kulcs (éles)",
        config_parameter='billzone_security_token_for_live',
        groups='base.group_system'
    )

    @api.model
    def get_values(self):
        res = super(res_config_settings, self).get_values()
        get_param = self.env['ir.config_parameter'].sudo().get_param
        return res
