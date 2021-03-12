
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.CreateInvoiceTransactionResult;


/**
 * <p>Java class for CreateInvoiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="TransactionResult" type="{http://Billzone.Billgate.Invoicing.DataModel}CreateInvoiceTransactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateInvoiceResponse", propOrder = {
    "transactionResult"
})
public class CreateInvoiceResponse
    extends ResponseBase
{

    @XmlElement(name = "TransactionResult", nillable = true)
    protected CreateInvoiceTransactionResult transactionResult;

    /**
     * Gets the value of the transactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateInvoiceTransactionResult }
     *     
     */
    public CreateInvoiceTransactionResult getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateInvoiceTransactionResult }
     *     
     */
    public void setTransactionResult(CreateInvoiceTransactionResult value) {
        this.transactionResult = value;
    }

}
