
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfInvoiceLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfInvoiceLine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceLineBase" type="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceLineBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfInvoiceLine", propOrder = {
    "invoiceLineBases"
})
public class ArrayOfInvoiceLine {

    @XmlElement(name = "InvoiceLineBase", nillable = true)
    protected List<InvoiceLineBase> invoiceLineBases;

    /**
     * Gets the value of the invoiceLineBases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceLineBases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceLineBases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineBase }
     * 
     * 
     */
    public List<InvoiceLineBase> getInvoiceLineBases() {
        if (invoiceLineBases == null) {
            invoiceLineBases = new ArrayList<InvoiceLineBase>();
        }
        return this.invoiceLineBases;
    }

}
