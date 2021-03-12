
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.GetInvoiceDataQueryResult;


/**
 * <p>Java class for GetInvoiceDataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInvoiceDataResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="QueryResult" type="{http://Billzone.Billgate.Invoicing.DataModel}GetInvoiceDataQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInvoiceDataResponse", propOrder = {
    "queryResult"
})
public class GetInvoiceDataResponse
    extends ResponseBase
{

    @XmlElement(name = "QueryResult", nillable = true)
    protected GetInvoiceDataQueryResult queryResult;

    /**
     * Gets the value of the queryResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetInvoiceDataQueryResult }
     *     
     */
    public GetInvoiceDataQueryResult getQueryResult() {
        return queryResult;
    }

    /**
     * Sets the value of the queryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInvoiceDataQueryResult }
     *     
     */
    public void setQueryResult(GetInvoiceDataQueryResult value) {
        this.queryResult = value;
    }

}
