
package datamodel.invoicing.billgate.billzone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadInvoicesQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadInvoicesQuery">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Billzone.Billgate.Invoicing.DataModel}QueryBase">
 *       &lt;sequence>
 *         &lt;element name="CompressResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FilterSpecification" type="{http://Billzone.Billgate.Invoicing.DataModel}DownloadInvoicesFilterBase"/>
 *         &lt;element name="DocumentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadInvoicesQuery", propOrder = {
    "compressResult",
    "filterSpecification",
    "documentType"
})
public class DownloadInvoicesQuery
    extends QueryBase
{

    @XmlElement(name = "CompressResult")
    protected boolean compressResult;
    @XmlElement(name = "FilterSpecification", required = true, nillable = true)
    protected DownloadInvoicesFilterBase filterSpecification;
    @XmlElement(name = "DocumentType", nillable = true)
    protected String documentType;

    /**
     * Gets the value of the compressResult property.
     * 
     */
    public boolean isCompressResult() {
        return compressResult;
    }

    /**
     * Sets the value of the compressResult property.
     * 
     */
    public void setCompressResult(boolean value) {
        this.compressResult = value;
    }

    /**
     * Gets the value of the filterSpecification property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadInvoicesFilterBase }
     *     
     */
    public DownloadInvoicesFilterBase getFilterSpecification() {
        return filterSpecification;
    }

    /**
     * Sets the value of the filterSpecification property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadInvoicesFilterBase }
     *     
     */
    public void setFilterSpecification(DownloadInvoicesFilterBase value) {
        this.filterSpecification = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

}
