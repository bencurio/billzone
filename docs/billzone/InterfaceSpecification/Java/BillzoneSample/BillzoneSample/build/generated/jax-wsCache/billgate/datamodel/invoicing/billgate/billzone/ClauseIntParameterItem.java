
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClauseIntParameterItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClauseIntParameterItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}ClauseParameterItemBase">
 *       &lt;sequence>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClauseIntParameterItem", propOrder = {
    "value"
})
public class ClauseIntParameterItem
    extends ClauseParameterItemBase
{

    @XmlElement(name = "Value")
    protected long value;

    /**
     * Gets the value of the value property.
     * 
     */
    public long getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(long value) {
        this.value = value;
    }

}
