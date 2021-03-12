/*
 *
 *
 *
 */
package billzonesample;

import datamodel.invoicing.billgate.billzone.ArrayOfAccountBlocksQueryResultItem;
import datamodel.invoicing.billgate.billzone.ArrayOfDownloadInvoicesQueryResultItem;
import datamodel.invoicing.billgate.billzone.ArrayOfIssuersQueryResultItem;
import datamodel.invoicing.billgate.billzone.ArrayOfPaymentMethodsQueryResultItem;
import datamodel.invoicing.billgate.billzone.ArrayOfUnitsQueryResultItem;
import datamodel.invoicing.billgate.billzone.ConvertExternalInvoiceTransaction;
import datamodel.invoicing.billgate.billzone.CreateCashReceiptTransaction;
import datamodel.invoicing.billgate.billzone.CreateInvoiceTransaction;
import datamodel.invoicing.billgate.billzone.DownloadCashReceiptQuery;
import datamodel.invoicing.billgate.billzone.DownloadCashReceiptQueryResult;
import datamodel.invoicing.billgate.billzone.DownloadInvoiceQuery;
import datamodel.invoicing.billgate.billzone.DownloadInvoiceQueryResult;
import datamodel.invoicing.billgate.billzone.DownloadInvoicesPeriodFilter;
import datamodel.invoicing.billgate.billzone.DownloadInvoicesQuery;
import datamodel.invoicing.billgate.billzone.DownloadInvoicesQueryResult;
import datamodel.invoicing.billgate.billzone.GetInvoiceDataQuery;
import datamodel.invoicing.billgate.billzone.GetInvoiceDataQueryResult;
import invoicing.billgate.billzone.IInvoicing;
import invoicing.billgate.billzone.InvoicingService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import messages.invoicing.billgate.billzone.ConvertExternalInvoiceRequest;
import messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse;
import messages.invoicing.billgate.billzone.CreateCashReceiptRequest;
import messages.invoicing.billgate.billzone.CreateCashReceiptResponse;
import messages.invoicing.billgate.billzone.CreateInvoiceRequest;
import messages.invoicing.billgate.billzone.CreateInvoiceResponse;
import messages.invoicing.billgate.billzone.DownloadCashReceiptRequest;
import messages.invoicing.billgate.billzone.DownloadCashReceiptResponse;
import messages.invoicing.billgate.billzone.DownloadInvoiceRequest;
import messages.invoicing.billgate.billzone.DownloadInvoiceResponse;
import messages.invoicing.billgate.billzone.DownloadInvoicesRequest;
import messages.invoicing.billgate.billzone.DownloadInvoicesResponse;
import messages.invoicing.billgate.billzone.GetInvoiceDataRequest;
import messages.invoicing.billgate.billzone.GetInvoiceDataResponse;

/**
 *
 *
 */
public class ResponseHelper {
    
    
 /**
 *  Számla létrehozása, hagyományos módon
 *
     * @param transaction
     * @return 
     * @throws java.net.MalformedURLException 
 */  
    public static CreateInvoiceResponse invokeCreateInvoice(CreateInvoiceTransaction transaction) throws MalformedURLException {


        
        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        CreateInvoiceRequest request = new CreateInvoiceRequest();

        // Új RequestId
        request.setRequestId(UUID.randomUUID().toString());

        request.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        // A kapott tranzakció átadása
        request.setCreateInvoiceTransaction(transaction);

        CreateInvoiceResponse response = client.createInvoice(request);

        // A kapott válasz visszaadása
        return response;
    }

 /**
 *  Külső számla befogadása
 *
     * @param transaction
     * @return 
 */ 
    public static ConvertExternalInvoiceResponse invokeConvertExternalInvoice(ConvertExternalInvoiceTransaction transaction) {

        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        ConvertExternalInvoiceRequest request = new ConvertExternalInvoiceRequest();

        // Új RequestId
        request.setRequestId(UUID.randomUUID().toString());

        request.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        // A kapott tranzakció átadása
        request.setConvertExternalInvoiceTransaction(transaction);

        ConvertExternalInvoiceResponse response = client.convertExternalInvoice(request);

        // A kapott válasz visszaadása
        return response;
    }

