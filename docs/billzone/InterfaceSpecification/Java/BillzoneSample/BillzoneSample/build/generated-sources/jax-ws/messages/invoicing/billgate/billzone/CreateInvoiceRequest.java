
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.CreateInvoiceTransaction;


/**
 * <p>Java class for CreateInvoiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateInvoiceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="CreateInvoiceTransaction" type="{http://Billzone.Billgate.Invoicing.DataModel}CreateInvoiceTransaction"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateInvoiceRequest", propOrder = {
    "createInvoiceTransaction"
})
public class CreateInvoiceRequest
    extends RequestBase
{

    @XmlElement(name = "CreateInvoiceTransaction", required = true, nillable = true)
    protected CreateInvoiceTransaction createInvoiceTransaction;

    /**
     * Gets the value of the createInvoiceTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link CreateInvoiceTransaction }
     *     
     */
    public CreateInvoiceTransaction getCreateInvoiceTransaction() {
        return createInvoiceTransaction;
    }

    /**
     * Sets the value of the createInvoiceTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateInvoiceTransaction }
     *     
     */
    public void setCreateInvoiceTransaction(CreateInvoiceTransaction value) {
        this.createInvoiceTransaction = value;
    }

}
