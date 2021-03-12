using System;
using System.Configuration;
using System.IO;
using DomainModel.Invoice;
using BillgateSample.Billgate;

namespace BillgateSample
{
    public class ResponseHelper
    {
        /// <summary>
        /// Számla létrehozása
        /// </summary>
        /// <param name="transaction"></param>
        /// <returns></returns>
        public static CreateInvoiceResponse InvokeCreateInvoice(CreateInvoiceTransaction transaction)
        {
            // Request létrehozása
            var request = new CreateInvoiceRequest
            {
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"],
                CreateInvoiceTransaction = transaction
            };


            // Új RequestId
            // A kapott tranzakció átadása
            // Kliens létrehozása
            var client = new InvoicingClient();

            CreateInvoiceResponse result;

            try
            {
                // CreateInvoice meghívása
                result = client.CreateInvoice(request);
            }
            finally
            {
                // Kliens bezárása
                client.Close();
            }

            // A kapott válasz visszaadása
            return result;
        }


        /// <summary>
        /// Számla létrehozása
        /// </summary>
        /// <param name="transaction"></param>
        /// <returns></returns>
        public static ConvertExternalInvoiceResponse InvokeConvertExternalInvoice(ConvertExternalInvoiceTransaction transaction)
        {
            // Request létrehozása
            var request = new ConvertExternalInvoiceRequest
            {
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"],
                ConvertExternalInvoiceTransaction = transaction
            };


            // Új RequestId
            // A kapott tranzakció átadása
            // Kliens létrehozása
            var client = new InvoicingClient();

            ConvertExternalInvoiceResponse result;

            try
            {
                // ConvertExternalInvoice meghívása
                result = client.ConvertExternalInvoice(request);
            }
            finally
            {
                // Kliens bezárása
                client.Close();
            }

            // A kapott válasz visszaadása
            return result;
        }

        /// <summary>
        /// Nyugta létrehozása
        /// </summary>
        /// <param name="transaction"></param>
        /// <returns></returns>
        public static CreateCashReceiptResponse InvokeCreateCashReceipt(CreateCashReceiptTransaction transaction)
        {
            // Request létrehozása
            var request = new CreateCashReceiptRequest
            {
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"],
                CreateCashReceiptTransaction = transaction
            };


            // Új RequestId
            // A kapott tranzakció átadása
            // Kliens létrehozása
            var client = new InvoicingClient("BillgateInvoicingServiceHttpEndpoint");

            CreateCashReceiptResponse result;

            try
            {
                // CreateCashReceipt meghívása
                result = client.CreateCashReceipt(request);
            }
            finally
            {
                // Kliens bezárása
                client.Close();
            }

            // A kapott válasz visszaadása
            return result;
        }

        /// <summary>
        /// Adott számla letöltése
        /// 
        /// <param name="invoiceNumber">Ha nincs megadva invoiceNumber akkor alapértelmezetten "BLF0001" lesz</param> 
        /// </summary>
        public static DownloadInvoiceItem DownloadInvoice(string invoiceNumber)
        {
            // Szűrő feltétel létrehozása
            var downloadQuery = new DownloadInvoiceQuery { InvoiceNumber = invoiceNumber, DocumentType = "pdf"};

            // Request létrehozása
            var downloadInvoiceRequest = new DownloadInvoiceRequest
            {
                DownloadInvoiceQuery = downloadQuery,
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"]
            };

            var client = new InvoicingClient();

            // DownloadInvoices meghívása
            var downloadInvoiceReponse = client.DownloadInvoice(downloadInvoiceRequest);

            var downloadInvoiceQueryResult = downloadInvoiceReponse.QueryResult;

            DownloadInvoiceItem retVal;

            if (downloadInvoiceQueryResult != null && downloadInvoiceQueryResult.ResultCode != null)
            {
                retVal = new DownloadInvoiceItem { InvoiceDocument = downloadInvoiceReponse.QueryResult.InvoiceDocument, InvoiceNumber = downloadInvoiceReponse.QueryResult.InvoiceNumber, QueryResultCode = downloadInvoiceQueryResult.ResultCode.Code };
            }
            else
            {
                retVal = new DownloadInvoiceItem { QueryResultCode = downloadInvoiceReponse.RequestResult.Code };
            }
           
            return retVal;
        }

        /// <summary>
        /// Adott számla letöltése
        /// </summary>
        public static bool DownloadInvoice()
        {
            var retVal = false;

            var result = DownloadInvoice("TEST0001");

            //InvoiceDocument fájlba mentése
            if (result.InvoiceDocument != null)
            {
                File.WriteAllBytes(result.InvoiceNumber + ".pdf", result.InvoiceDocument);
                retVal = true;
            }

            return retVal;
        }

