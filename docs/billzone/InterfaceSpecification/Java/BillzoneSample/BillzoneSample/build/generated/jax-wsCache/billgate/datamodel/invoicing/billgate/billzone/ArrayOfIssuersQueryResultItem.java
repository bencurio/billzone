
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIssuersQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIssuersQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssuersQueryResultItem" type="{http://Billzone.Billgate.Invoicing.DataModel}IssuersQueryResultItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIssuersQueryResultItem", propOrder = {
    "issuersQueryResultItems"
})
public class ArrayOfIssuersQueryResultItem {

    @XmlElement(name = "IssuersQueryResultItem", nillable = true)
    protected List<IssuersQueryResultItem> issuersQueryResultItems;

    /**
     * Gets the value of the issuersQueryResultItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the issuersQueryResultItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIssuersQueryResultItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IssuersQueryResultItem }
     * 
     * 
     */
    public List<IssuersQueryResultItem> getIssuersQueryResultItems() {
        if (issuersQueryResultItems == null) {
            issuersQueryResultItems = new ArrayList<IssuersQueryResultItem>();
        }
        return this.issuersQueryResultItems;
    }

}
