
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadInvoicesQuery;


/**
 * <p>Java class for DownloadInvoicesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="DownloadInvoicesQuery" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoicesQuery"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesRequest", propOrder = {
    "downloadInvoicesQuery"
})
public class DownloadInvoicesRequest
    extends RequestBase
{

    @XmlElement(name = "DownloadInvoicesQuery", required = true, nillable = true)
    protected DownloadInvoicesQuery downloadInvoicesQuery;

    /**
     * Gets the value of the downloadInvoicesQuery property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInvoicesQuery }
     *     
     */
    public DownloadInvoicesQuery getDownloadInvoicesQuery() {
        return downloadInvoicesQuery;
    }

    /**
     * Sets the value of the downloadInvoicesQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInvoicesQuery }
     *     
     */
    public void setDownloadInvoicesQuery(DownloadInvoicesQuery value) {
        this.downloadInvoicesQuery = value;
    }

}
