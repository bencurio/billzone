import uuid
import os

from zeep import Client as ZeepClient
from zeep import Settings as ZeepSettings

BILLZONE_DOCTYPE_NORMAL = 1
BILLZONE_DOCTYPE_STORNO = 2
BILLZONE_DOCTYPE_CANCEL = 3
BILLZONE_DOCTYPE_MODIFY = 4

BILLZONE_INVOICE_DOCUMENT_TYPES = [
    (BILLZONE_DOCTYPE_NORMAL, 'Számla'),
    (BILLZONE_DOCTYPE_STORNO, 'Sztornó'),
    (BILLZONE_DOCTYPE_CANCEL, 'Jóváíró (érvénytelenítő)'),
    (BILLZONE_DOCTYPE_MODIFY, 'Debit Memo - Módosító')
]

BILLZONE_ERROR_OK = 61001

BILLZONE_ERROR_UNKNOWN = 'FRe'

BILLZONE_ERROR_INTERNAL = 61502

BILLZONE_WSDL_LIVE = "https://billzone.eu/Billgate?Wsdl"

BILLZONE_WSDL_SANDBOX = "https://sandbox.billzone.eu/Billgate?Wsdl"

BILLZONE_MODE_LIVE = "billzone.eu"

BILLZONE_MODE_SANDBOX = "sandbox.billzone.eu"

