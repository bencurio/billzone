
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadCashReceiptQuery;


/**
 * <p>Java class for DownloadCashReceiptRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadCashReceiptRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="DownloadCashReceiptQuery" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadCashReceiptQuery"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadCashReceiptRequest", propOrder = {
    "downloadCashReceiptQuery"
})
public class DownloadCashReceiptRequest
    extends RequestBase
{

    @XmlElement(name = "DownloadCashReceiptQuery", required = true, nillable = true)
    protected DownloadCashReceiptQuery downloadCashReceiptQuery;

    /**
     * Gets the value of the downloadCashReceiptQuery property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadCashReceiptQuery }
     *     
     */
    public DownloadCashReceiptQuery getDownloadCashReceiptQuery() {
        return downloadCashReceiptQuery;
    }

    /**
     * Sets the value of the downloadCashReceiptQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadCashReceiptQuery }
     *     
     */
    public void setDownloadCashReceiptQuery(DownloadCashReceiptQuery value) {
        this.downloadCashReceiptQuery = value;
    }

}
