
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.CreateCashReceiptTransactionResult;


/**
 * <p>Java class for CreateCashReceiptResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCashReceiptResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="TransactionResult" type="{http://Billzone.Billgate.Invoicing.DataModel}CreateCashReceiptTransactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCashReceiptResponse", propOrder = {
    "transactionResult"
})
public class CreateCashReceiptResponse
    extends ResponseBase
{

    @XmlElement(name = "TransactionResult", nillable = true)
    protected CreateCashReceiptTransactionResult transactionResult;

    /**
     * Gets the value of the transactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCashReceiptTransactionResult }
     *     
     */
    public CreateCashReceiptTransactionResult getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCashReceiptTransactionResult }
     *     
     */
    public void setTransactionResult(CreateCashReceiptTransactionResult value) {
        this.transactionResult = value;
    }

}
