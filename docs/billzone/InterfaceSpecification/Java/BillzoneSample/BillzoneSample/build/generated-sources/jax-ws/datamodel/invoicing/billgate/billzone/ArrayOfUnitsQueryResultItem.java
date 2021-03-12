
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUnitsQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUnitsQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitsQueryResultItem" type="{http://Billzone.Billgate.Invoicing.DataModel}UnitsQueryResultItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUnitsQueryResultItem", propOrder = {
    "unitsQueryResultItems"
})
public class ArrayOfUnitsQueryResultItem {

    @XmlElement(name = "UnitsQueryResultItem", nillable = true)
    protected List<UnitsQueryResultItem> unitsQueryResultItems;

    /**
     * Gets the value of the unitsQueryResultItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitsQueryResultItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitsQueryResultItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitsQueryResultItem }
     * 
     * 
     */
    public List<UnitsQueryResultItem> getUnitsQueryResultItems() {
        if (unitsQueryResultItems == null) {
            unitsQueryResultItems = new ArrayList<UnitsQueryResultItem>();
        }
        return this.unitsQueryResultItems;
    }

}
