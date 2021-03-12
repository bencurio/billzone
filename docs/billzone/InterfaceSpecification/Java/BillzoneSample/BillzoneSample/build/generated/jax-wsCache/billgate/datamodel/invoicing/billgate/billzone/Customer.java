
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Customer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}CustomerBase">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomerIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUTaxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressPostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressCountryId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressLine1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
    "name",
    "customerIdentifier",
    "euTaxNumber",
    "taxNumber",
    "addressPostalCode",
    "addressCity",
    "addressCountryId",
    "addressLine1",
    "addressLine2",
    "addressState",
    "groupIdentificationNumber"
})
public class Customer
    extends CustomerBase
{

    @XmlElement(name = "Name", required = true, nillable = true)
    protected String name;
    @XmlElement(name = "CustomerIdentifier", nillable = true)
    protected String customerIdentifier;
    @XmlElement(name = "EUTaxNumber", nillable = true)
    protected String euTaxNumber;
    @XmlElement(name = "TaxNumber", nillable = true)
    protected String taxNumber;
    @XmlElement(name = "AddressPostalCode", required = true, nillable = true)
    protected String addressPostalCode;
    @XmlElement(name = "AddressCity", required = true, nillable = true)
    protected String addressCity;
    @XmlElement(name = "AddressCountryId", required = true, nillable = true)
    protected String addressCountryId;
    @XmlElement(name = "AddressLine1", required = true, nillable = true)
    protected String addressLine1;
    @XmlElement(name = "AddressLine2", nillable = true)
    protected String addressLine2;
    @XmlElement(name = "AddressState", nillable = true)
    protected String addressState;
    @XmlElement(name = "GroupIdentificationNumber", nillable = true)
    protected String groupIdentificationNumber;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the customerIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    /**
     * Sets the value of the customerIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIdentifier(String value) {
        this.customerIdentifier = value;
    }

    /**
     * Gets the value of the euTaxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEUTaxNumber() {
        return euTaxNumber;
    }

    /**
     * Sets the value of the euTaxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEUTaxNumber(String value) {
        this.euTaxNumber = value;
    }

    /**
     * Gets the value of the taxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets the value of the taxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxNumber(String value) {
        this.taxNumber = value;
    }

    /**
     * Gets the value of the addressPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    /**
     * Sets the value of the addressPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressPostalCode(String value) {
        this.addressPostalCode = value;
    }

    /**
     * Gets the value of the addressCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * Sets the value of the addressCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCity(String value) {
        this.addressCity = value;
    }

    /**
     * Gets the value of the addressCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCountryId() {
        return addressCountryId;
    }

    /**
     * Sets the value of the addressCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCountryId(String value) {
        this.addressCountryId = value;
    }

    /**
     * Gets the value of the addressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the addressState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressState() {
        return addressState;
    }

    /**
     * Sets the value of the addressState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressState(String value) {
        this.addressState = value;
    }

    /**
     * Gets the value of the groupIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupIdentificationNumber() {
        return groupIdentificationNumber;
    }

    /**
     * Sets the value of the groupIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupIdentificationNumber(String value) {
        this.groupIdentificationNumber = value;
    }

}
