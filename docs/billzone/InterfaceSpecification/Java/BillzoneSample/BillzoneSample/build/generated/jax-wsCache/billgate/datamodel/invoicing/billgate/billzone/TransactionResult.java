
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResultCode" type="{http://Billzone.Billgate.Invoicing.DataModel}ResultCode"/>
 *         &lt;element name="RepeatedTransaction" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionResult", propOrder = {
    "transactionId",
    "resultCode",
    "repeatedTransaction"
})
@XmlSeeAlso({
    ConvertExternalInvoiceTransactionResult.class,
    CreateInvoiceTransactionResult.class,
    CreateCashReceiptTransactionResult.class
})
public class TransactionResult {

    @XmlElement(name = "TransactionId", required = true, nillable = true)
    protected String transactionId;
    @XmlElement(name = "ResultCode", required = true, nillable = true)
    protected ResultCode resultCode;
    @XmlElement(name = "RepeatedTransaction")
    protected boolean repeatedTransaction;

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResultCode }
     *     
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultCode }
     *     
     */
    public void setResultCode(ResultCode value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the repeatedTransaction property.
     * 
     */
    public boolean isRepeatedTransaction() {
        return repeatedTransaction;
    }

    /**
     * Sets the value of the repeatedTransaction property.
     * 
     */
    public void setRepeatedTransaction(boolean value) {
        this.repeatedTransaction = value;
    }

}
