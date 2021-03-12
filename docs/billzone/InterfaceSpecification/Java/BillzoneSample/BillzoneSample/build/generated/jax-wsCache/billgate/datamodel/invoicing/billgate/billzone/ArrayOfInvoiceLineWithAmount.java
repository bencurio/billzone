
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfInvoiceLineWithAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfInvoiceLineWithAmount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceLineWithAmount" type="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceLineWithAmount" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfInvoiceLineWithAmount", propOrder = {
    "invoiceLineWithAmounts"
})
public class ArrayOfInvoiceLineWithAmount {

    @XmlElement(name = "InvoiceLineWithAmount", nillable = true)
    protected List<InvoiceLineWithAmount> invoiceLineWithAmounts;

    /**
     * Gets the value of the invoiceLineWithAmounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceLineWithAmounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceLineWithAmounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineWithAmount }
     * 
     * 
     */
    public List<InvoiceLineWithAmount> getInvoiceLineWithAmounts() {
        if (invoiceLineWithAmounts == null) {
            invoiceLineWithAmounts = new ArrayList<InvoiceLineWithAmount>();
        }
        return this.invoiceLineWithAmounts;
    }

}
