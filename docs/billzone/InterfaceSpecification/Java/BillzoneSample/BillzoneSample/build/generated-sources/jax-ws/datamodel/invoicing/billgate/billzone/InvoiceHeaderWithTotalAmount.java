
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceHeaderWithTotalAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceHeaderWithTotalAmount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceHeader">
 *       &lt;sequence>
 *         &lt;element name="InvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InvoiceNetTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="InvoiceVatTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="InvoiceGrossTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="InvoiceLocalVatTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvoiceLocalGrossTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="InvoiceLocalNetTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceHeaderWithTotalAmount", propOrder = {
    "invoiceNumber",
    "invoiceNetTotalAmount",
    "invoiceVatTotalAmount",
    "invoiceGrossTotalAmount",
    "invoiceLocalVatTotalAmount",
    "invoiceLocalGrossTotalAmount",
    "invoiceLocalNetTotalAmount"
})
public class InvoiceHeaderWithTotalAmount
    extends InvoiceHeader
{

    @XmlElement(name = "InvoiceNumber", required = true, nillable = true)
    protected String invoiceNumber;
    @XmlElement(name = "InvoiceNetTotalAmount", required = true)
    protected BigDecimal invoiceNetTotalAmount;
    @XmlElement(name = "InvoiceVatTotalAmount", required = true)
    protected BigDecimal invoiceVatTotalAmount;
    @XmlElement(name = "InvoiceGrossTotalAmount", required = true)
    protected BigDecimal invoiceGrossTotalAmount;
    @XmlElement(name = "InvoiceLocalVatTotalAmount", nillable = true)
    protected BigDecimal invoiceLocalVatTotalAmount;
    @XmlElement(name = "InvoiceLocalGrossTotalAmount", nillable = true)
    protected BigDecimal invoiceLocalGrossTotalAmount;
    @XmlElement(name = "InvoiceLocalNetTotalAmount", nillable = true)
    protected BigDecimal invoiceLocalNetTotalAmount;

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the invoiceNetTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceNetTotalAmount() {
        return invoiceNetTotalAmount;
    }

    /**
     * Sets the value of the invoiceNetTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceNetTotalAmount(BigDecimal value) {
        this.invoiceNetTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceVatTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceVatTotalAmount() {
        return invoiceVatTotalAmount;
    }

    /**
     * Sets the value of the invoiceVatTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceVatTotalAmount(BigDecimal value) {
        this.invoiceVatTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceGrossTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceGrossTotalAmount() {
        return invoiceGrossTotalAmount;
    }

    /**
     * Sets the value of the invoiceGrossTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceGrossTotalAmount(BigDecimal value) {
        this.invoiceGrossTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceLocalVatTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceLocalVatTotalAmount() {
        return invoiceLocalVatTotalAmount;
    }

    /**
     * Sets the value of the invoiceLocalVatTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceLocalVatTotalAmount(BigDecimal value) {
        this.invoiceLocalVatTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceLocalGrossTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceLocalGrossTotalAmount() {
        return invoiceLocalGrossTotalAmount;
    }

    /**
     * Sets the value of the invoiceLocalGrossTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceLocalGrossTotalAmount(BigDecimal value) {
        this.invoiceLocalGrossTotalAmount = value;
    }

    /**
     * Gets the value of the invoiceLocalNetTotalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceLocalNetTotalAmount() {
        return invoiceLocalNetTotalAmount;
    }

    /**
     * Sets the value of the invoiceLocalNetTotalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceLocalNetTotalAmount(BigDecimal value) {
        this.invoiceLocalNetTotalAmount = value;
    }

}
