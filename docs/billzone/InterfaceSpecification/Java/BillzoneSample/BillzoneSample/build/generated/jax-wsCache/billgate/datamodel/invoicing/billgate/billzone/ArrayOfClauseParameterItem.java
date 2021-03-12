
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClauseParameterItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClauseParameterItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClauseParameterItemBase" type="{http://Billzone.Billgate.Invoicing.DataModel}ClauseParameterItemBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClauseParameterItem", propOrder = {
    "clauseParameterItemBases"
})
public class ArrayOfClauseParameterItem {

    @XmlElement(name = "ClauseParameterItemBase", nillable = true)
    protected List<ClauseParameterItemBase> clauseParameterItemBases;

    /**
     * Gets the value of the clauseParameterItemBases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clauseParameterItemBases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClauseParameterItemBases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseParameterItemBase }
     * 
     * 
     */
    public List<ClauseParameterItemBase> getClauseParameterItemBases() {
        if (clauseParameterItemBases == null) {
            clauseParameterItemBases = new ArrayList<ClauseParameterItemBase>();
        }
        return this.clauseParameterItemBases;
    }

}
