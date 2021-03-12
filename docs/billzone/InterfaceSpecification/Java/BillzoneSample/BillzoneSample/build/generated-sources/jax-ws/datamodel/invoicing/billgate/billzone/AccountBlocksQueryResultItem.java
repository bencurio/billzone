
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountBlocksQueryResultItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountBlocksQueryResultItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountBlockPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountBlocksQueryResultItem", propOrder = {
    "accountBlockPrefix",
    "currencyShortName"
})
public class AccountBlocksQueryResultItem {

    @XmlElement(name = "AccountBlockPrefix", nillable = true)
    protected String accountBlockPrefix;
    @XmlElement(name = "CurrencyShortName", nillable = true)
    protected String currencyShortName;

    /**
     * Gets the value of the accountBlockPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountBlockPrefix() {
        return accountBlockPrefix;
    }

    /**
     * Sets the value of the accountBlockPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountBlockPrefix(String value) {
        this.accountBlockPrefix = value;
    }

    /**
     * Gets the value of the currencyShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyShortName() {
        return currencyShortName;
    }

    /**
     * Sets the value of the currencyShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyShortName(String value) {
        this.currencyShortName = value;
    }

}
