
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
 *         &lt;element name="ConvertExternalInvoiceResult" type="{http://Billzone.Billgate.Invoicing.Messages}ConvertExternalInvoiceResponse" minOccurs="0"/>
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
    "convertExternalInvoiceResult"
})
@XmlRootElement(name = "ConvertExternalInvoiceResponse")
public class ConvertExternalInvoiceResponse {

    @XmlElement(name = "ConvertExternalInvoiceResult", nillable = true)
    protected messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse convertExternalInvoiceResult;

    /**
     * Gets the value of the convertExternalInvoiceResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse getConvertExternalInvoiceResult() {
        return convertExternalInvoiceResult;
    }

    /**
     * Sets the value of the convertExternalInvoiceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse }
     *     
     */
    public void setConvertExternalInvoiceResult(messages.invoicing.billgate.billzone.ConvertExternalInvoiceResponse value) {
        this.convertExternalInvoiceResult = value;
    }

}
