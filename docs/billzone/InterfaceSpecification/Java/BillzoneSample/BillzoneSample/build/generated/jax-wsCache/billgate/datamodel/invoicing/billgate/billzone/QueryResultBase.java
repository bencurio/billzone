
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryResultBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryResultBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultCode" type="{http://Billzone.Billgate.Invoicing.DataModel}ResultCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryResultBase", propOrder = {
    "resultCode"
})
@XmlSeeAlso({
    GetInvoiceDataQueryResult.class,
    DownloadInvoicesQueryResult.class,
    DownloadCashReceiptQueryResult.class,
    DownloadInvoiceQueryResult.class
})
public class QueryResultBase {

    @XmlElement(name = "ResultCode", required = true, nillable = true)
    protected ResultCode resultCode;

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResultCode }
     *     
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultCode }
     *     
     */
    public void setResultCode(ResultCode value) {
        this.resultCode = value;
    }

}
