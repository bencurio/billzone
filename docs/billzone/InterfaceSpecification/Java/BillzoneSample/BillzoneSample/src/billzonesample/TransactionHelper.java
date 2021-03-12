/*
 *
 *
 */
package billzonesample;

import datamodel.invoicing.billgate.billzone.AllocatedPayment;
import datamodel.invoicing.billgate.billzone.ArrayOfClauseItem;
import datamodel.invoicing.billgate.billzone.ArrayOfClauseParameterItem;
import datamodel.invoicing.billgate.billzone.ArrayOfInvoiceLine;
import datamodel.invoicing.billgate.billzone.ArrayOfInvoiceLineWithAmount;
import datamodel.invoicing.billgate.billzone.ArrayOfInvoiceVatGroup;
import datamodel.invoicing.billgate.billzone.BankIdentifier;
import datamodel.invoicing.billgate.billzone.CashReceiptHeader;
import datamodel.invoicing.billgate.billzone.ClauseDecimalParameterItem;
import datamodel.invoicing.billgate.billzone.ClauseItem;
import datamodel.invoicing.billgate.billzone.ClauseStringParameterItem;
import datamodel.invoicing.billgate.billzone.ConvertExternalInvoiceTransaction;
import datamodel.invoicing.billgate.billzone.CreateCashReceiptTransaction;
import datamodel.invoicing.billgate.billzone.CreateInvoiceTransaction;
import datamodel.invoicing.billgate.billzone.CurrencyShortName;
import datamodel.invoicing.billgate.billzone.Customer;
import datamodel.invoicing.billgate.billzone.CustomerIdentifier;
import datamodel.invoicing.billgate.billzone.DefaultCurrency;
import datamodel.invoicing.billgate.billzone.DefaultIssuerAddress;
import datamodel.invoicing.billgate.billzone.InvoiceHeader;
import datamodel.invoicing.billgate.billzone.InvoiceHeaderWithTotalAmount;
import datamodel.invoicing.billgate.billzone.InvoiceLine2;
import datamodel.invoicing.billgate.billzone.InvoiceLineBase;
import datamodel.invoicing.billgate.billzone.InvoiceLineIdentifier;
import datamodel.invoicing.billgate.billzone.InvoiceLineWithAmount;
import datamodel.invoicing.billgate.billzone.InvoiceVatGroup;
import datamodel.invoicing.billgate.billzone.IssuerAddressIdentifier;
import datamodel.invoicing.billgate.billzone.UnallocatedPayment;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 *
 */
public class TransactionHelper {

