
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.ResultCode;


/**
 * <p>Java class for ResponseBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestResult" type="{http://Billzone.Billgate.Invoicing.DataModel}ResultCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBase", propOrder = {
    "requestId",
    "requestResult"
})
@XmlSeeAlso({
    DownloadInvoiceResponse.class,
    CreateInvoiceResponse.class,
    DownloadInvoicesResponse.class,
    DownloadCashReceiptResponse.class,
    CreateCashReceiptResponse.class,
    ConvertExternalInvoiceResponse.class,
    GetInvoiceDataResponse.class
})
public class ResponseBase {

    @XmlElement(name = "RequestId", required = true, nillable = true)
    protected String requestId;
    @XmlElement(name = "RequestResult", required = true, nillable = true)
    protected ResultCode requestResult;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the requestResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResultCode }
     *     
     */
    public ResultCode getRequestResult() {
        return requestResult;
    }

    /**
     * Sets the value of the requestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultCode }
     *     
     */
    public void setRequestResult(ResultCode value) {
        this.requestResult = value;
    }

}