        /// <summary>
        /// Adott időszakban kiállított számlák letöltése
        /// </summary>
        internal static void DownloadInvoices()
        {
            // Szűrő feltétel létrehozása
            var downloadQuery = new DownloadInvoicesQuery();

            var downloadInvoicesPeriodFilter = new DownloadInvoicesPeriodFilter
            {
                PeriodStart = DateTime.Now.AddDays(-10),
                PeriodEnd = DateTime.Now
            };

            downloadQuery.FilterSpecification = downloadInvoicesPeriodFilter;

            // Request létrehozása
            var downloadInvoiceRequest = new DownloadInvoicesRequest
            {
                DownloadInvoicesQuery = downloadQuery,
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"]
            };

            var client = new InvoicingClient();

            // DownloadInvoices meghívása
            var downloadInvoiceReponse = client.DownloadInvoices(downloadInvoiceRequest);

            //InvoiceDocument-ek fájlba mentése
            foreach (var invoiceItem in downloadInvoiceReponse.QueryResult.Invoices)
            {
                if (invoiceItem.InvoiceDocument != null)
                {
                    File.WriteAllBytes(String.Format("{0}.pdf", invoiceItem.InvoiceNumber), invoiceItem.InvoiceDocument);
                }
            }
        }


        /// <summary>
        /// Kiállított nyugta letöltése
        /// </summary>
        internal static bool DownloadCashReceipt()
        {
            var retVal = false;

            // Szűrő feltétel létrehozása
            var downloadQuery = new DownloadCashReceiptQuery();
            
            downloadQuery.CashReceiptNumber = "ALCR0001";

            // Request létrehozása
            var downloadCashReceiptRequest = new DownloadCashReceiptRequest
            {
                DownloadCashReceiptQuery = downloadQuery,
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"]
            };

            var client = new InvoicingClient();

            // DownloadCashReceipt meghívása
            var downloadCashReceiptReponse = client.DownloadCashReceipt(downloadCashReceiptRequest);

            //Nyugta fájlba mentése
            if (downloadCashReceiptReponse.QueryResult.CashReceiptDocument != null)
            {
                File.WriteAllBytes(downloadCashReceiptReponse.QueryResult.CashReceiptNumber + ".pdf", downloadCashReceiptReponse.QueryResult.CashReceiptDocument);
                retVal = true;
            }

            return retVal;
        }

        /// <summary>
        /// Törzsadatok letöltése
        /// </summary>
        public static void GetInvoiceData()
        {

            // Request létrehozása
            var getInvoiceDataRequest = new GetInvoiceDataRequest
            {
                RequestId = Guid.NewGuid().ToString(),
                SecurityToken = ConfigurationManager.AppSettings["SecurityToken"],
                GetInvoiceDataQuery = new GetInvoiceDataQuery()
            };

            var client = new InvoicingClient();

            // GetInvoiceData meghívása
            var getInvoiceDataReponse = client.GetInvoiceData(getInvoiceDataRequest);

            //Törzsadatok XML-ként való fájlba mentése
            if (getInvoiceDataReponse != null)
            {
                var getInvoiceDataQueryResult = (getInvoiceDataReponse).QueryResult;
                
                if (getInvoiceDataQueryResult != null && getInvoiceDataQueryResult.ResultCode != null)
                {
                    if (getInvoiceDataQueryResult.Units != null)
                    {
                        var result = FileHelper.Serialize(getInvoiceDataQueryResult.Units);

                        FileHelper.SaveStreamToXml(result.ToString(), "Units");
                    }

                    if (getInvoiceDataQueryResult.AccountBlocks != null)
                    {
                        var result = FileHelper.Serialize(getInvoiceDataQueryResult.AccountBlocks);

                        FileHelper.SaveStreamToXml(result.ToString(), "AccountBlocks");
                    }

                    if (getInvoiceDataQueryResult.PaymentMethods != null)
                    {
                        var result = FileHelper.Serialize(getInvoiceDataQueryResult.PaymentMethods);

                        FileHelper.SaveStreamToXml(result.ToString(), "PaymentMethods");
                    }

                    if (getInvoiceDataQueryResult.Issuers != null)
                    {
                        var result = FileHelper.Serialize(getInvoiceDataQueryResult.Issuers);

                        FileHelper.SaveStreamToXml(result.ToString(), "Issuers");
                    }
                    
                    if (getInvoiceDataQueryResult.Taxes != null)
                    {
                        var result = FileHelper.Serialize(getInvoiceDataQueryResult.Taxes);

                        FileHelper.SaveStreamToXml(result.ToString(), "Taxes");
                    }
                }
            }
        }
    }
}