    /**
     * Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban
     * tárolt egyedi azonosítójuk alapján történik, a fizetési mód és pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszik fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek.
     *
     * A teszteléshez szükséges beállítani az adott cég adatait
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithDefaultsTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        CustomerIdentifier customer = new CustomerIdentifier();
        customer.setIdentifier("VEVO02");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());
        return transaction;
    }

    /**
     * Számla létrehozása tranzakció, a termékek és fizetési mód meghatározása a
     * törzsadatokban tárolt egyedi azonosítójuk alapján történik, a pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszi fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithBankIdentifierTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }

    /**
     * Számla létrehozása tranzakció, a fizetési mód, telephely és pénznem
     * meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján
     * történik, a számlatétel adatok egyedi értékeket vesznek fel.
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithCustomDataTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor definiálása
        InvoiceLine2 invoiceLine = new InvoiceLine2();

        invoiceLine.setProductStatisticalCode("88.69.72");
        invoiceLine.setProductName("Teszt termék 1");
        invoiceLine.setNetUnitPrice(new BigDecimal(7900));
        invoiceLine.setQuantity(new BigDecimal(27.5));
        invoiceLine.setVatTaxRateCode("S");
        invoiceLine.setUnitIdentifier("DARAB");
        invoiceLine.setProductTextIdentifier("TESZTT123");
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        // Tételsor definiálása
        invoiceLine.setProductStatisticalCode("77.69.72");
        invoiceLine.setProductName("Teszt termék 2");
        invoiceLine.setNetUnitPrice(new BigDecimal(6000));
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setVatTaxRateCode("S");
        invoiceLine.setUnitIdentifier("DARAB");
        invoiceLine.setProductTextIdentifier("TESZTT124");
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }

    /**
     * Sztornó számla létrehozása tranzakció.
     *
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceVoidTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");
        
        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        // Telephely beállítása azonosító alapján
        IssuerAddressIdentifier issuer = new IssuerAddressIdentifier();
        issuer.setIdentifier("TESTTELEPHELY01");

        // Pénznem beállítása azonosító alapján
        CurrencyShortName currency = new CurrencyShortName();
        currency.setShortName("HUF");

        header.setBank(bank);
        header.setIssuerAddress(issuer);
        header.setCurrency(currency);

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        //Hivatkozott számlaszám
        header.setReferenceInvoiceNumber("TEST0001");

        //Számla típusa: Stornó
        header.setInvoiceDocumentType(2);

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(-1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }

    /**
     * Jóváíró számla létrehozása tranzakció.
     *
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceCreditMemoTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");
        
        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        // Telephely beállítása azonosító alapján
        IssuerAddressIdentifier issuer = new IssuerAddressIdentifier();
        issuer.setIdentifier("TESTTELEPHELY01");

        // Pénznem beállítása azonosító alapján
        CurrencyShortName currency = new CurrencyShortName();
        currency.setShortName("HUF");

        header.setBank(bank);
        header.setIssuerAddress(issuer);
        header.setCurrency(currency);

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        //Hivatkozott számlaszám
        header.setReferenceInvoiceNumber("TEST0001");

        //Számla típusa: Jóváíró
        header.setInvoiceDocumentType(3);

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(-2));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }

    /**
     * Módosító számla létrehozása tranzakció.
     *
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceDebitMemoTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");
        
        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        // Telephely beállítása azonosító alapján
        IssuerAddressIdentifier issuer = new IssuerAddressIdentifier();
        issuer.setIdentifier("TESTTELEPHELY01");

        // Pénznem beállítása azonosító alapján
        CurrencyShortName currency = new CurrencyShortName();
        currency.setShortName("HUF");

        header.setBank(bank);
        header.setIssuerAddress(issuer);
        header.setCurrency(currency);

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        //Hivatkozott számlaszám
        header.setReferenceInvoiceNumber("TEST0001");

        //Számla típusa: Módosító
        header.setInvoiceDocumentType(4);

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(3));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }

    /**
     * Számla létrehozása tranzakció, amely tartalmazza a számla fejadatait, a
     * számla tételeit, a számla végösszegével és adótartalmával kapcsolatos
     * adatait, illetve a számlaértesítővel kapcsolatos adatokat.
     *
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static ConvertExternalInvoiceTransaction getConvertExternalInvoiceTransaction() throws DatatypeConfigurationException {

        ConvertExternalInvoiceTransaction transaction = new ConvertExternalInvoiceTransaction();

        InvoiceHeaderWithTotalAmount header = new InvoiceHeaderWithTotalAmount();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123sdf");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("UMNT");

		// Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");
		
        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása                      
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        //Számla végösszeg és adótartalom megadása
        header.setInvoiceNetTotalAmount(new BigDecimal(1000));
        header.setInvoiceGrossTotalAmount(new BigDecimal(1270));
        header.setInvoiceVatTotalAmount(new BigDecimal(270));

        //A számlával típusa mező megadása
        header.setInvoiceDocumentType(1);

        header.setInvoiceNumber("XX0002");

        transaction.setHeader(header);

        InvoiceLineWithAmount invoiceLine = new InvoiceLineWithAmount();

        invoiceLine.setProductStatisticalCode("88.69.72");
        invoiceLine.setProductName("Teszt termék 1");
        invoiceLine.setNetUnitPrice(new BigDecimal(1000));
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setVatTaxRateCode("S");
        invoiceLine.setUnitIdentifier("T1METER");
        invoiceLine.setProductTextIdentifier("TESZTT123");
        invoiceLine.setNetAmount(new BigDecimal(1000));
        invoiceLine.setGrossAmount(new BigDecimal(1270));
        invoiceLine.setVatAmount(new BigDecimal(270));

        ArrayOfInvoiceLineWithAmount invoiceLines = new ArrayOfInvoiceLineWithAmount();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineWithAmounts().add(invoiceLine);

        transaction.setLines(invoiceLines);

        //Adócsoport létrehozása és töltése
        InvoiceVatGroup vatGroup = new InvoiceVatGroup();

        vatGroup.setVatTaxRateCode("S");
        vatGroup.setNetAmount(new BigDecimal(1000));
        vatGroup.setGrossAmount(new BigDecimal(1270));
        vatGroup.setVatAmount(new BigDecimal(270));

        ArrayOfInvoiceVatGroup vatGroups = new ArrayOfInvoiceVatGroup();

        //Adócsoport hozzáadása
        vatGroups.getInvoiceVatGroups().add(vatGroup);

        transaction.setVatGroups(vatGroups);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());

        return transaction;
    }
    
     /**
     * Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban
     * tárolt egyedi azonosítójuk alapján történik, a fizetési mód és pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszik fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek.
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithDefaultsInvoiceLineClausesTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        //Záradék lista létrehozása
        ArrayOfClauseItem clauseItemList = new ArrayOfClauseItem();
        
        //Záradék létrehozása
        ClauseItem clauseItem = new ClauseItem();
        clauseItem.setId("dohany");
                
        //Számla tétel záradék paraméterek hozzáadása
        
        ArrayOfClauseParameterItem  parameterList = new ArrayOfClauseParameterItem();
        
        ClauseDecimalParameterItem parameter1 = new ClauseDecimalParameterItem() {
            {
                setName("dohany_ar");
                setValue(new BigDecimal(1000));            
            }
        };        
       
        parameterList.getClauseParameterItemBases().add(parameter1);
                
        clauseItem.setParameters(parameterList);

        //Záradék hozzádadása
       clauseItemList.getClauseItems().add(clauseItem);
       invoiceLine.setClauses(clauseItemList);
        
        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());
        return transaction;
    }
    
     /**
     * Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban
     * tárolt egyedi azonosítójuk alapján történik, a fizetési mód és pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszik fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek.
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithDefaultsInvoiceClausesTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        //Záradék lista létrehozása
        ArrayOfClauseItem clauseItemList = new ArrayOfClauseItem();
        
        //Záradék létrehozása
        ClauseItem clauseItem = new ClauseItem();
        clauseItem.setId("betet_dij");
                
        //Záradék paraméterek hozzáadása
        
        ArrayOfClauseParameterItem  parameterList = new ArrayOfClauseParameterItem();
        
        ClauseDecimalParameterItem parameter1 = new ClauseDecimalParameterItem() {
            {
                setName("betet_dij");
                setValue(new BigDecimal(50));            
            }
        };        
        
        parameterList.getClauseParameterItemBases().add(parameter1);
                
        clauseItem.setParameters(parameterList);

        //Záradék hozzádadása
       clauseItemList.getClauseItems().add(clauseItem);
       transaction.setClauses(clauseItemList);
              
        
       ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

       // Tételsor hozzáadása
       invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

       transaction.setLines(invoiceLines);

       transaction.setSendInvoiceToCustomer(false);

       transaction.setTransactionId(UUID.randomUUID().toString());
       return transaction;
    }
    
      /**
     * Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban
     * tárolt egyedi azonosítójuk alapján történik, a fizetési mód és pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszik fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek.
     *
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithDefaultsInvoiceClausesWithoutParametersTransaction() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        Customer customer = new Customer();

        customer.setName("Polisz Bt.");
        customer.setCustomerIdentifier("12312123");
        customer.setEUTaxNumber("HU33441234");
        customer.setTaxNumber("12345678-1-12");
        customer.setAddressPostalCode("1131");
        customer.setAddressCity("Budapest");
        customer.setAddressCountryId("HU");
        customer.setAddressLine1("Teve utca 1");
        customer.setAddressLine2("B épület, 12. em.");
        customer.setAddressState("Budapest");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        //Záradék lista létrehozása
        ArrayOfClauseItem clauseItemList = new ArrayOfClauseItem();
        
        //Záradék létrehozása
        ClauseItem clauseItem = new ClauseItem();
        clauseItem.setId("jov_eng_keresk_szla");
                
       //Záradék hozzádadása
       clauseItemList.getClauseItems().add(clauseItem);
       transaction.setClauses(clauseItemList);
              
        
       ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

       // Tételsor hozzáadása
       invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

       transaction.setLines(invoiceLines);

       transaction.setSendInvoiceToCustomer(false);

       transaction.setTransactionId(UUID.randomUUID().toString());
       return transaction;
    }
    
    /**
     * Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban
     * tárolt egyedi azonosítójuk alapján történik, a fizetési mód és pénznem a
     * számlatömbhöz tartozó alapértelmezett értéket veszik fel, a telephely
     * adatok a cég alapértelmezett telephely adatai lesznek.
     * Rendszer azonosító küldése. 
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateInvoiceTransaction getCreateInvoiceWithSourceSystem() throws DatatypeConfigurationException {

        CreateInvoiceTransaction transaction = new CreateInvoiceTransaction();

        InvoiceHeader header = new InvoiceHeader();

        // Vevő létrehozása
        CustomerIdentifier customer = new CustomerIdentifier();
        customer.setIdentifier("VEVO02");

        header.setCustomer(customer);

        // Számlatömb megadása
        header.setAccountBlockPrefix("TEST");

        // Bank beállítása, hivatkozás egy rögzített fizetési módra
        BankIdentifier bank = new BankIdentifier();
        bank.setIdentifier("TESTBANK01_ATUTALAS");

        header.setBank(bank);

        // Telephely beállítása (a számlatömb alapértelmezett telephelye)
        header.setIssuerAddress(new DefaultIssuerAddress());

        // Alapértelmezett pénznem megadása
        header.setCurrency(new DefaultCurrency());

        // Közösségen belüli adózás? Nem
        header.setInterEUVatExempt(false);

        // Számla megjegyzés
        header.setInvoiceDescription("Invoice description");

        // Egyéb adatok
        header.setNotes("Notes");

        // Megrendelésszám
        header.setOrderNumber("ORD00012");

        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(new Date());

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        gregorian.add(Calendar.DAY_OF_MONTH, 1);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);

        // Dátumok megadása
        header.setFulfillmentDate(now);
        header.setPaymentDueDate(now);

        transaction.setHeader(header);

        // Tételsor létrehozása
        //A PeriodStartDate és PeriodEndDate használata opcionális
        InvoiceLineIdentifier invoiceLine = new InvoiceLineIdentifier();

        invoiceLine.setIdentifier("TESTPRODUCT02");
        invoiceLine.setQuantity(new BigDecimal(1));
        invoiceLine.setPeriodStartDate(startDate);
        invoiceLine.setPeriodEndDate(endDate);

        ArrayOfInvoiceLine invoiceLines = new ArrayOfInvoiceLine();

        // Tételsor hozzáadása
        invoiceLines.getInvoiceLineBases().add((InvoiceLineBase) invoiceLine);

        transaction.setLines(invoiceLines);

        transaction.setSendInvoiceToCustomer(false);

        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setSourceSystem("SampleCode");
        return transaction;
    }

    
    /**
     * Nyugta létrehozása számla kiegyenlítéssel
     *
     * 
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateCashReceiptTransaction getCreateCashReceiptWithAllocatedPaymentTransaction() throws DatatypeConfigurationException {

        CreateCashReceiptTransaction transaction = new CreateCashReceiptTransaction();

        AllocatedPayment payment = new AllocatedPayment();
        
        payment.setBankIdentifier("BUDAPESTBANK");
        payment.setInvoiceNumber("BLF001");
        payment.setPaymentDate(new Date().toString());
        payment.setDescription("Megjegyzés");
        
        
        CashReceiptHeader cashReceiptHeader = new CashReceiptHeader();
        
        cashReceiptHeader.setCashReceiptBlockPrefix("ALCR");
        cashReceiptHeader.setCashierName("Pénztáros neve");
        cashReceiptHeader.setCreatorName("Kiállító neve");
        cashReceiptHeader.setContributorName("Befizető neve");
        cashReceiptHeader.setContributorDocument("Befizető okmánya");
        cashReceiptHeader.setDescription("Megjegyzés");
        
        transaction.setPayment(payment);
        transaction.setCashReceiptHeader(cashReceiptHeader);
        
        transaction.setTransactionId(UUID.randomUUID().toString());
        return transaction;
    }

    /**
     * Nyugta létrehozása befizetéssel
     *
     * 
     * @return 
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static CreateCashReceiptTransaction getCreateCashReceiptWithUnallocatedPaymentTransaction() throws DatatypeConfigurationException {

        CreateCashReceiptTransaction transaction = new CreateCashReceiptTransaction();

        UnallocatedPayment payment = new UnallocatedPayment();
    
        CurrencyShortName currency = new CurrencyShortName();
        currency.setShortName("HUF");
        
        CustomerIdentifier customer = new CustomerIdentifier();
        customer.setIdentifier("T1VEVO1");
        
        payment.setBankIdentifier("BUDAPESTBANK");
        payment.setPaymentTotal(new BigDecimal(3000));
        payment.setCurrency(currency);
        payment.setCustomer(customer);
        payment.setPaymentDate(new Date().toString());
        payment.setDescription("Megjegyzés");
        
        
        CashReceiptHeader cashReceiptHeader = new CashReceiptHeader();
        
        cashReceiptHeader.setCashReceiptBlockPrefix("ALCR");
        cashReceiptHeader.setCashierName("Pénztáros neve");
        cashReceiptHeader.setCreatorName("Kiállító neve");
        cashReceiptHeader.setContributorName("Befizető neve");
        cashReceiptHeader.setContributorDocument("Befizető okmánya");
        cashReceiptHeader.setDescription("Megjegyzés");
        
        transaction.setPayment(payment);
        transaction.setCashReceiptHeader(cashReceiptHeader);
        
        transaction.setTransactionId(UUID.randomUUID().toString());
        return transaction;
    }    
}