BILLZONE_ERROR_CODES = {

    # 5.1.1 Általános használt hibakódok
    61001: 'OK',
    'FRe': 'Ismeretlen hiba',
    61502: 'Belső kommunikációs hiba',

    # 5.1.2 Előfizetés hivakódok
    61503: 'Billgate nem használható a jelenlegi előfizetési csomagban',
    61504: 'Valamely előfizetési limitet elérte, nem lehet számlát kiállítani',

    # 5.1.3 InvoiceValidator hibakódok
    60001: 'A számlatömb megadása kötelező',
    60002: 'A pénznem megadása kötelező',
    60003: 'PaymentDueDate kötelező',
    60004: 'FulfillmentDate kötelező',
    60005: 'FulfillmentDate nem lehet a mai napnál 15 nappal korábbi',
    60006: 'PaymentMethodId kötelező',
    60007: 'Fizetési mód kapcsolat megadása kötelező',
    60008: 'Legalább egy tételsor kötelező',
    60009: 'Közösségen belüli adózás bepipálva: Csak 0% lehet az ÁFA',
    60010: 'A kiállító országtól eltérő valuta: Csak 0% lehet az ÁFA',
    60011: 'A vevő neve kötelező',
    60012: 'A vevő országkódja hibás',
    60013: 'A vevő címében a város kötelező',
    60014: 'A vevő címében a címsor 1 kötelező',
    60015: 'A vevő címében az irányítószám kötelező',
    60016: 'Ha közösségen belüli adózás van, akkor kötelező a vevő közösségi adószáma',
    60017: 'Ha ki van töltve a vevő közösségi adószáma, akkor formailag helyes kell, hogy legyen',
    60018: 'Ha ki van töltve a vevő adószáma, akkor formailag helyes kell, hogy legyen',
    60019: 'Ha küldünk levelet a vevőnek, akkor kötelező az email címet megadni',
    60020: 'Ha ki van töltve az email cím, akkor formailag helyes kell, hogy legyen',
    60021: 'A kiállító neve kötelező',
    60022: 'A kiállító országkódja hibás',
    60023: 'A kiállító címében a város kötelező',
    60024: 'A kiállító címében a címsor 1 kötelező',
    60025: 'A kiállító címében az irányítószám kötelező',
    60026: 'OrderNumber mező túl hosszú',
    60027: 'Notes mező túl hosszú',
    60028: 'InvoiceDescription mező túl hosszú',
    60029: 'BankDescription mező túl hosszú',
    60030: 'CustomerIdentifier mező túl hosszú',
    60031: 'CustomerName mező túl hosszú',
    60032: 'CustomerAddressState mező túl hosszú',
    60033: 'CustomerAddressPostalCode mező túl hosszú',
    60034: 'CustomerAddressCity mező túl hosszú',
    60035: 'CustomerAddressLine1 mező túl hosszú',
    60036: 'CustomerAddressLine2 mező túl hosszú',
    60037: 'CustomerEUTaxNumber mező túl hosszú',
    60038: 'CustomerTaxNumber mező túl hosszú',
    60039: 'CustomerEmailAddress mező túl hosszú',
    60040: 'ProductName mező túl hosszú',
    60041: 'ProductStatisticalCode mező túl hosszú',
    60042: 'Ha közösségen belüli adózás van, akkor kötelező a kiállító közösségi adószáma',
    60043: 'Hibás tételsor',
    60044: 'Belföldi devizás számlázás esetén meg kell adni az árfolyamot',
    60045: 'Külföldi devizás számla esetén, belföldi teljesítésnél, az árfolyamot meg kell adni',
    60046: 'Külföldi devizás számla esetén, nem belföldi teljesítésnél, az árfolyamot nem lehet megadni',
    60047: 'Külföldi devizás számla esetén, nem belföldi teljesítésnél, amennyiben a vevő közösségi adószámmal rendelkező cég, a tételeken nem lehet ÁFA tartalom',
    60048: 'Helyi pénznem esetén nem lehet megadni árfolyamot',
    60049: 'Árfolyam doboz megjelenítése esetén az árfolyam megadása kötelező!',
    60052: 'A vevő országa nem lehet Közösségen (EU-n) belüli.',
    60053: 'Közösségen belüli adózás vagy exportos számla esetén a vevő nem lehet hazai.',
    60054: 'A vevő és a kiállító országának Közösségen (EU-n) belülinek kell lennie.',
    60055: 'Amennyiben az\'EU\' ÁFA kulcsot használja, akkor fentebb hibásan nyilatkozott arról, hogy nem Közösségen (EU-n) belüli számlázást rögzít.',
    60057: 'Kedvezményes ÁFA jóváhagyása mező nem lehet kitöltve',
    60058: 'Fordított adózás esetén a vevőnek hazainak kell lennie.',
    60059: 'Fordított adózás esetén a vevő adóigazgatási számát kötelező megadni és hátulról a harmadik számjegyének 2, 3, 4 vagy 5-nek kell lennie.',
    60060: 'Közösségen belüli számlázáskor használja az\'EU\' ÁFA kulcsot!',
    60072: 'Az InvoiceLineNote mező túl hosszú',
    60073: 'ReferenceInvoiceNumber mező kötelező',
    60074: 'Nem létezik a hivatkozott számla és nincs engedélyezve az ismeretlen számla sztornója',
    60075: 'Érvénytelenítő esetén a ReferenceInvoiceFulfillmentDate mező kötelező',
    60076: 'A hivatkozott számla InvoiceSummary mezője nem helyes',
    60077: 'Hibás dokumentum típus: a számla bizonylat típusa csak\'Sztornó\' lehet, amennyiben a végösszeg az eredeti számla végösszege negatív előjellel.',
    60078: 'Hibás dokumentum típus: a számla bizonylat típusa csak\'Jóváíró\' lehet 0 vagy annál kisebb végösszeg esetén, amennyiben a tételsoron változtatást végzett.',
    60079: 'Hibás dokumentum típus: a számla bizonylat típusa csak\'Módosító\' lehet 0-nál nagyobb végösszeg esetén, amennyiben a tételsoron változtatást végzett.',
    60080: 'Ha az áfa tartalom nagyobb, mint 2M akkor a vevő adószáma kötelező!',
    60081: 'Több mint egy adómentes ÁFA kulcs van a számlán!',
    60082: 'A soron a periódus kezdetét kötelező megadni, ha az IsPeriodic értéke true!',
    60083: 'A soron a periódus végét kötelező megadni, ha az IsPeriodic értéke true!',
    60084: 'A soron a periódus kezdetét nem lehet megadni, ha az IsPeriodic értéke false!',
    60085: 'A soron a periódus végét nem lehet megadni, ha az IsPeriodic értéke false!',
    60086: 'A periódus vége nem lehet kisebb, mint a kezdete!',
    60087: 'Távértékesítés a 2011/83/EU irányelv és az Áfa tv. 45/A§-a szerint esetében a vevő EU-n belüli kell, hogy legyen!',
    60091: 'Azonos csoportból csak egy záradék használható!',
    60095: 'Vevő csoportazonosító szám túl hosszú!',
    60120: 'A számla az adattartalma alapján NAV adatszolgáltatásra kötelezett. Ehhez a NAV Online Számla regisztrációs felhasználónév, cserekulcs és aláírókulcs adatainak megadása szükséges a Nav adatszolgáltatási beállítások oldalon.',

    # 5.1.4. CashReceiptValidator hibakódok
    65000: 'A nyugtatömb megadása kötelező',
    65001: 'A kiállító neve mező túl hosszú',
    65002: 'A pénztáros neve mező túl hosszú',
    65003: 'A befizető neve mező túl hosszú',
    65004: 'A befizetőt azonosító okmányszám mező túl hosszú',
    65005: 'A vevő neve mező túl hosszú',

    # 5.1.5. Transaction ResultCode lista
    62001: 'Ismeretlen IssuerAddress típus',
    62002: 'Ismeretlen Bank típus',
    62003: 'A bankot nem lehetett betölteni a megadott azonosító alapján',
    62004: 'Nem lehetett betölteni az alapértelmezett bankot',
    62005: 'A telephelyet nem lehetett betölteni a megadott azonosító alapján',
    62006: 'Nem lehetett betölteni az alapértelmezett telephelyet',
    62007: 'Ismeretlen pénznem',
    62008: 'A pénznemet nem lehetett betölteni a megadott azonosító alapján',
    62009: 'Nem lehetett betölteni az alapértelmezett pénznemet',
    62010: 'Ismeretlen számlatömb előtag',
    62011: 'Nincs megadva pénznem',
    62012: 'Nincs megadva bank',
    62013: 'Nincs megadva telephely',
    62014: 'Nincs megadva számlatétel',
    62015: 'A mennyiségi egység ismeretlen',
    62016: 'A termék azonosítója ismeretlen',
    62017: 'Nincs megadva vevő',
    62018: 'A vevőt nem lehetett betölteni a megadott azonosító alapján',
    62019: 'Ismeretlen vevő típus',
    62020: 'Ismeretlen ÁFA kulcs',
    62021: 'Elektronikus számlatömb kell, hogy legyen',
    62023: 'Hibás TransactionId',
    62024: 'A megadott tranzakció azonosítóval már van tranzakció, de még feldolgozás alatt van',
    62025: 'A termék ÁFÁ-ja nem lehet 0%, használja az InvoiceLine2 típuson található ÁFA kód (VatTaxRateCode) mezőt!',
    62026: 'Az ÁFA kód nem érvényes!',
    62030: 'Nem használhat importált számlaszámok típusú számlatömböt',
    62031: 'Csak importált számlaszámok típusú számlatömbbel használható',
    62032: 'Csak nettó vagy bruttó egységár adható meg',
    62033: 'Nettó vagy bruttó egységár megadása kötelező',
    62034: 'A bruttó egységár értéke nem lehet -1 és 0, illetve 0 és 1 között',
    62035: 'SourceSystem mező túl hosszú',
    62040: 'Az adott számlasorszám már létezik',
    62041: 'Nem létezik a hivatkozott számla és nincs engedélyezve az ismeretlen számla sztornója',
    62042: 'A megadott InvoiceDocumentType nem megfelelő',
    62043: 'Nincs kitöltve a hivatkozott számla teljesítés ideje, és a hivatkozott számlát a rendszer nem találta',
    62044: 'ReferenceInvoiceNumber mező kötelező',
    62045: 'Az InvoiceCourierTypeId mező csak akkor vehet fel értéket, ha a SendInvoiceToCustomer értéke false',
    62046: 'Ismeretlen záradék azonosító',
    62048: 'Nem megfelelő záradéktípus',
    62049: 'RegisterExternalInvoice: UnitIdentifier vagy UnitText egyszerre nem adható meg',
    62050: 'IssuerSoftware/SoftwareId megadása kötelező',
    62051: 'IssuerSoftware/SoftwareId túl hosszú',
    62052: 'IssuerSoftware/SoftwareName túl hosszú',
    62053: 'IssuerSoftware.SoftwareOperation értéke nem megfelelő',
    62054: 'IssuerSoftware/SoftwareMainVersion túl hosszú',
    62055: 'IssuerSoftware/SoftwareDevName túl hosszú',
    62056: 'IssuerSoftware/SoftwareDevContact túl hosszú',
    62057: 'IssuerSoftware/SoftwareDevCountryCode túl hosszú',
    62058: 'IssuerSoftware/SoftwareDevTaxNumber túl hosszú',
    62059: 'OtherInvoiceData hiányzik a RegisterExternalInvoiceTransaction-ból',
    62060: 'IssuerSoftware hiányzik a RegisterExternalInvoiceTransaction/ConvertExternalInvoiceTransaction-ből',
    62061: 'RegisterExternalInvoiceTransaction hibás Bank adat típus (csak BankData típus lehet)',
    62062: 'RegisterExternalInvoiceTransaction hibás Telephely adat típus (csak IssuerAddressData típus lehet)',
    62112: 'OtherInvoiceLineData-ban meg kell adni a LineNumberReference-t sztornó/módosító/jóváíró számla esetén',
    62113: 'OtherInvoiceLineData-ban tiltott megadni a LineNumberReference-t normál számla (nem sztornó/jóváíró/módosító) esetén',
    62114: 'Xml validációs hiba a számla kiállítása során, ellenőrizze a Message tag-et!',
    62115: 'Vevő adószám, NAV validációs hiba',
    62116: 'Kiállító adószám, NAV validációs hiba',
    62117: 'Vevő adószám, NAV lekérdezés hiba',
    62118: 'Kiállítói adószám, NAV lekérdezés hiba',

    # Nyugtakiállítás tranzakció feldolgozása közben a következő hibakódok keletkezhetnek:
    62100: 'Nincs megadva hivatkozott számla',
    62101: 'A megadott számla nem található',
    62102: 'Nincs megadva pénznem',
    62103: 'Az adott azonosítóval nem lehetett betölteni a pénznemet',
    62104: 'Nincs megadva nyugtatömb előtag',
    62105: 'Ismeretlen nyugtatömb előtag',
    62106: 'A végösszeg nem lehet 0 vagy negatív érték',
    62107: 'Nincs megadva vevő',
    62108: 'A vevőt nem lehetett betölteni a megadott azonosító alapján',
    62109: 'Nincs megadva fizetési mód',
    62110: 'A fizetési módot nem lehetett betölteni a megadott azonosító alapján',
    62111: 'A fizetési mód nincs előlátva pénztári befizetésre',

    # 5.1.6. Request ResultCode lista
    61003: 'SecurityToken hibás',
    61005: 'Hibás RequestId',
    61006: 'A Request nem lehet null',
    61007: 'A megadott számlaszámhoz nem tartozik számla',

    # 5.1.7. DownloadInvoice ResultCode lista
    63001: 'A számla sorszám nem lehet null',
    63002: 'A megadott sorszámhoz nem tartozik számla',
    63003: 'A lekérdezés nem lehet null',
    63004: 'Hibás dokumentum típus',

    # 5.1.8. DownloadInvoices ResultCode lista
    64001: 'A megadott szűrőspecifikáció hibás',
    64002: 'A lekérdezés nem lehet null',

    # 5.1.9. DownloadCashReceipt ResultCode lista
    66001: 'A nyugta sorszám nem lehet null',
    66002: 'A megadott sorszámhoz nem tartozik nyugta',
    66003: 'A lekérdezés nem lehet null',

}


