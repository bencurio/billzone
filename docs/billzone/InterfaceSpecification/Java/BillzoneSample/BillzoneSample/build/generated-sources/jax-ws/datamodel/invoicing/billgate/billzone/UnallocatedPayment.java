
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnallocatedPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnallocatedPayment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}PaymentBase">
 *       &lt;sequence>
 *         &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Currency" type="{http://Billzone.Billgate.Invoicing.DataModel}CurrencyShortName"/>
 *         &lt;element name="Customer" type="{http://Billzone.Billgate.Invoicing.DataModel}CustomerIdentifier"/>
 *         &lt;element name="BankIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "UnallocatedPayment", propOrder = {
    "paymentDate",
    "paymentTotal",
    "currency",
    "customer",
    "bankIdentifier",
    "description"
})
public class UnallocatedPayment
    extends PaymentBase
{

    @XmlElement(name = "PaymentDate", required = true, nillable = true)
    protected String paymentDate;
    @XmlElement(name = "PaymentTotal", required = true)
    protected BigDecimal paymentTotal;
    @XmlElement(name = "Currency", required = true, nillable = true)
    protected CurrencyShortName currency;
    @XmlElement(name = "Customer", required = true, nillable = true)
    protected CustomerIdentifier customer;
    @XmlElement(name = "BankIdentifier", nillable = true)
    protected String bankIdentifier;
    @XmlElement(name = "Description", nillable = true)
    protected String description;

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the paymentTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }

    /**
     * Sets the value of the paymentTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaymentTotal(BigDecimal value) {
        this.paymentTotal = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyShortName }
     *     
     */
    public CurrencyShortName getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyShortName }
     *     
     */
    public void setCurrency(CurrencyShortName value) {
        this.currency = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIdentifier }
     *     
     */
    public CustomerIdentifier getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIdentifier }
     *     
     */
    public void setCustomer(CustomerIdentifier value) {
        this.customer = value;
    }

    /**
     * Gets the value of the bankIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankIdentifier() {
        return bankIdentifier;
    }

    /**
     * Sets the value of the bankIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankIdentifier(String value) {
        this.bankIdentifier = value;
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
