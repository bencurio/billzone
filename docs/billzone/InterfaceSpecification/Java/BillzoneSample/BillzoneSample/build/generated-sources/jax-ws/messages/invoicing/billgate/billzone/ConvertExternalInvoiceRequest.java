
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.ConvertExternalInvoiceTransaction;


/**
 * <p>Java class for ConvertExternalInvoiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConvertExternalInvoiceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="ConvertExternalInvoiceTransaction" type="{http://Billzone.Billgate.Invoicing.DataModel}ConvertExternalInvoiceTransaction"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConvertExternalInvoiceRequest", propOrder = {
    "convertExternalInvoiceTransaction"
})
public class ConvertExternalInvoiceRequest
    extends RequestBase
{

    @XmlElement(name = "ConvertExternalInvoiceTransaction", required = true, nillable = true)
    protected ConvertExternalInvoiceTransaction convertExternalInvoiceTransaction;

    /**
     * Gets the value of the convertExternalInvoiceTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link ConvertExternalInvoiceTransaction }
     *     
     */
    public ConvertExternalInvoiceTransaction getConvertExternalInvoiceTransaction() {
        return convertExternalInvoiceTransaction;
    }

    /**
     * Sets the value of the convertExternalInvoiceTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertExternalInvoiceTransaction }
     *     
     */
    public void setConvertExternalInvoiceTransaction(ConvertExternalInvoiceTransaction value) {
        this.convertExternalInvoiceTransaction = value;
    }

}
