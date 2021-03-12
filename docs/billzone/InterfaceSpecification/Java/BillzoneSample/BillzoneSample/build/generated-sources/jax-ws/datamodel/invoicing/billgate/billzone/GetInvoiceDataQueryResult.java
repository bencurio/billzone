
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetInvoiceDataQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInvoiceDataQueryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}QueryResultBase">
 *       &lt;sequence>
 *         &lt;element name="Units" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfUnitsQueryResultItem" minOccurs="0"/>
 *         &lt;element name="AccountBlocks" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfAccountBlocksQueryResultItem" minOccurs="0"/>
 *         &lt;element name="PaymentMethods" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfPaymentMethodsQueryResultItem" minOccurs="0"/>
 *         &lt;element name="Issuers" type="{http://Billzone.Billgate.Invoicing.DataModel}ArrayOfIssuersQueryResultItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInvoiceDataQueryResult", propOrder = {
    "units",
    "accountBlocks",
    "paymentMethods",
    "issuers"
})
public class GetInvoiceDataQueryResult
    extends QueryResultBase
{

    @XmlElement(name = "Units", nillable = true)
    protected ArrayOfUnitsQueryResultItem units;
    @XmlElement(name = "AccountBlocks", nillable = true)
    protected ArrayOfAccountBlocksQueryResultItem accountBlocks;
    @XmlElement(name = "PaymentMethods", nillable = true)
    protected ArrayOfPaymentMethodsQueryResultItem paymentMethods;
    @XmlElement(name = "Issuers", nillable = true)
    protected ArrayOfIssuersQueryResultItem issuers;

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUnitsQueryResultItem }
     *     
     */
    public ArrayOfUnitsQueryResultItem getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUnitsQueryResultItem }
     *     
     */
    public void setUnits(ArrayOfUnitsQueryResultItem value) {
        this.units = value;
    }

    /**
     * Gets the value of the accountBlocks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccountBlocksQueryResultItem }
     *     
     */
    public ArrayOfAccountBlocksQueryResultItem getAccountBlocks() {
        return accountBlocks;
    }

    /**
     * Sets the value of the accountBlocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccountBlocksQueryResultItem }
     *     
     */
    public void setAccountBlocks(ArrayOfAccountBlocksQueryResultItem value) {
        this.accountBlocks = value;
    }

    /**
     * Gets the value of the paymentMethods property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaymentMethodsQueryResultItem }
     *     
     */
    public ArrayOfPaymentMethodsQueryResultItem getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Sets the value of the paymentMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaymentMethodsQueryResultItem }
     *     
     */
    public void setPaymentMethods(ArrayOfPaymentMethodsQueryResultItem value) {
        this.paymentMethods = value;
    }

    /**
     * Gets the value of the issuers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIssuersQueryResultItem }
     *     
     */
    public ArrayOfIssuersQueryResultItem getIssuers() {
        return issuers;
    }

    /**
     * Sets the value of the issuers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIssuersQueryResultItem }
     *     
     */
    public void setIssuers(ArrayOfIssuersQueryResultItem value) {
        this.issuers = value;
    }

}
