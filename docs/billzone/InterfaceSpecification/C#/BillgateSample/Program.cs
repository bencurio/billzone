using System;
using BillgateSample.Billgate;

namespace BillgateSample
{
    internal class Program
    {
        private static void Main()
        {
            try
            {
                //Számla létrehozása alapértelmezett adatokkal
                var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithDefaults());

                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithBankIdentifier());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithCustomData());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceVoid());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceCreditMemo());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceDebitMemo());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithLineClause());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithInvoiceClause());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithInvoiceClauseWithoutParameters());
                //var createInvoiceResult = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWitSourceSystem());

                string transactionResultCode;

                if (createInvoiceResult.TransactionResult != null && createInvoiceResult.TransactionResult.ResultCode != null)
                {
                    transactionResultCode = createInvoiceResult.TransactionResult.ResultCode.Code;
                }
                else
                {
                    transactionResultCode = createInvoiceResult.RequestResult.Code;
                }

                Console.WriteLine("Create invoice response (TransactionResult code): {0}\nTransactionResult repeated: {1}\n", transactionResultCode, createInvoiceResult.TransactionResult != null && createInvoiceResult.TransactionResult.RepeatedTransaction);




                //Számla létrehozása (külső számla átvévele)         
                //string transactionResultCode;

                //ResponseHelper.InvokeConvertExternalInvoice(TransactionHelper.ConvertExternalInvoice());

                //var convertExternalInvoiceResponse = new CreateInvoiceResponse();

                //convertExternalInvoiceResponse = ResponseHelper.InvokeCreateInvoice(TransactionHelper.CreateInvoiceWithLineClause());

                //if (convertExternalInvoiceResponse.TransactionResult != null && convertExternalInvoiceResponse.TransactionResult.ResultCode != null)
                //{
                //    transactionResultCode = convertExternalInvoiceResponse.TransactionResult.ResultCode.Code;
                //}
                //else
                //{
                //    transactionResultCode = convertExternalInvoiceResponse.RequestResult.Code;
                //}
                //Console.WriteLine("Convert external invoice response (TransactionResult code): {0}\nTransactionResult repeated: {1}\n", transactionResultCode, createInvoiceResult.TransactionResult != null && createInvoiceResult.TransactionResult.RepeatedTransaction);



                //Adott számla letöltése
                //var result = ResponseHelper.DownloadInvoice();
                //Console.WriteLine("Download invoice: " + (result ? "success" : "failed (invoice not found)"));



                //Adott időszakban kiállított számla letöltése
                //ResponseHelper.DownloadInvoices();



                //Törzsadatok lekérdezése
                //ResponseHelper.GetInvoiceData();



                //Nyugta létrehozása
                //var createCashReceiptResult = ResponseHelper.InvokeCreateCashReceipt(TransactionHelper.CreateCashReceiptWithAllocatedPayment());
                //var createCashReceiptResult = ResponseHelper.InvokeCreateCashReceipt(TransactionHelper.CreateCashReceiptWithUnallocatedPayment());

                //if (createCashReceiptResult.TransactionResult != null && createCashReceiptResult.TransactionResult.ResultCode != null)
                //{
                //    transactionResultCode = createCashReceiptResult.TransactionResult.ResultCode.Code;
                //}
                //else
                //{
                //    transactionResultCode = createCashReceiptResult.RequestResult.Code;
                //}

                //Console.WriteLine("Create cash receipt response (TransactionResult code): {0}\nTransactionResult repeated: {1}\n", transactionResultCode, createCashReceiptResult.TransactionResult != null && createCashReceiptResult.TransactionResult.RepeatedTransaction);



                //Adott nyugta letöltése
                //var result = ResponseHelper.DownloadCashReceipt();
                //Console.WriteLine("Download cash receipt: " + (result ? "success" : "failed (cash receipt not found)"));


                Console.ReadKey();
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
                Console.ReadKey();
            }
        }
    }
}

