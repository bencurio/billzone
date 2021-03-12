
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClauseItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClauseItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClauseItem" type="{http://Billzone.Billgate.Invoicing.DataModel}ClauseItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClauseItem", propOrder = {
    "clauseItems"
})
public class ArrayOfClauseItem {

    @XmlElement(name = "ClauseItem", nillable = true)
    protected List<ClauseItem> clauseItems;

    /**
     * Gets the value of the clauseItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clauseItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClauseItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseItem }
     * 
     * 
     */
    public List<ClauseItem> getClauseItems() {
        if (clauseItems == null) {
            clauseItems = new ArrayList<ClauseItem>();
        }
        return this.clauseItems;
    }

}
