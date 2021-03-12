
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.GetInvoiceDataQuery;


/**
 * <p>Java class for GetInvoiceDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInvoiceDataRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="GetInvoiceDataQuery" type="{http://Billzone.Billgate.Invoicing.DataModel}GetInvoiceDataQuery"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInvoiceDataRequest", propOrder = {
    "getInvoiceDataQuery"
})
public class GetInvoiceDataRequest
    extends RequestBase
{

    @XmlElement(name = "GetInvoiceDataQuery", required = true, nillable = true)
    protected GetInvoiceDataQuery getInvoiceDataQuery;

    /**
     * Gets the value of the getInvoiceDataQuery property.
     * 
     * @return
     *     possible object is
     *     {@link GetInvoiceDataQuery }
     *     
     */
    public GetInvoiceDataQuery getGetInvoiceDataQuery() {
        return getInvoiceDataQuery;
    }

    /**
     * Sets the value of the getInvoiceDataQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInvoiceDataQuery }
     *     
     */
    public void setGetInvoiceDataQuery(GetInvoiceDataQuery value) {
        this.getInvoiceDataQuery = value;
    }

}
