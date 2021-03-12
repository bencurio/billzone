
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InvoiceLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceLine">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceLineBase">
 *       &lt;sequence>
 *         &lt;element name="ProductStatisticalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NetUnitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VatPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnitIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductTextIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GrossUnitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IsPeriodic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PeriodStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="PeriodEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Clauses" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfClauseItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceLine", propOrder = {
    "productStatisticalCode",
    "productName",
    "netUnitPrice",
    "quantity",
    "vatPercentage",
    "unitIdentifier",
    "productTextIdentifier",
    "grossUnitPrice",
    "isPeriodic",
    "periodStartDate",
    "periodEndDate",
    "clauses"
})
public class InvoiceLine
    extends InvoiceLineBase
{

    @XmlElement(name = "ProductStatisticalCode", nillable = true)
    protected String productStatisticalCode;
    @XmlElement(name = "ProductName", required = true, nillable = true)
    protected String productName;
    @XmlElement(name = "NetUnitPrice", nillable = true)
    protected BigDecimal netUnitPrice;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;
    @XmlElement(name = "VatPercentage", required = true)
    protected BigDecimal vatPercentage;
    @XmlElement(name = "UnitIdentifier", required = true, nillable = true)
    protected String unitIdentifier;
    @XmlElement(name = "ProductTextIdentifier", nillable = true)
    protected String productTextIdentifier;
    @XmlElement(name = "GrossUnitPrice", nillable = true)
    protected BigDecimal grossUnitPrice;
    @XmlElement(name = "IsPeriodic", nillable = true)
    protected Boolean isPeriodic;
    @XmlElement(name = "PeriodStartDate", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodStartDate;
    @XmlElement(name = "PeriodEndDate", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodEndDate;
    @XmlElement(name = "Clauses", nillable = true)
    protected ArrayOfClauseItem clauses;

    /**
     * Gets the value of the productStatisticalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductStatisticalCode() {
        return productStatisticalCode;
    }

    /**
     * Sets the value of the productStatisticalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductStatisticalCode(String value) {
        this.productStatisticalCode = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the netUnitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetUnitPrice() {
        return netUnitPrice;
    }

    /**
     * Sets the value of the netUnitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetUnitPrice(BigDecimal value) {
        this.netUnitPrice = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the vatPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVatPercentage() {
        return vatPercentage;
    }

    /**
     * Sets the value of the vatPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVatPercentage(BigDecimal value) {
        this.vatPercentage = value;
    }

    /**
     * Gets the value of the unitIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitIdentifier() {
        return unitIdentifier;
    }

    /**
     * Sets the value of the unitIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitIdentifier(String value) {
        this.unitIdentifier = value;
    }

    /**
     * Gets the value of the productTextIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTextIdentifier() {
        return productTextIdentifier;
    }

    /**
     * Sets the value of the productTextIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTextIdentifier(String value) {
        this.productTextIdentifier = value;
    }

    /**
     * Gets the value of the grossUnitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossUnitPrice() {
        return grossUnitPrice;
    }

    /**
     * Sets the value of the grossUnitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossUnitPrice(BigDecimal value) {
        this.grossUnitPrice = value;
    }

    /**
     * Gets the value of the isPeriodic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPeriodic() {
        return isPeriodic;
    }

    /**
     * Sets the value of the isPeriodic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPeriodic(Boolean value) {
        this.isPeriodic = value;
    }

    /**
     * Gets the value of the periodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodStartDate() {
        return periodStartDate;
    }

    /**
     * Sets the value of the periodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodStartDate(XMLGregorianCalendar value) {
        this.periodStartDate = value;
    }

    /**
     * Gets the value of the periodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodEndDate() {
        return periodEndDate;
    }

    /**
     * Sets the value of the periodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodEndDate(XMLGregorianCalendar value) {
        this.periodEndDate = value;
    }

    /**
     * Gets the value of the clauses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClauseItem }
     *     
     */
    public ArrayOfClauseItem getClauses() {
        return clauses;
    }

    /**
     * Sets the value of the clauses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClauseItem }
     *     
     */
    public void setClauses(ArrayOfClauseItem value) {
        this.clauses = value;
    }

}
