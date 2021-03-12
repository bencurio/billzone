
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InvoiceHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceHeader">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceHeaderBase">
 *       &lt;sequence>
 *         &lt;element name="AccountBlockPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bank" type="{http://Billzone.Billgate.Invoicing.DataModel}BankBase"/>
 *         &lt;element name="IssuerAddress" type="{http://Billzone.Billgate.Invoicing.DataModel}IssuerAddressBase"/>
 *         &lt;element name="Customer" type="{http://Billzone.Billgate.Invoicing.DataModel}CustomerBase"/>
 *         &lt;element name="FulfillmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PaymentDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Currency" type="{http://Billzone.Billgate.Invoicing.DataModel}CurrencyBase"/>
 *         &lt;element name="InterEUVatExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PaymentMethodId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="InvoiceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalForeignCurrencyExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IsDomesticDelivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsVatReasonAccepted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InvoiceDocumentType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ReferenceInvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceInvoiceFulfillmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="InvoiceHasElectronicServiceInEU" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ForceLocalForeignCurrencyExchangeRate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceHeader", propOrder = {
    "accountBlockPrefix",
    "bank",
    "issuerAddress",
    "customer",
    "fulfillmentDate",
    "paymentDueDate",
    "currency",
    "interEUVatExempt",
    "paymentMethodId",
    "invoiceDescription",
    "notes",
    "orderNumber",
    "localForeignCurrencyExchangeRate",
    "isDomesticDelivery",
    "isVatReasonAccepted",
    "invoiceDocumentType",
    "referenceInvoiceNumber",
    "referenceInvoiceFulfillmentDate",
    "invoiceHasElectronicServiceInEU",
    "forceLocalForeignCurrencyExchangeRate"
})
@XmlSeeAlso({
    InvoiceHeaderWithTotalAmount.class
})
public class InvoiceHeader
    extends InvoiceHeaderBase
{

    @XmlElement(name = "AccountBlockPrefix", required = true, nillable = true)
    protected String accountBlockPrefix;
    @XmlElement(name = "Bank", required = true, nillable = true)
    protected BankBase bank;
    @XmlElement(name = "IssuerAddress", required = true, nillable = true)
    protected IssuerAddressBase issuerAddress;
    @XmlElement(name = "Customer", required = true, nillable = true)
    protected CustomerBase customer;
    @XmlElement(name = "FulfillmentDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fulfillmentDate;
    @XmlElement(name = "PaymentDueDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDueDate;
    @XmlElement(name = "Currency", required = true, nillable = true)
    protected CurrencyBase currency;
    @XmlElement(name = "InterEUVatExempt")
    protected boolean interEUVatExempt;
    @XmlElement(name = "PaymentMethodId", nillable = true)
    protected Integer paymentMethodId;
    @XmlElement(name = "InvoiceDescription", nillable = true)
    protected String invoiceDescription;
    @XmlElement(name = "Notes", nillable = true)
    protected String notes;
    @XmlElement(name = "OrderNumber", nillable = true)
    protected String orderNumber;
    @XmlElement(name = "LocalForeignCurrencyExchangeRate", nillable = true)
    protected BigDecimal localForeignCurrencyExchangeRate;
    @XmlElement(name = "IsDomesticDelivery", nillable = true)
    protected Boolean isDomesticDelivery;
    @XmlElement(name = "IsVatReasonAccepted", nillable = true)
    protected Boolean isVatReasonAccepted;
    @XmlElement(name = "InvoiceDocumentType", nillable = true)
    protected Integer invoiceDocumentType;
    @XmlElement(name = "ReferenceInvoiceNumber", nillable = true)
    protected String referenceInvoiceNumber;
    @XmlElement(name = "ReferenceInvoiceFulfillmentDate", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar referenceInvoiceFulfillmentDate;
    @XmlElement(name = "InvoiceHasElectronicServiceInEU", nillable = true)
    protected Boolean invoiceHasElectronicServiceInEU;
    @XmlElement(name = "ForceLocalForeignCurrencyExchangeRate", nillable = true)
    protected Boolean forceLocalForeignCurrencyExchangeRate;

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
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link BankBase }
     *     
     */
    public BankBase getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankBase }
     *     
     */
    public void setBank(BankBase value) {
        this.bank = value;
    }

    /**
     * Gets the value of the issuerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link IssuerAddressBase }
     *     
     */
    public IssuerAddressBase getIssuerAddress() {
        return issuerAddress;
    }

    /**
     * Sets the value of the issuerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssuerAddressBase }
     *     
     */
    public void setIssuerAddress(IssuerAddressBase value) {
        this.issuerAddress = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerBase }
     *     
     */
    public CustomerBase getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerBase }
     *     
     */
    public void setCustomer(CustomerBase value) {
        this.customer = value;
    }

    /**
     * Gets the value of the fulfillmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFulfillmentDate() {
        return fulfillmentDate;
    }

    /**
     * Sets the value of the fulfillmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFulfillmentDate(XMLGregorianCalendar value) {
        this.fulfillmentDate = value;
    }

    /**
     * Gets the value of the paymentDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * Sets the value of the paymentDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDueDate(XMLGregorianCalendar value) {
        this.paymentDueDate = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyBase }
     *     
     */
    public CurrencyBase getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyBase }
     *     
     */
    public void setCurrency(CurrencyBase value) {
        this.currency = value;
    }

    /**
     * Gets the value of the interEUVatExempt property.
     * 
     */
    public boolean isInterEUVatExempt() {
        return interEUVatExempt;
    }

    /**
     * Sets the value of the interEUVatExempt property.
     * 
     */
    public void setInterEUVatExempt(boolean value) {
        this.interEUVatExempt = value;
    }

    /**
     * Gets the value of the paymentMethodId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * Sets the value of the paymentMethodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaymentMethodId(Integer value) {
        this.paymentMethodId = value;
    }

    /**
     * Gets the value of the invoiceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    /**
     * Sets the value of the invoiceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceDescription(String value) {
        this.invoiceDescription = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the localForeignCurrencyExchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLocalForeignCurrencyExchangeRate() {
        return localForeignCurrencyExchangeRate;
    }

    /**
     * Sets the value of the localForeignCurrencyExchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLocalForeignCurrencyExchangeRate(BigDecimal value) {
        this.localForeignCurrencyExchangeRate = value;
    }

    /**
     * Gets the value of the isDomesticDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDomesticDelivery() {
        return isDomesticDelivery;
    }

    /**
     * Sets the value of the isDomesticDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDomesticDelivery(Boolean value) {
        this.isDomesticDelivery = value;
    }

    /**
     * Gets the value of the isVatReasonAccepted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsVatReasonAccepted() {
        return isVatReasonAccepted;
    }

    /**
     * Sets the value of the isVatReasonAccepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsVatReasonAccepted(Boolean value) {
        this.isVatReasonAccepted = value;
    }

    /**
     * Gets the value of the invoiceDocumentType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInvoiceDocumentType() {
        return invoiceDocumentType;
    }

    /**
     * Sets the value of the invoiceDocumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInvoiceDocumentType(Integer value) {
        this.invoiceDocumentType = value;
    }

    /**
     * Gets the value of the referenceInvoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceInvoiceNumber() {
        return referenceInvoiceNumber;
    }

    /**
     * Sets the value of the referenceInvoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceInvoiceNumber(String value) {
        this.referenceInvoiceNumber = value;
    }

    /**
     * Gets the value of the referenceInvoiceFulfillmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReferenceInvoiceFulfillmentDate() {
        return referenceInvoiceFulfillmentDate;
    }

    /**
     * Sets the value of the referenceInvoiceFulfillmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReferenceInvoiceFulfillmentDate(XMLGregorianCalendar value) {
        this.referenceInvoiceFulfillmentDate = value;
    }

    /**
     * Gets the value of the invoiceHasElectronicServiceInEU property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInvoiceHasElectronicServiceInEU() {
        return invoiceHasElectronicServiceInEU;
    }

    /**
     * Sets the value of the invoiceHasElectronicServiceInEU property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInvoiceHasElectronicServiceInEU(Boolean value) {
        this.invoiceHasElectronicServiceInEU = value;
    }

    /**
     * Gets the value of the forceLocalForeignCurrencyExchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceLocalForeignCurrencyExchangeRate() {
        return forceLocalForeignCurrencyExchangeRate;
    }

    /**
     * Sets the value of the forceLocalForeignCurrencyExchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceLocalForeignCurrencyExchangeRate(Boolean value) {
        this.forceLocalForeignCurrencyExchangeRate = value;
    }

}
