
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDownloadInvoicesQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDownloadInvoicesQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DownloadInvoicesQueryResultItem" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoicesQueryResultItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDownloadInvoicesQueryResultItem", propOrder = {
    "downloadInvoicesQueryResultItems"
})
public class ArrayOfDownloadInvoicesQueryResultItem {

    @XmlElement(name = "DownloadInvoicesQueryResultItem", nillable = true)
    protected List<DownloadInvoicesQueryResultItem> downloadInvoicesQueryResultItems;

    /**
     * Gets the value of the downloadInvoicesQueryResultItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the downloadInvoicesQueryResultItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDownloadInvoicesQueryResultItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DownloadInvoicesQueryResultItem }
     * 
     * 
     */
    public List<DownloadInvoicesQueryResultItem> getDownloadInvoicesQueryResultItems() {
        if (downloadInvoicesQueryResultItems == null) {
            downloadInvoicesQueryResultItems = new ArrayList<DownloadInvoicesQueryResultItem>();
        }
        return this.downloadInvoicesQueryResultItems;
    }

}
