
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
 *         &lt;element name="DownloadInvoiceResult" type="{http://Billzone.Billgate.Invoicing.Messages}DownloadInvoiceResponse" minOccurs="0"/>
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
    "downloadInvoiceResult"
})
@XmlRootElement(name = "DownloadInvoiceResponse")
public class DownloadInvoiceResponse {

    @XmlElement(name = "DownloadInvoiceResult", nillable = true)
    protected messages.invoicing.billgate.billzone.DownloadInvoiceResponse downloadInvoiceResult;

    /**
     * Gets the value of the downloadInvoiceResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.DownloadInvoiceResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.DownloadInvoiceResponse getDownloadInvoiceResult() {
        return downloadInvoiceResult;
    }

    /**
     * Sets the value of the downloadInvoiceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.DownloadInvoiceResponse }
     *     
     */
    public void setDownloadInvoiceResult(messages.invoicing.billgate.billzone.DownloadInvoiceResponse value) {
        this.downloadInvoiceResult = value;
    }

}
