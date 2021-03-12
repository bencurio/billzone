
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadInvoiceQuery;


/**
 * <p>Java class for DownloadInvoiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoiceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="DownloadInvoiceQuery" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoiceQuery"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoiceRequest", propOrder = {
    "downloadInvoiceQuery"
})
public class DownloadInvoiceRequest
    extends RequestBase
{

    @XmlElement(name = "DownloadInvoiceQuery", required = true, nillable = true)
    protected DownloadInvoiceQuery downloadInvoiceQuery;

    /**
     * Gets the value of the downloadInvoiceQuery property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInvoiceQuery }
     *     
     */
    public DownloadInvoiceQuery getDownloadInvoiceQuery() {
        return downloadInvoiceQuery;
    }

    /**
     * Sets the value of the downloadInvoiceQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInvoiceQuery }
     *     
     */
    public void setDownloadInvoiceQuery(DownloadInvoiceQuery value) {
        this.downloadInvoiceQuery = value;
    }

}
