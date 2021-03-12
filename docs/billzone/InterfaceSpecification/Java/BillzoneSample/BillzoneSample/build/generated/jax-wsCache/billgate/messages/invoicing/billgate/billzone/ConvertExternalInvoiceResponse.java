
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.ConvertExternalInvoiceTransactionResult;


/**
 * <p>Java class for ConvertExternalInvoiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConvertExternalInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="TransactionResult" type="{http://Billzone.Billgate.Invoicing.DataModel}ConvertExternalInvoiceTransactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConvertExternalInvoiceResponse", propOrder = {
    "transactionResult"
})
public class ConvertExternalInvoiceResponse
    extends ResponseBase
{

    @XmlElement(name = "TransactionResult", nillable = true)
    protected ConvertExternalInvoiceTransactionResult transactionResult;

    /**
     * Gets the value of the transactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ConvertExternalInvoiceTransactionResult }
     *     
     */
    public ConvertExternalInvoiceTransactionResult getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertExternalInvoiceTransactionResult }
     *     
     */
    public void setTransactionResult(ConvertExternalInvoiceTransactionResult value) {
        this.transactionResult = value;
    }

}
