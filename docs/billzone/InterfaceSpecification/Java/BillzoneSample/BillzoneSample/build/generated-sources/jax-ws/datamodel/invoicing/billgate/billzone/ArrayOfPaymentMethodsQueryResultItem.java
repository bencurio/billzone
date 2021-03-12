
package datamodel.invoicing.billgate.billzone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPaymentMethodsQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaymentMethodsQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentMethodsQueryResultItem" type="{http://Billzone.Billgate.Invoicing.DataModel}PaymentMethodsQueryResultItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaymentMethodsQueryResultItem", propOrder = {
    "paymentMethodsQueryResultItems"
})
public class ArrayOfPaymentMethodsQueryResultItem {

    @XmlElement(name = "PaymentMethodsQueryResultItem", nillable = true)
    protected List<PaymentMethodsQueryResultItem> paymentMethodsQueryResultItems;

    /**
     * Gets the value of the paymentMethodsQueryResultItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMethodsQueryResultItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMethodsQueryResultItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMethodsQueryResultItem }
     * 
     * 
     */
    public List<PaymentMethodsQueryResultItem> getPaymentMethodsQueryResultItems() {
        if (paymentMethodsQueryResultItems == null) {
            paymentMethodsQueryResultItems = new ArrayList<PaymentMethodsQueryResultItem>();
        }
        return this.paymentMethodsQueryResultItems;
    }

}
