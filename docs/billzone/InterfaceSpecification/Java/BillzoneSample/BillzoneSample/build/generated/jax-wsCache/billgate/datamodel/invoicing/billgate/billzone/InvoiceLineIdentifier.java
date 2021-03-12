
package datamodel.invoicing.billgate.billzone;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InvoiceLineIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceLineIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceLineBase">
 *       &lt;sequence>
 *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IsPeriodic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PeriodStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="PeriodEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Clauses" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfClauseItem" minOccurs="0"/>
 *         &lt;element name="InvoiceLineNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceLineIdentifier", propOrder = {
    "identifier",
    "quantity",
    "isPeriodic",
    "periodStartDate",
    "periodEndDate",
    "clauses",
    "invoiceLineNote"
})
public class InvoiceLineIdentifier
    extends InvoiceLineBase
{

    @XmlElement(name = "Identifier", required = true, nillable = true)
    protected String identifier;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;
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
    @XmlElement(name = "InvoiceLineNote", nillable = true)
    protected String invoiceLineNote;

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

    /**
     * Gets the value of the invoiceLineNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceLineNote() {
        return invoiceLineNote;
    }

    /**
     * Sets the value of the invoiceLineNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceLineNote(String value) {
        this.invoiceLineNote = value;
    }

}
