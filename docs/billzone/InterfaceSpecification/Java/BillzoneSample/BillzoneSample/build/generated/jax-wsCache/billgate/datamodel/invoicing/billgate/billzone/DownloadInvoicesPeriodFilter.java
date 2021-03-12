
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DownloadInvoicesPeriodFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesPeriodFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoicesFilterBase">
 *       &lt;sequence>
 *         &lt;element name="PeriodStart" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PeriodEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesPeriodFilter", propOrder = {
    "periodStart",
    "periodEnd"
})
public class DownloadInvoicesPeriodFilter
    extends DownloadInvoicesFilterBase
{

    @XmlElement(name = "PeriodStart", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodStart;
    @XmlElement(name = "PeriodEnd", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodEnd;

    /**
     * Gets the value of the periodStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodStart() {
        return periodStart;
    }

    /**
     * Sets the value of the periodStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodStart(XMLGregorianCalendar value) {
        this.periodStart = value;
    }

    /**
     * Gets the value of the periodEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodEnd() {
        return periodEnd;
    }

    /**
     * Sets the value of the periodEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodEnd(XMLGregorianCalendar value) {
        this.periodEnd = value;
    }

}
