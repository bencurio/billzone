
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateCashReceiptTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCashReceiptTransaction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}TransactionBase">
 *       &lt;sequence>
 *         &lt;element name="Payment" type="{http://Billzone.Billgate.Invoicing.DataModel}PaymentBase"/>
 *         &lt;element name="CashReceiptHeader" type="{http://Billzone.Billgate.Invoicing.DataModel}CashReceiptHeaderBase"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCashReceiptTransaction", propOrder = {
    "payment",
    "cashReceiptHeader"
})
public class CreateCashReceiptTransaction
    extends TransactionBase
{

    @XmlElement(name = "Payment", required = true, nillable = true)
    protected PaymentBase payment;
    @XmlElement(name = "CashReceiptHeader", required = true, nillable = true)
    protected CashReceiptHeaderBase cashReceiptHeader;

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentBase }
     *     
     */
    public PaymentBase getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentBase }
     *     
     */
    public void setPayment(PaymentBase value) {
        this.payment = value;
    }

    /**
     * Gets the value of the cashReceiptHeader property.
     * 
     * @return
     *     possible object is
     *     {@link CashReceiptHeaderBase }
     *     
     */
    public CashReceiptHeaderBase getCashReceiptHeader() {
        return cashReceiptHeader;
    }

    /**
     * Sets the value of the cashReceiptHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashReceiptHeaderBase }
     *     
     */
    public void setCashReceiptHeader(CashReceiptHeaderBase value) {
        this.cashReceiptHeader = value;
    }

}