class billzone_error_codes():
    """
    BillZone hibakódok érvényességének ellenőrzése, hibaüzenetek szövegének betöltése.
    """

    ok_code = 61001
    codes = None

    def __init__(self):
        self.codes = BILLZONE_ERROR_CODES

    def is_error(self, code):
        """
        Ez hibakód?

        :param code: Hibakód
        :return:
        """
        if code == self.ok_code:
            return False
        return True

    def is_valid(self, code):
        """
        Létezik-e a hibakód?

        :param code: Hibakód
        :return:
        """
        if code in self.codes:
            return True
        return False

    def get_message(self, code):
        """
        Milyen üzenet tartozik hozzá?

        :param code: Hibakód
        :return:
        """
        if self.is_valid(code):
            return self.codes.get(code)
        return False


class Billzone():
    # A WSDL útvonala, ami alapján történik a kommunikáció
    wsdl = ''

    # API Kulcs
    security_token = ''

    # Zeep
    client = None

    # Zeep -> Type Factory
    factory = None

    # Lekérés
    query = None

    # Lekérés eredménye
    response = None

    def str(self, string):
        """
        Szöveges kommunikáció számlázásnál

        Kikényszerítjük, hogy string legyen az adattípus. Egyébként a nem kiltöltött értékeket "False"-ként írja
        a számlára, így ""-vel tér vissza ha nincs megadva semmi.

        :param string:
        :return:
        """
        if len(str(string)) == 0:
            return ""
        if not string:
            return ""
        return str(string)

    def currency_factory(self, currency):

        if not currency:
            raise Exception('A pénznem megadása kötelező!')
        if not currency.display_name:
            raise Exception('A pénznem betöltése nem sikerült!')
        if not currency.BillzoneSupport:
            raise Exception('Ezt a pénznemet nem támogatja a Billzone.')

        return self.factory.CurrencyShortName(
            ShortName=self.str(currency.display_name)
        )

    def bank_factory(self, journal):

        if not journal:
            raise Exception('A napló megadása kötelező!')
        if not journal.BillzoneEntityBankIdentifier:
            raise Exception('Ennél a naplónál nem lett még beállítva a Billzone.')

        return self.factory.BankIdentifier(
            Identifier=journal.BillzoneEntityBankIdentifier
        )

    def issuer_factory(self, journal):

        if not journal:
            raise Exception('A napló megadása kötelező!')

        return self.factory.IssuerAddressIdentifier(
            Identifier=journal.BillzoneEntityInvoiceIssuerIdentifier
        )

    def customer_factory(self, partner):
        """
        Vevő

        Előállítja az Odoo kapcsolati modellje alapján számlára kerülő Vevő részt.

        :param partner: res.partner
        :return:
        """

        if not partner:
            raise Exception('A partner megadása kötelező!')
        if not partner.name:
            raise Exception('A partner nevének megadása kötelező!')
        if not partner.zip:
            raise Exception('A partner irányítószámának megadása kötelező!')
        if not partner.city:
            raise Exception('A partner városának megadása kötelező!')
        if not partner.country_id:
            raise Exception('A partner országának megadása kötelező!')
        if not partner.street:
            raise Exception('A partner címének megadása kötelező!')

        return self.factory.Customer(
            Name=self.str(partner.name),
            CustomerIdentifier=self.str(partner.id),
            EUTaxNumber=self.str(partner.vat),
            TaxNumber=self.str(partner.huvat),
            AddressPostalCode=self.str(partner.zip),
            AddressCity=self.str(partner.city),
            AddressCountryId=self.str(partner.country_id.code),
            AddressLine1=self.str(partner.street),
            AddressLine2=self.str(partner.street2),
            AddressState=self.str(partner.state_id.name),
        )

    def invoice_header_factory(self, journal, invoice, customer, bank, issuer, currency, doctype):
        """
        Számla fejléc

        Előállítja a számla fejlécét

        :param journal:
        :param invoice: account.invoice
        :param customer: res.partner
        :param bank:
        :param issuer:
        :param currency: res.currency
        :param doctype:
        :return:
        """
        if not invoice.date_invoice:
            raise Exception("A számlán kötelező feltütetni a keletkezés dátumát!")
        if not invoice.date_due:
            raise Exception("A számlán kötelező feltötetni a fizetési határidőt!")

        args = {
            'AccountBlockPrefix': self.str(journal.BillzoneAccountBlockPrefix),
            'Customer': customer,
            'Bank': bank,
            'IssuerAddress': issuer,
            'FulfillmentDate': self.str(invoice.date_invoice.strftime("%Y-%m-%d")),
            'PaymentDueDate': self.str(invoice.date_due.strftime("%Y-%m-%d")),
            'Currency': currency,
            'InvoiceDescription': self.str(invoice.comment),
            'OrderNumber': self.str(invoice.number),
            'IsDomesticDelivery': self.str(invoice.BillzoneIsDomesticDelivery),
            'InterEUVatExempt': self.str(invoice.BillzoneInterEUVatExempt),
            'InvoiceHasElectronicServiceInEU': self.str(invoice.BillzoneInvoiceHasElectronicServiceInEU),
            'InvoiceDocumentType': self.str(doctype)
        }
        if doctype == BILLZONE_DOCTYPE_STORNO:
            args.update({
                'ReferenceInvoiceNumber': self.str(invoice.refund_invoice_id.BillzoneInvoiceNo),
                'InvoiceDescription': self.str(invoice.name),
            })

        return self.factory.InvoiceHeader(**args)

    def lines_factory(self, invoice, doctype):
        """
        Tételek

        Feltölti tételekkel az InvoiceLine2-őt

        :param invoice: account.invoice
        :return:
        """
        lines = []

        for line in invoice.invoice_line_ids:

            if line.product_id.default_code:
                product_code = line.product_id.default_code
            else:
                product_code = line.product_id.id

            if not line.invoice_line_tax_ids:
                raise Exception(
                    'Figyelem! Ez a tétel nem tartalmaz ÁFA-t, így a számla kiállítása nem lehetséges: ' + line.name)
            for vat_check in line.invoice_line_tax_ids:
                if not vat_check.BillzoneVatTaxRateCode:
                    raise Exception(
                        'Figyelem! Ez a tétel érvénytelen és/vagy nem beállított ÁFA-t tartalmaz: ' + line.name)

            quantity = line.quantity
            if doctype == BILLZONE_DOCTYPE_STORNO:
                quantity = line.quantity * -1

            if not line.uom_id.BillzoneEntityUnitIdentifier:
                raise Exception('Figyelem! Ennél a tételnél nincs beállítva a mértékegység <-> mennyiségi egység kapcsolat az ERP és a BillZone rendszere közt! Tétel: ' + line.name)

            lines.append(
                self.factory.InvoiceLine2(
                    ProductTextIdentifier=self.str(product_code),
                    ProductName=self.str(line.name),
                    NetUnitPrice=line.price_unit,
                    Quantity=quantity,
                    VatTaxRateCode=self.str(line.invoice_line_tax_ids[0].BillzoneVatTaxRateCode),
                    UnitIdentifier=self.str(line.uom_id.BillzoneEntityUnitIdentifier)
                )
            )

        return self.factory.ArrayOfInvoiceLine(lines)

    def invoice_transaction_factory(self, header, invoice, lines):
        return self.factory.CreateInvoiceTransaction(
            TransactionId=self.str(uuid.uuid4()),
            Header=header,
            Lines=lines,
            SendInvoiceToCustomer=0,
            SendInvoiceToEmailAddress=self.str(invoice.partner_id.email)
        )

    def __init__(self, config_parameter):
        path = os.path.join(os.path.dirname(os.path.abspath(__file__)))
        mode = config_parameter.get_param('billzone_server_mode')
        if mode == BILLZONE_MODE_SANDBOX:
            self.security_token = config_parameter.get_param('billzone_security_token')
            self.wsdl = path + '/wsdl/sandbox/Billgate.wsdl'
        elif mode == BILLZONE_MODE_LIVE:
            self.security_token = config_parameter.get_param('billzone_security_token_for_live')
            self.wsdl = path + '/wsdl/live/Billgate.wsdl'
        settings = ZeepSettings(
            strict=False,
            xml_huge_tree=True
        )
        self.client = ZeepClient(wsdl=self.wsdl, settings=settings)
        self.factory = self.type_factory('ns2')

    def type_factory(self, namespace="ns2"):
        return self.client.type_factory(namespace=namespace)

    def create_invoice_transaction(self, create_invoice_transaction):
        """
        Számla készítése

        :param createInvoiceTransaction:
        :return:
        """
        self.query = {
            'RequestId': str(uuid.uuid4()),
            'SecurityToken': self.security_token,
            'CreateInvoiceTransaction': create_invoice_transaction
        }
        self.response = self.client.service.CreateInvoice(self.query)

        if self.query_code() != str(BILLZONE_ERROR_OK):
            raise Exception('FIGYELEM! A számla kiállítása nem sikerült. Billzone API válasza (Query): ' + self.query_message())

        if self.transaction_code() != str(BILLZONE_ERROR_OK):
            raise Exception('FIGYELEM! A számla kiállítása nem sikerült. Billzone API válasza (Transaction): ' + self.transaction_message())

        if self.response['TransactionResult']['InvoiceNumber']:
            return self.response['TransactionResult']['InvoiceNumber']
        return False

    def download_invoice(self, InvoiceNumber, DocumentType="PDF"):
        """
        Számla letöltése

        :param InvoiceNumber:
        :param DocumentType:
        :return:
        """
        factory = self.type_factory('ns2')
        query = factory.DownloadInvoiceQuery(
            InvoiceNumber=InvoiceNumber,
            DocumentType=DocumentType,
        )
        return self.download_invoice_query(query)

    def download_invoice_query(self, DownloadInvoiceQuery):
        return self.client.service.DownloadInvoice({
            'RequestId': str(uuid.uuid4()),
            'SecurityToken': self.security_token,
            'DownloadInvoiceQuery': DownloadInvoiceQuery
        })

    def query_result(self):
        return self.response

    def query_code(self):
        return self.response['RequestResult']['Code']

    def query_message(self):
        return self.get_error_message(self.response['RequestResult']['Code'])

    def query_status(self):
        return {
            'Code': self.response['RequestResult']['Code'],
            'Message': self.get_error_message(self.response['RequestResult']['Code']),
            'IsError': self.response['RequestResult']['Code'] != 61001,
            'IsTransient': self.response['RequestResult']['IsTransient'],
        }

    def transaction_status(self):
        return {
            'Code': self.response['TransactionResult']['ResultCode']['Code'],
            'Message': self.get_error_message(self.response['TransactionResult']['ResultCode']['Code']),
            'IsError': self.response['TransactionResult']['ResultCode']['Code'] != 61001,
            'IsTransient': self.response['TransactionResult']['ResultCode']['IsTransient'],
        }

    def transaction_code(self):
        return self.response['TransactionResult']['ResultCode']['Code']

    def transaction_message(self):
        return self.get_error_message(self.response['TransactionResult']['ResultCode']['Code'])

    def get_error_message(self, code):
        return BILLZONE_ERROR_CODES.get(int(code))

    def is_known_error(self, code):
        if code in BILLZONE_ERROR_CODES:
            return True
        return False
