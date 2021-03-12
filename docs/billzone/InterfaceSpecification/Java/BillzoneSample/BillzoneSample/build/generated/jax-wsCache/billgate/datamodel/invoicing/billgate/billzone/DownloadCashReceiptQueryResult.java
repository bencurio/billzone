
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadCashReceiptQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadCashReceiptQueryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}QueryResultBase">
 *       &lt;sequence>
 *         &lt;element name="CashReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CashReceiptDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadCashReceiptQueryResult", propOrder = {
    "cashReceiptNumber",
    "cashReceiptDocument"
})
public class DownloadCashReceiptQueryResult
    extends QueryResultBase
{

    @XmlElement(name = "CashReceiptNumber", nillable = true)
    protected String cashReceiptNumber;
    @XmlElement(name = "CashReceiptDocument", nillable = true)
    protected byte[] cashReceiptDocument;

    /**
     * Gets the value of the cashReceiptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashReceiptNumber() {
        return cashReceiptNumber;
    }

    /**
     * Sets the value of the cashReceiptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashReceiptNumber(String value) {
        this.cashReceiptNumber = value;
    }

    /**
     * Gets the value of the cashReceiptDocument property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCashReceiptDocument() {
        return cashReceiptDocument;
    }

    /**
     * Sets the value of the cashReceiptDocument property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCashReceiptDocument(byte[] value) {
        this.cashReceiptDocument = value;
    }

}
