
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadInvoicesQueryResult;


/**
 * <p>Java class for DownloadInvoicesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="QueryResult" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoicesQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesResponse", propOrder = {
    "queryResult"
})
public class DownloadInvoicesResponse
    extends ResponseBase
{

    @XmlElement(name = "QueryResult", nillable = true)
    protected DownloadInvoicesQueryResult queryResult;

    /**
     * Gets the value of the queryResult property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInvoicesQueryResult }
     *     
     */
    public DownloadInvoicesQueryResult getQueryResult() {
        return queryResult;
    }

    /**
     * Sets the value of the queryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInvoicesQueryResult }
     *     
     */
    public void setQueryResult(DownloadInvoicesQueryResult value) {
        this.queryResult = value;
    }

}
