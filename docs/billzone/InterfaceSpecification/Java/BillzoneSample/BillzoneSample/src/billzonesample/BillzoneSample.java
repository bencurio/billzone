/*
 *
 *
 *
 */
package billzonesample;

import datamodel.invoicing.billgate.billzone.ConvertExternalInvoiceTransactionResult;
import datamodel.invoicing.billgate.billzone.CreateCashReceiptTransactionResult;
import datamodel.invoicing.billgate.billzone.CreateInvoiceTransactionResult;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.console;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse;
import messages.invoicing.billgate.billzone.CreateCashReceiptResponse;
import messages.invoicing.billgate.billzone.CreateInvoiceResponse;

/**
 *
 * @author
 */
public class BillzoneSample {

    /**
     * A teszteléshez, a config.properties fájl "securityToken" értékeként szükséges megadni az adott céghez tartozó biztonsági azonosítót
     */
    public static void main(String[] args) throws DatatypeConfigurationException, IOException, FileNotFoundException, JAXBException {

        
        //Számla létrehozása alapértelmezett adatokkal
        CreateInvoiceResponse createInvoiceResult = ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithDefaultsTransaction());

        //Számla létrehozása alapértelmezett adatokkal, rendszerazonosító küldésével
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithSourceSystem());

        //Egyéb esetek számla létrehozáshoz
        //
        //Számla létrehozása egyedi adatokkal
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithBankIdentifierTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithCustomDataTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceVoidTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceCreditMemoTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceDebitMemoTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithDefaultsInvoiceLineClausesTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithDefaultsInvoiceClausesTransaction());
        //ResponseHelper.invokeCreateInvoice(TransactionHelper.getCreateInvoiceWithDefaultsInvoiceClausesWithoutParametersTransaction());
                     
               
        
                
        //Számla létrehozása (külső számla átvévele)
        //ConvertExternalInvoiceResponse convertExternalInvoiceResponse = ResponseHelper.invokeConvertExternalInvoice(TransactionHelper.getConvertExternalInvoiceTransaction());
        
        
        
        
        //Adott számla letöltése
        //ResponseHelper.invokeDownloadInvoice("BLF0001");

        
        
        //Adott időszakban kiállított számla letöltése
        //GregorianCalendar gregorian = new GregorianCalendar();
        //gregorian.add(Calendar.DAY_OF_MONTH, -10);
        //
        //XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
        //
        //gregorian.setTime(new Date());
        //XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
        //        
        //ResponseHelper.invokeDownloadInvoices(startDate, endDate);

        
        
        //Törzsadatok letöltése
        //ResponseHelper.invokeGetInvoiceData();
        
        
        
        
        String transactionResultCode;
                
        //Számla létrehozása
        CreateInvoiceTransactionResult transactionResult = null;
        
        if (createInvoiceResult.getTransactionResult() != null){
         transactionResult = createInvoiceResult.getTransactionResult();
        }
        
        if (transactionResult != null && transactionResult.getResultCode() != null) {
            transactionResultCode = transactionResult.getResultCode().getCode();
        } else {
            transactionResultCode = null;
        }

        System.out.println("Response (TransactionResult code): "+ transactionResultCode +"\nTransactionResult repeated: " +(transactionResult != null && transactionResult.isRepeatedTransaction())+ "\n");

              
               
        ////region Számla létrehozása (külső számla átvévele)
        //ConvertExternalInvoiceTransactionResult convertExternaltransactionResult = null;
        
        //if (convertExternalInvoiceResponse.getTransactionResult() != null){
        // convertExternaltransactionResult = convertExternalInvoiceResponse.getTransactionResult();
        //}
        
        //if (convertExternaltransactionResult != null && convertExternaltransactionResult.getResultCode() != null) {
        //    transactionResultCode = convertExternaltransactionResult.getResultCode().getCode();
        //} else {
        //    transactionResultCode = "null";
        //}
        //System.out.println("Response (TransactionResult code): "+ transactionResultCode +"\nTransactionResult repeated: " +(convertExternaltransactionResult != null && convertExternaltransactionResult.isRepeatedTransaction())+ "\n");
        ////endregion
        
        
        
        ////region Nyugta létrehozása
        //CreateCashReceiptTransactionResult transactionResult = null;
        
        //CreateCashReceiptResponse createCashReceiptResult = ResponseHelper.invokeCreateCashReceipt(TransactionHelper.getCreateCashReceiptWithAllocatedPaymentTransaction());
        //CreateCashReceiptResponse createCashReceiptResult = ResponseHelper.invokeCreateCashReceipt(TransactionHelper.getCreateCashReceiptWithUnallocatedPaymentTransaction());
                
        //if (createCashReceiptResult.getTransactionResult() != null){
        // transactionResult = createCashReceiptResult.getTransactionResult();
        // }
        
        //String transactionResultCode;
        
        //if (transactionResult != null && transactionResult.getResultCode() != null) {
        //    transactionResultCode = transactionResult.getResultCode().getCode();
        //} else {
        //    transactionResultCode = null;
        //}

        //System.out.println("Response (TransactionResult code): "+ transactionResultCode +"\nTransactionResult repeated: " +(transactionResult != null && transactionResult.isRepeatedTransaction())+ "\n");
        ////endregion   
        
        
        ////region Nyugta letöltése
        //ResponseHelper.invokeDownloadCashReceipt("ALCR0001");
        ////endregion  
        
        System.in.read();
    }   
}
