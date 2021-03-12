
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadInvoicesQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesQueryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}QueryResultBase">
 *       &lt;sequence>
 *         &lt;element name="Invoices" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfDownloadInvoicesQueryResultItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesQueryResult", propOrder = {
    "invoices"
})
public class DownloadInvoicesQueryResult
    extends QueryResultBase
{

    @XmlElement(name = "Invoices", nillable = true)
    protected ArrayOfDownloadInvoicesQueryResultItem invoices;

    /**
     * Gets the value of the invoices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDownloadInvoicesQueryResultItem }
     *     
     */
    public ArrayOfDownloadInvoicesQueryResultItem getInvoices() {
        return invoices;
    }

    /**
     * Sets the value of the invoices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDownloadInvoicesQueryResultItem }
     *     
     */
    public void setInvoices(ArrayOfDownloadInvoicesQueryResultItem value) {
        this.invoices = value;
    }

}
