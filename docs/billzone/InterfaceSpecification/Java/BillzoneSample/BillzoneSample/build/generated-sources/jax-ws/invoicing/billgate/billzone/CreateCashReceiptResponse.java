
package invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateCashReceiptResult" type="{http://Billzone.Billgate.Invoicing.Messages}CreateCashReceiptResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createCashReceiptResult"
})
@XmlRootElement(name = "CreateCashReceiptResponse")
public class CreateCashReceiptResponse {

    @XmlElement(name = "CreateCashReceiptResult", nillable = true)
    protected messages.invoicing.billgate.billzone.CreateCashReceiptResponse createCashReceiptResult;

    /**
     * Gets the value of the createCashReceiptResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.CreateCashReceiptResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.CreateCashReceiptResponse getCreateCashReceiptResult() {
        return createCashReceiptResult;
    }

    /**
     * Sets the value of the createCashReceiptResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.CreateCashReceiptResponse }
     *     
     */
    public void setCreateCashReceiptResult(messages.invoicing.billgate.billzone.CreateCashReceiptResponse value) {
        this.createCashReceiptResult = value;
    }

}