    /**
 *  Nyugta létrehozása
 *
     * @param transaction
     * @return 
 */  
    public static CreateCashReceiptResponse invokeCreateCashReceipt(CreateCashReceiptTransaction transaction){

        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();;

        CreateCashReceiptRequest request = new CreateCashReceiptRequest();

        // Új RequestId
        request.setRequestId(UUID.randomUUID().toString());

        request.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        // A kapott tranzakció átadása
        request.setCreateCashReceiptTransaction(transaction);

        CreateCashReceiptResponse response = client.createCashReceipt(request);

        // A kapott válasz visszaadása
        return response;
    }
    
 /**
 *  Adott számla letöltése
 *
     * @throws java.io.FileNotFoundException
 */ 
    public static void invokeDownloadInvoice(String invoiceNumber) throws FileNotFoundException, IOException {

        DownloadInvoiceQuery downloadQuery = new DownloadInvoiceQuery();

        //A letöltendő számla száma
        downloadQuery.setInvoiceNumber(invoiceNumber);

        DownloadInvoiceRequest downloadInvoiceRequest = new DownloadInvoiceRequest();

        downloadInvoiceRequest.setDownloadInvoiceQuery(downloadQuery);
       
        downloadInvoiceRequest.setRequestId(UUID.randomUUID().toString());
        
        downloadInvoiceRequest.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        DownloadInvoiceResponse downloadInvoiceReponse = client.downloadInvoice(downloadInvoiceRequest);

        DownloadInvoiceQueryResult result = downloadInvoiceReponse.getQueryResult();

        byte[] invoiceData = result.getInvoiceDocument();
        //InvoiceDocument fájlba mentése
        
        if (invoiceData != null) {
        FileOutputStream fs = new FileOutputStream("BLF0001.pdf");
        fs.write(invoiceData);
        fs.close();
        }              
    }

    
 /**
 *  Adott időszakban kiállított számlák letöltése
 *
     * @throws java.io.FileNotFoundException
     * @throws javax.xml.datatype.DatatypeConfigurationException
 */
    public static void invokeDownloadInvoices(XMLGregorianCalendar startDate, XMLGregorianCalendar endDate) throws FileNotFoundException, IOException, DatatypeConfigurationException {

        DownloadInvoicesQuery downloadQuery = new DownloadInvoicesQuery();

        DownloadInvoicesPeriodFilter downloadInvoicesPeriodFilter = new DownloadInvoicesPeriodFilter();

        //Szűrőfeltétel meghatározása
        downloadInvoicesPeriodFilter.setPeriodStart(startDate);
        downloadInvoicesPeriodFilter.setPeriodEnd(endDate);

        downloadQuery.setFilterSpecification(downloadInvoicesPeriodFilter);

        DownloadInvoicesRequest downloadInvoicesRequest = new DownloadInvoicesRequest();

        downloadInvoicesRequest.setDownloadInvoicesQuery(downloadQuery);
        
        downloadInvoicesRequest.setRequestId(UUID.randomUUID().toString());
        
        downloadInvoicesRequest.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        DownloadInvoicesResponse downloadInvoicesReponse = client.downloadInvoices(downloadInvoicesRequest);

        DownloadInvoicesQueryResult result = downloadInvoicesReponse.getQueryResult();

        ArrayOfDownloadInvoicesQueryResultItem invoices = result.getInvoices();

        //A kapott számlák fájlba mentése
        for (int i = 0; i < invoices.getDownloadInvoicesQueryResultItems().size(); i++) {
            
            if (invoices.getDownloadInvoicesQueryResultItems().get(i) != null) {
            FileOutputStream fs = new FileOutputStream(invoices.getDownloadInvoicesQueryResultItems().get(i).getInvoiceNumber() + ".pdf");

            fs.write(invoices.getDownloadInvoicesQueryResultItems().get(i).getInvoiceDocument());
            fs.close();
            }
        }
    }    
    
