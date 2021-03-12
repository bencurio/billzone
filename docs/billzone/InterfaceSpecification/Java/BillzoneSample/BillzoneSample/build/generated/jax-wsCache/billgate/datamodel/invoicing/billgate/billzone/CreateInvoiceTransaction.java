
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateInvoiceTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateInvoiceTransaction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}TransactionBase">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://Billzone.Billgate.Invoicing.DataModel}InvoiceHeaderBase"/>
 *         &lt;element name="Lines" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfInvoiceLine"/>
 *         &lt;element name="SendInvoiceToCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SendInvoiceToEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceCourierTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "CreateInvoiceTransaction", propOrder = {
    "header",
    "lines",
    "sendInvoiceToCustomer",
    "sendInvoiceToEmailAddress",
    "invoiceCourierTypeId",
    "clauses"
})
public class CreateInvoiceTransaction
    extends TransactionBase
{

    @XmlElement(name = "Header", required = true, nillable = true)
    protected InvoiceHeaderBase header;
    @XmlElement(name = "Lines", required = true, nillable = true)
    protected ArrayOfInvoiceLine lines;
    @XmlElement(name = "SendInvoiceToCustomer")
    protected Boolean sendInvoiceToCustomer;
    @XmlElement(name = "SendInvoiceToEmailAddress", nillable = true)
    protected String sendInvoiceToEmailAddress;
    @XmlElement(name = "InvoiceCourierTypeId", nillable = true)
    protected Integer invoiceCourierTypeId;
    @XmlElement(name = "Clauses", nillable = true)
    protected ArrayOfClauseItem clauses;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceHeaderBase }
     *     
     */
    public InvoiceHeaderBase getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceHeaderBase }
     *     
     */
    public void setHeader(InvoiceHeaderBase value) {
        this.header = value;
    }

    /**
     * Gets the value of the lines property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInvoiceLine }
     *     
     */
    public ArrayOfInvoiceLine getLines() {
        return lines;
    }

    /**
     * Sets the value of the lines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInvoiceLine }
     *     
     */
    public void setLines(ArrayOfInvoiceLine value) {
        this.lines = value;
    }

    /**
     * Gets the value of the sendInvoiceToCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSendInvoiceToCustomer() {
        return sendInvoiceToCustomer;
    }

    /**
     * Sets the value of the sendInvoiceToCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSendInvoiceToCustomer(Boolean value) {
        this.sendInvoiceToCustomer = value;
    }

    /**
     * Gets the value of the sendInvoiceToEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendInvoiceToEmailAddress() {
        return sendInvoiceToEmailAddress;
    }

    /**
     * Sets the value of the sendInvoiceToEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendInvoiceToEmailAddress(String value) {
        this.sendInvoiceToEmailAddress = value;
    }

    /**
     * Gets the value of the invoiceCourierTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInvoiceCourierTypeId() {
        return invoiceCourierTypeId;
    }

    /**
     * Sets the value of the invoiceCourierTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInvoiceCourierTypeId(Integer value) {
        this.invoiceCourierTypeId = value;
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
