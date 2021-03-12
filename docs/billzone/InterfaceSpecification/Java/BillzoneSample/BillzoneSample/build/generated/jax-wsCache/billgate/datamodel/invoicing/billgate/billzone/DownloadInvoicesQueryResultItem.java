
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadInvoicesQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesQueryResultItem", propOrder = {
    "invoiceNumber",
    "invoiceDocument"
})
public class DownloadInvoicesQueryResultItem {

    @XmlElement(name = "InvoiceNumber", nillable = true)
    protected String invoiceNumber;
    @XmlElement(name = "InvoiceDocument", nillable = true)
    protected byte[] invoiceDocument;

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the invoiceDocument property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getInvoiceDocument() {
        return invoiceDocument;
    }

    /**
     * Sets the value of the invoiceDocument property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setInvoiceDocument(byte[] value) {
        this.invoiceDocument = value;
    }

}