    /**
 *  Adott nyugta letöltése
 *
     * @throws java.io.FileNotFoundException
 */ 
    public static void invokeDownloadCashReceipt(String cashReceiptNumber) throws FileNotFoundException, IOException {

        DownloadCashReceiptQuery downloadQuery = new DownloadCashReceiptQuery();

        //A letöltendő nyugta száma
        downloadQuery.setCashReceiptNumber(cashReceiptNumber);

        DownloadCashReceiptRequest downloadCashReceiptRequest = new DownloadCashReceiptRequest();

        downloadCashReceiptRequest.setDownloadCashReceiptQuery(downloadQuery);
       
        downloadCashReceiptRequest.setRequestId(UUID.randomUUID().toString());
        
        downloadCashReceiptRequest.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        DownloadCashReceiptResponse downloadCashReceiptReponse = client.downloadCashReceipt(downloadCashReceiptRequest);

        DownloadCashReceiptQueryResult result = downloadCashReceiptReponse.getQueryResult();

        byte[] invoiceData = result.getCashReceiptDocument();
     
        //CashReceiptDocument fájlba mentése
        if (invoiceData != null) {
        FileOutputStream fs = new FileOutputStream("ALCR0001.pdf");
        fs.write(invoiceData);
        fs.close();
        }              
    }

    
    
    /**  Törzsadatok letöltése
    *
     * @throws java.io.FileNotFoundException
     * @throws javax.xml.bind.JAXBException
    */ 
    public static void invokeGetInvoiceData() throws FileNotFoundException, IOException, JAXBException {

        GetInvoiceDataQuery getInvoiceDataQuery = new GetInvoiceDataQuery();


        GetInvoiceDataRequest getInvoiceDataRequest = new GetInvoiceDataRequest();

        getInvoiceDataRequest.setGetInvoiceDataQuery(getInvoiceDataQuery);
       
        getInvoiceDataRequest.setRequestId(UUID.randomUUID().toString());
        
        getInvoiceDataRequest.setSecurityToken(ConfigHelper.getConfigValue("securityToken"));

       
        InvoicingService service = new InvoicingService();
        IInvoicing client = service.getBillgateInvoicingServiceHttpEndpoint();

        GetInvoiceDataResponse getInvoiceDataReponse = client.getInvoiceData(getInvoiceDataRequest);
        GetInvoiceDataQueryResult result = getInvoiceDataReponse.getQueryResult();

        JAXBContext unitContext = JAXBContext.newInstance(ArrayOfUnitsQueryResultItem.class);
        Marshaller mUnit = unitContext.createMarshaller();
        mUnit.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        mUnit.marshal(result.getUnits(), System.out);
        
        JAXBContext accountBlockContext = JAXBContext.newInstance(ArrayOfAccountBlocksQueryResultItem.class);
        Marshaller mAccount = accountBlockContext.createMarshaller();
        mAccount.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        mAccount.marshal(result.getAccountBlocks(), System.out);
        
        JAXBContext paymentMethodContext = JAXBContext.newInstance(ArrayOfPaymentMethodsQueryResultItem.class);
        Marshaller mPaymentMethod = paymentMethodContext.createMarshaller();
        mPaymentMethod.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        mPaymentMethod.marshal(result.getPaymentMethods(), System.out);
        
        JAXBContext issuerContext = JAXBContext.newInstance(ArrayOfIssuersQueryResultItem.class);
        Marshaller mIssuer = issuerContext.createMarshaller();
        mIssuer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        mIssuer.marshal(result.getPaymentMethods(), System.out);
    }
}
