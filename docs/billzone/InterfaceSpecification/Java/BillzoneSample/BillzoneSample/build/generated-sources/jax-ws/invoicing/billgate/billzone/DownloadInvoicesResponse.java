
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
 *         &lt;element name="DownloadInvoicesResult" type="{http://Billzone.Billgate.Invoicing.Messages}DownloadInvoicesResponse" minOccurs="0"/>
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
    "downloadInvoicesResult"
})
@XmlRootElement(name = "DownloadInvoicesResponse")
public class DownloadInvoicesResponse {

    @XmlElement(name = "DownloadInvoicesResult", nillable = true)
    protected messages.invoicing.billgate.billzone.DownloadInvoicesResponse downloadInvoicesResult;

    /**
     * Gets the value of the downloadInvoicesResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.DownloadInvoicesResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.DownloadInvoicesResponse getDownloadInvoicesResult() {
        return downloadInvoicesResult;
    }

    /**
     * Sets the value of the downloadInvoicesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.DownloadInvoicesResponse }
     *     
     */
    public void setDownloadInvoicesResult(messages.invoicing.billgate.billzone.DownloadInvoicesResponse value) {
        this.downloadInvoicesResult = value;
    }

}
