
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadCashReceiptQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadCashReceiptQuery">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}QueryBase">
 *       &lt;sequence>
 *         &lt;element name="CashReceiptNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadCashReceiptQuery", propOrder = {
    "cashReceiptNumber"
})
public class DownloadCashReceiptQuery
    extends QueryBase
{

    @XmlElement(name = "CashReceiptNumber", required = true, nillable = true)
    protected String cashReceiptNumber;

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

}
