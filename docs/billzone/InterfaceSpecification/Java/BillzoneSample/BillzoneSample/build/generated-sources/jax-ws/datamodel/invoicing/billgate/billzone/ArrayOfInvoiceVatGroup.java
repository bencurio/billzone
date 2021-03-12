
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfInvoiceVatGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfInvoiceVatGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceVatGroup" type="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceVatGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfInvoiceVatGroup", propOrder = {
    "invoiceVatGroups"
})
public class ArrayOfInvoiceVatGroup {

    @XmlElement(name = "InvoiceVatGroup", nillable = true)
    protected List<InvoiceVatGroup> invoiceVatGroups;

    /**
     * Gets the value of the invoiceVatGroups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceVatGroups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceVatGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceVatGroup }
     * 
     * 
     */
    public List<InvoiceVatGroup> getInvoiceVatGroups() {
        if (invoiceVatGroups == null) {
            invoiceVatGroups = new ArrayList<InvoiceVatGroup>();
        }
        return this.invoiceVatGroups;
    }

}
