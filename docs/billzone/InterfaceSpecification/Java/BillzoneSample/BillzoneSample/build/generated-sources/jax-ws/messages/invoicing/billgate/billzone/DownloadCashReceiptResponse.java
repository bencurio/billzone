
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.DownloadCashReceiptQueryResult;


/**
 * <p>Java class for DownloadCashReceiptResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadCashReceiptResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="QueryResult" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadCashReceiptQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadCashReceiptResponse", propOrder = {
    "queryResult"
})
public class DownloadCashReceiptResponse
    extends ResponseBase
{

    @XmlElement(name = "QueryResult", nillable = true)
    protected DownloadCashReceiptQueryResult queryResult;

    /**
     * Gets the value of the queryResult property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadCashReceiptQueryResult }
     *     
     */
    public DownloadCashReceiptQueryResult getQueryResult() {
        return queryResult;
    }

    /**
     * Sets the value of the queryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadCashReceiptQueryResult }
     *     
     */
    public void setQueryResult(DownloadCashReceiptQueryResult value) {
        this.queryResult = value;
    }

}
