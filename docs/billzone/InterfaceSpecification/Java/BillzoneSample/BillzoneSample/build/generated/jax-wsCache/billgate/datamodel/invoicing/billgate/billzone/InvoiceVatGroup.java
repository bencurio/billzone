
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceVatGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceVatGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VatTaxRateCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VatAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NetAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LocalVatAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LocalGrossAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LocalNetAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceVatGroup", propOrder = {
    "vatTaxRateCode",
    "vatAmount",
    "netAmount",
    "grossAmount",
    "localVatAmount",
    "localGrossAmount",
    "localNetAmount"
})
public class InvoiceVatGroup {

    @XmlElement(name = "VatTaxRateCode", required = true, nillable = true)
    protected String vatTaxRateCode;
    @XmlElement(name = "VatAmount", required = true)
    protected BigDecimal vatAmount;
    @XmlElement(name = "NetAmount", required = true)
    protected BigDecimal netAmount;
    @XmlElement(name = "GrossAmount", required = true)
    protected BigDecimal grossAmount;
    @XmlElement(name = "LocalVatAmount", nillable = true)
    protected BigDecimal localVatAmount;
    @XmlElement(name = "LocalGrossAmount", nillable = true)
    protected BigDecimal localGrossAmount;
    @XmlElement(name = "LocalNetAmount", nillable = true)
    protected BigDecimal localNetAmount;

    /**
     * Gets the value of the vatTaxRateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatTaxRateCode() {
        return vatTaxRateCode;
    }

    /**
     * Sets the value of the vatTaxRateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatTaxRateCode(String value) {
        this.vatTaxRateCode = value;
    }

    /**
     * Gets the value of the vatAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    /**
     * Sets the value of the vatAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVatAmount(BigDecimal value) {
        this.vatAmount = value;
    }

    /**
     * Gets the value of the netAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    /**
     * Sets the value of the netAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetAmount(BigDecimal value) {
        this.netAmount = value;
    }

    /**
     * Gets the value of the grossAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    /**
     * Sets the value of the grossAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossAmount(BigDecimal value) {
        this.grossAmount = value;
    }

    /**
     * Gets the value of the localVatAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLocalVatAmount() {
        return localVatAmount;
    }

    /**
     * Sets the value of the localVatAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLocalVatAmount(BigDecimal value) {
        this.localVatAmount = value;
    }

    /**
     * Gets the value of the localGrossAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLocalGrossAmount() {
        return localGrossAmount;
    }

    /**
     * Sets the value of the localGrossAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLocalGrossAmount(BigDecimal value) {
        this.localGrossAmount = value;
    }

    /**
     * Gets the value of the localNetAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLocalNetAmount() {
        return localNetAmount;
    }

    /**
     * Sets the value of the localNetAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLocalNetAmount(BigDecimal value) {
        this.localNetAmount = value;
    }

}
