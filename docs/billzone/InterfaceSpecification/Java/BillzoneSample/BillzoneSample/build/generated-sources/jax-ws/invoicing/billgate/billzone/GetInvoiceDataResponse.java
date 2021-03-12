
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
 *         &lt;element name="GetInvoiceDataResult" type="{http://Billzone.Billgate.Invoicing.Messages}GetInvoiceDataResponse" minOccurs="0"/>
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
    "getInvoiceDataResult"
})
@XmlRootElement(name = "GetInvoiceDataResponse")
public class GetInvoiceDataResponse {

    @XmlElement(name = "GetInvoiceDataResult", nillable = true)
    protected messages.invoicing.billgate.billzone.GetInvoiceDataResponse getInvoiceDataResult;

    /**
     * Gets the value of the getInvoiceDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.GetInvoiceDataResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.GetInvoiceDataResponse getGetInvoiceDataResult() {
        return getInvoiceDataResult;
    }

    /**
     * Sets the value of the getInvoiceDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.GetInvoiceDataResponse }
     *     
     */
    public void setGetInvoiceDataResult(messages.invoicing.billgate.billzone.GetInvoiceDataResponse value) {
        this.getInvoiceDataResult = value;
    }

}
