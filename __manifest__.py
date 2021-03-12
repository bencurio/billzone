# -*- coding: utf-8 -*-
{
    'name': 'BillZone Integráció',
    'version': '1.0.0',
    'summary': 'Integrálja a Billzone.eu számlázási rendszerét',
    'author': 'ecrazor1911',
    'depends': ['base', 'contacts', 'account', 'payment', 'account_payment', 'uom'],
    'data': [
        'data/account_tax.xml',
        'data/res_currency.xml',
        'views/report_invoice.xml',
        'views/account_journal.xml',
        'views/account_invoice.xml',
        'views/account_tax.xml',
        'views/account_invoice_send.xml',
        'views/res_config_settings_views.xml',
        'views/payment_acquirer.xml',
        'views/res_partner.xml',
        'views/res_currency.xml',
        'views/uom.xml',
    ],
}
