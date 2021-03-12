
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateCashReceiptTransactionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCashReceiptTransactionResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}TransactionResult">
 *       &lt;sequence>
 *         &lt;element name="CashReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCashReceiptTransactionResult", propOrder = {
    "cashReceiptNumber"
})
public class CreateCashReceiptTransactionResult
    extends TransactionResult
{

    @XmlElement(name = "CashReceiptNumber", nillable = true)
    protected String cashReceiptNumber;

    /**
     * Gets the value of the cashReceiptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashReceiptNumber() {
        return cashReceiptNumber;
    }

    /**
     * Sets the value of the cashReceiptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashReceiptNumber(String value) {
        this.cashReceiptNumber = value;
    }

}
