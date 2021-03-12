
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadInvoiceQueryResult;


/**
 * <p>Java class for DownloadInvoiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="QueryResult" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoiceQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoiceResponse", propOrder = {
    "queryResult"
})
public class DownloadInvoiceResponse
    extends ResponseBase
{

    @XmlElement(name = "QueryResult", nillable = true)
    protected DownloadInvoiceQueryResult queryResult;

    /**
     * Gets the value of the queryResult property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInvoiceQueryResult }
     *     
     */
    public DownloadInvoiceQueryResult getQueryResult() {
        return queryResult;
    }

    /**
     * Sets the value of the queryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInvoiceQueryResult }
     *     
     */
    public void setQueryResult(DownloadInvoiceQueryResult value) {
        this.queryResult = value;
    }

}
