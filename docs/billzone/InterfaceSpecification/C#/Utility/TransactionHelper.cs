using System;
using System.Collections.Generic;
using BillgateSample.Billgate;

namespace BillgateSample
{
    public class TransactionHelper
    {
        /// <summary>
        /// Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a fizetési mód és pénznem a számlatömbhöz tartozó alapértelmezett értéket veszik fel, 
        /// a telephely adatok a cég alapértelmezett telephely adatai lesznek. 
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithDefaults()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };


            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }

        /// <summary>
        /// Számla létrehozása tranzakció, a termékek és fizetési mód meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a pénznem a számlatömbhöz tartozó alapértelmezett értéket veszi fel, 
        /// a telephely adatok a cég alapértelmezett telephely adatai lesznek
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithBankIdentifier()
        {

            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier {Identifier = "TESTBANK01_ATUTALAS"};
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };

            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }


        /// <summary>
        /// Számla létrehozása tranzakció, a fizetési mód, telephely és pénznem meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a számlatétel adatok egyedi értékeket vesznek fel.
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithCustomData()
        {

            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier {Identifier = "TESTBANK01_ATUTALAS"};

            // Telephely beállítása azonosító alapján
            var issuer = new IssuerAddressIdentifier {Identifier = "TESTTELEPHELY01"};

            // Pénznem beállítása azonosító alapján
            var currency = new CurrencyShortName {ShortName = "HUF"};

            header.Bank = bank;
            header.IssuerAddress = issuer;
            header.Currency = currency;

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLine2
                {
                    ProductStatisticalCode = "88.69.72",
                    ProductName = "Teszt termék 1",
                    NetUnitPrice = 7990,
                    Quantity = new decimal(27.5),
                    VatTaxRateCode = "27",
                    UnitIdentifier = "T1METER",
                    ProductTextIdentifier = "TESZTT123",
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                },
                new InvoiceLine2
                {
                    ProductStatisticalCode = "77.69.72",
                    ProductName = "Teszt termék 2",
                    NetUnitPrice = 6000,
                    Quantity = 1,
                    VatTaxRateCode = "27",
                    UnitIdentifier = "T1METER",
                    ProductTextIdentifier = "TESZTT124",
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };


            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }

        /// <summary>
        /// Sztornó számla létrehozása tranzakció.
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceVoid()
        {

            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            //Hivatkozott számlaszám
            header.ReferenceInvoiceNumber = "TEST0001";

            //Számla típusa: Stornó
            header.InvoiceDocumentType = 2;

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = -1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };


            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;

        }


        /// <summary>
        /// Jóváíró számla létrehozása tranzakció.
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceCreditMemo()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            //Hivatkozott számlaszám
            header.ReferenceInvoiceNumber = "TEST0001";

            //Számla típusa: Stornó
            header.InvoiceDocumentType = 3;

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = -2,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };


            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }

        /// <summary>
        /// Módosító számla létrehozása tranzakció.
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceDebitMemo()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            //Hivatkozott számlaszám
            header.ReferenceInvoiceNumber = "TEST0001";

            //Számla típusa: Stornó
            header.InvoiceDocumentType = 4;

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 3,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };

            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }


        /// <summary>
        /// Számla létrehozása tranzakció, amely tartalmazza a számla fejadatait, a számla tételeit, 
        /// a számla végösszegével és adótartalmával kapcsolatos adatait, illetve a számlaértesítővel kapcsolatos adatokat.
        /// </summary>
        /// <returns></returns>
        internal static ConvertExternalInvoiceTransaction ConvertExternalInvoice()
        {
            var result = new ConvertExternalInvoiceTransaction();

            var header = new InvoiceHeaderWithTotalAmount();

            // Vevő létrehozása
            var customer = new Customer
            {
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressPostalCode = "1131",
                AddressState = "",
                Name = "Polisz Bt."
            };

            header.Customer = customer;

            // Számlatömb megadása
            header.AccountBlockPrefix = "UNMT";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();
            // Pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;
            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description\r\ntöbb sorban\r\nInvoice description vége";
            // Egyéb adatok
            header.Notes = "NOTES";
            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date.AddDays(5);
            header.PaymentDueDate = DateTime.Now.Date.AddDays(15);

            //Számla végösszeg és adótartalom megadása
            header.InvoiceNetTotalAmount = 1000;
            header.InvoiceGrossTotalAmount = 1270;
            header.InvoiceVatTotalAmount = 270;

            //A számlával típusa mező megadása
            header.InvoiceDocumentType = 1;
            //Számlaszám megadása
            header.InvoiceNumber = "XX0002";

            result.Header = header;
            
            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            var invoiceLines = new List<InvoiceLineWithAmount>
            {
                new InvoiceLineWithAmount
                {

                    ProductStatisticalCode = "88.69.72",
                    ProductName = "Teszt termék 1",
                    NetUnitPrice = 7990,
                    Quantity = new decimal(27.5),
                    VatTaxRateCode = "27",
                    UnitIdentifier = "T1METER",
                    ProductTextIdentifier = "TESZTT123",
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };

            result.Lines = invoiceLines.ToArray();


            //Adócsoport hozzáadása
            var vatGroups = new List<InvoiceVatGroup>
            {
                new InvoiceVatGroup
                {
                    VatTaxRateCode = "27",
                    NetAmount = 1000,
                    GrossAmount = 1270,
                    VatAmount = 270
                }

            };
            
            result.VatGroups = vatGroups.ToArray();
            
            result.TransactionId = Guid.NewGuid().ToString();

            return result;
        }

        /// <summary>
        /// Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a fizetési mód és pénznem a számlatömbhöz tartozó alapértelmezett értéket veszik fel, 
        /// a telephely adatok a cég alapértelmezett telephely adatai lesznek. 
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithLineClause()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            transaction.Header = header;

            //Számla tétel záradék lista létrehozása
            var clauseList = new List<ClauseItem>
            {
                new ClauseItem
                {
                    Id = "CLAUSE_1",
                    Parameters = new ArrayOfClauseParameterItem
                    {
                        new ClauseStringParameterItem
                        {
                            Name = "parameter_1",
                            Value = "Paraméter érték"
                        },
                        new ClauseStringParameterItem
                        {
                            Name = "parameter_2",
                            Value = "Paraméter érték"
                        }
                    }
                }
            };

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15),
                    Clauses = clauseList.ToArray()
                }
            };
            

            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }

        /// <summary>
        /// Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a fizetési mód és pénznem a számlatömbhöz tartozó alapértelmezett értéket veszik fel, 
        /// a telephely adatok a cég alapértelmezett telephely adatai lesznek. 
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithInvoiceClause()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            //Számla záradék lista létrehozása
            var clauseList = new List<ClauseItem>
            {
                new ClauseItem
                {
                    Id = "CLAUSE_1",
                    Parameters = new ArrayOfClauseParameterItem
                    {
                        new ClauseStringParameterItem
                        {
                            Name = "parameter_1",
                            Value = "Paraméter érték"
                        },
                        new ClauseStringParameterItem
                        {
                            Name = "parameter_2",
                            Value = "Paraméter érték"
                        }
                    }
                }
            };

            transaction.Clauses = clauseList.ToArray();

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };

            
            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }

        /// <summary>
        /// Számla létrehozása tranzakció, a termékek meghatározása a törzsadatokban tárolt egyedi azonosítójuk alapján történik, 
        /// a fizetési mód és pénznem a számlatömbhöz tartozó alapértelmezett értéket veszik fel, 
        /// a telephely adatok a cég alapértelmezett telephely adatai lesznek. 
        /// </summary>
        /// <returns></returns>
        internal static CreateInvoiceTransaction CreateInvoiceWithInvoiceClauseWithoutParameters()
        {
            var transaction = new CreateInvoiceTransaction();

            var header = new InvoiceHeader();

            // Vevő létrehozása
            var customer = new Customer
            {
                Name = "Polisz Bt.",
                CustomerIdentifier = "12312123sdf",
                EUTaxNumber = "HU33441234",
                TaxNumber = "12345678-1-12",
                AddressPostalCode = "1131",
                AddressCity = "Budapest",
                AddressCountryId = "HU",
                AddressLine1 = "Teve utca 1",
                AddressLine2 = "B épület, 12. em.",
                AddressState = "Budapest"
            };

            header.Customer = customer;


            // Számlatömb megadása
            header.AccountBlockPrefix = "TEST";

            // Bank beállítása, hivatkozás egy rögzített fizetési módra
            var bank = new BankIdentifier { Identifier = "TESTBANK01_ATUTALAS" };
            header.Bank = bank;

            // Telephely beállítása (a számlatömb alapértelmezett telephelye)
            header.IssuerAddress = new DefaultIssuerAddress();

            // Alapértelmezett pénznem megadása                      
            header.Currency = new DefaultCurrency();

            // Közösségen belüli adózás? Nem
            header.InterEUVatExempt = false;

            // Számla megjegyzés
            header.InvoiceDescription = "Invoice description";

            // Egyéb adatok
            header.Notes = "Notes";

            // Megrendelésszám
            header.OrderNumber = "ORD00012";

            // Dátumok megadása
            header.FulfillmentDate = DateTime.Now.Date;
            header.PaymentDueDate = DateTime.Now.Date;

            //Számla záradék lista létrehozása
            var clauseList = new List<ClauseItem>
            {
                new ClauseItem
                {
                    Id = "CLAUSE_1"
                }
            };

            transaction.Clauses = clauseList.ToArray();

            transaction.Header = header;

            // Tételsor hozzáadása
            //A PeriodStartDate és PeriodEndDate használata opcionális
            transaction.Lines = new ArrayOfInvoiceLine
            {
                new InvoiceLineIdentifier
                {
                    Identifier = "TESTPRODUCT02",
                    Quantity = 1,
                    PeriodStartDate = DateTime.Now,
                    PeriodEndDate = DateTime.Now.AddDays(15)
                }
            };


            transaction.SendInvoiceToCustomer = false;

            transaction.TransactionId = Guid.NewGuid().ToString();

            return transaction;
        }
    }
}

