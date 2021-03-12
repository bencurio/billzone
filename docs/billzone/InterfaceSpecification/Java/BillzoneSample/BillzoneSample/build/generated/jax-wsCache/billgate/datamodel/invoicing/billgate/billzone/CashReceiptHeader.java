
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CashReceiptHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CashReceiptHeader">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}CashReceiptHeaderBase">
 *       &lt;sequence>
 *         &lt;element name="CreatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ContributorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ContributorDocument" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashReceiptBlockPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashReceiptHeader", propOrder = {
    "creatorName",
    "cashierName",
    "contributorName",
    "contributorDocument",
    "cashReceiptBlockPrefix",
    "description"
})
public class CashReceiptHeader
    extends CashReceiptHeaderBase
{

    @XmlElement(name = "CreatorName", required = true, nillable = true)
    protected String creatorName;
    @XmlElement(name = "CashierName", required = true, nillable = true)
    protected String cashierName;
    @XmlElement(name = "ContributorName", required = true, nillable = true)
    protected String contributorName;
    @XmlElement(name = "ContributorDocument", required = true, nillable = true)
    protected String contributorDocument;
    @XmlElement(name = "CashReceiptBlockPrefix", required = true, nillable = true)
    protected String cashReceiptBlockPrefix;
    @XmlElement(name = "Description", nillable = true)
    protected String description;

    /**
     * Gets the value of the creatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * Sets the value of the creatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorName(String value) {
        this.creatorName = value;
    }

    /**
     * Gets the value of the cashierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashierName() {
        return cashierName;
    }

    /**
     * Sets the value of the cashierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashierName(String value) {
        this.cashierName = value;
    }

    /**
     * Gets the value of the contributorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributorName() {
        return contributorName;
    }

    /**
     * Sets the value of the contributorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributorName(String value) {
        this.contributorName = value;
    }

    /**
     * Gets the value of the contributorDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContributorDocument() {
        return contributorDocument;
    }

    /**
     * Sets the value of the contributorDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContributorDocument(String value) {
        this.contributorDocument = value;
    }

    /**
     * Gets the value of the cashReceiptBlockPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashReceiptBlockPrefix() {
        return cashReceiptBlockPrefix;
    }

    /**
     * Sets the value of the cashReceiptBlockPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashReceiptBlockPrefix(String value) {
        this.cashReceiptBlockPrefix = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
