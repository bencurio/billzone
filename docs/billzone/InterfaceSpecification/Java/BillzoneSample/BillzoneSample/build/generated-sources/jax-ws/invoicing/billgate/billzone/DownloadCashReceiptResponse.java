
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
 *         &lt;element name="DownloadCashReceiptResult" type="{http://Billzone.Billgate.Invoicing.Messages}DownloadCashReceiptResponse" minOccurs="0"/>
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
    "downloadCashReceiptResult"
})
@XmlRootElement(name = "DownloadCashReceiptResponse")
public class DownloadCashReceiptResponse {

    @XmlElement(name = "DownloadCashReceiptResult", nillable = true)
    protected messages.invoicing.billgate.billzone.DownloadCashReceiptResponse downloadCashReceiptResult;

    /**
     * Gets the value of the downloadCashReceiptResult property.
     * 
     * @return
     *     possible object is
     *     {@link messages.invoicing.billgate.billzone.DownloadCashReceiptResponse }
     *     
     */
    public messages.invoicing.billgate.billzone.DownloadCashReceiptResponse getDownloadCashReceiptResult() {
        return downloadCashReceiptResult;
    }

    /**
     * Sets the value of the downloadCashReceiptResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link messages.invoicing.billgate.billzone.DownloadCashReceiptResponse }
     *     
     */
    public void setDownloadCashReceiptResult(messages.invoicing.billgate.billzone.DownloadCashReceiptResponse value) {
        this.downloadCashReceiptResult = value;
    }

}
