
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BankIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}BankBase">
 *       &lt;sequence>
 *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BankDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankIdentifier", propOrder = {
    "identifier",
    "bankDescription"
})
public class BankIdentifier
    extends BankBase
{

    @XmlElement(name = "Identifier", required = true, nillable = true)
    protected String identifier;
    @XmlElement(name = "BankDescription", nillable = true)
    protected String bankDescription;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the bankDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankDescription() {
        return bankDescription;
    }

    /**
     * Sets the value of the bankDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankDescription(String value) {
        this.bankDescription = value;
    }

}
