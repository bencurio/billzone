
package messages.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import datamodel.invoicing.billgate.billzone.CreateCashReceiptTransaction;


/**
 * <p>Java class for CreateCashReceiptRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCashReceiptRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.Messages}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="CreateCashReceiptTransaction" type="{http://Billzone.Billgate.Invoicing.DataModel}CreateCashReceiptTransaction"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCashReceiptRequest", propOrder = {
    "createCashReceiptTransaction"
})
public class CreateCashReceiptRequest
    extends RequestBase
{

    @XmlElement(name = "CreateCashReceiptTransaction", required = true, nillable = true)
    protected CreateCashReceiptTransaction createCashReceiptTransaction;

    /**
     * Gets the value of the createCashReceiptTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCashReceiptTransaction }
     *     
     */
    public CreateCashReceiptTransaction getCreateCashReceiptTransaction() {
        return createCashReceiptTransaction;
    }

    /**
     * Sets the value of the createCashReceiptTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCashReceiptTransaction }
     *     
     */
    public void setCreateCashReceiptTransaction(CreateCashReceiptTransaction value) {
        this.createCashReceiptTransaction = value;
    }

}
