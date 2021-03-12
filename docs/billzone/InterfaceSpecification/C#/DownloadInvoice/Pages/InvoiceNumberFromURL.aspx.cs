using System;
using BillgateSample;

namespace DownloadInvoice.Pages
{
    public partial class InvoiceNumberFromUrl : System.Web.UI.Page
    {
        protected override void OnLoad(EventArgs e)
        {
            base.OnLoad(e);

            if (!IsPostBack && !String.IsNullOrEmpty(Request.Params["InvoiceNumber"]))
            {

                var invoiceNumber = Request.Params["InvoiceNumber"];

                var response = ResponseHelper.DownloadInvoice(invoiceNumber);


                if (response != null && response.InvoiceDocument != null)
                {
                    Response.ContentType = "Application/pdf";
                    Response.AppendHeader("Content-Disposition", "attachment;filename=" + response.InvoiceNumber + ".pdf");

                    Response.OutputStream.Write(response.InvoiceDocument, 0, response.InvoiceDocument.Length);
                }

                else
                {
                    Response.ContentType = "text/plain";
                    Response.Write(response != null ? "Eredmény kód: " + response.QueryResultCode : "");
                }
            }
        }
    }
}