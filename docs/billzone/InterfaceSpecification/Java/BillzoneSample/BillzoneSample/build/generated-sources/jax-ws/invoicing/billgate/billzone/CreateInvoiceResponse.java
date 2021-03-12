
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
 *         &lt;element name="CreateInvoiceResult" type="{http://Billzone.Billgate.Invoicing.Messages}CreateInvoiceResponse" minOccurs="0"/>
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
    "createInvoiceResult"
})
@XmlRootElement(name = "CreateInvoiceResponse")
public class CreateInvoiceResponse {

    @XmlElement(name = "CreateInvoiceResult", nillable = true)
    protected messages.invoicing.billgate.billzone.CreateInvoiceResponse createInvoiceResult;

    /**
     * Gets the value of the createInvoiceResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.CreateInvoiceResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.CreateInvoiceResponse getCreateInvoiceResult() {
        return createInvoiceResult;
    }

    /**
     * Sets the value of the createInvoiceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.CreateInvoiceResponse }
     *     
     */
    public void setCreateInvoiceResult(messages.invoicing.billgate.billzone.CreateInvoiceResponse value) {
        this.createInvoiceResult = value;
    }

}
