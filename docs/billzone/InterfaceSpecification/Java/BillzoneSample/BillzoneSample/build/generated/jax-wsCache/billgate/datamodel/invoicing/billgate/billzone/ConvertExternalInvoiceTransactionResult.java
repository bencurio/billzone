
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConvertExternalInvoiceTransactionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConvertExternalInvoiceTransactionResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}TransactionResult">
 *       &lt;sequence>
 *         &lt;element name="InvoiceCourierUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConvertExternalInvoiceTransactionResult", propOrder = {
    "invoiceCourierUrl"
})
public class ConvertExternalInvoiceTransactionResult
    extends TransactionResult
{

    @XmlElement(name = "InvoiceCourierUrl", nillable = true)
    protected String invoiceCourierUrl;

    /**
     * Gets the value of the invoiceCourierUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceCourierUrl() {
        return invoiceCourierUrl;
    }

    /**
     * Sets the value of the invoiceCourierUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceCourierUrl(String value) {
        this.invoiceCourierUrl = value;
    }

}
