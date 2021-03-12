
package messages.invoicing.billgate.billzone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the messages.invoicing.billgate.billzone package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInvoiceDataResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "GetInvoiceDataResponse");
    private final static QName _CreateCashReceiptResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "CreateCashReceiptResponse");
    private final static QName _GetInvoiceDataRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "GetInvoiceDataRequest");
    private final static QName _DownloadCashReceiptRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadCashReceiptRequest");
    private final static QName _ConvertExternalInvoiceResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "ConvertExternalInvoiceResponse");
    private final static QName _DownloadInvoicesResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadInvoicesResponse");
    private final static QName _RequestBase_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "RequestBase");
    private final static QName _ConvertExternalInvoiceRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "ConvertExternalInvoiceRequest");
    private final static QName _CreateCashReceiptRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "CreateCashReceiptRequest");
    private final static QName _CreateInvoiceResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "CreateInvoiceResponse");
    private final static QName _CreateInvoiceRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "CreateInvoiceRequest");
    private final static QName _DownloadInvoicesRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadInvoicesRequest");
    private final static QName _ResponseBase_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "ResponseBase");
    private final static QName _DownloadCashReceiptResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadCashReceiptResponse");
    private final static QName _DownloadInvoiceRequest_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadInvoiceRequest");
    private final static QName _DownloadInvoiceResponse_QNAME = new QName("http://Billzone.Billgate.Invoicing.Messages", "DownloadInvoiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: messages.invoicing.billgate.billzone
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DownloadInvoiceResponse }
     * 
     */
    public DownloadInvoiceResponse createDownloadInvoiceResponse() {
        return new DownloadInvoiceResponse();
    }

    /**
     * Create an instance of {@link ConvertExternalInvoiceRequest }
     * 
     */
    public ConvertExternalInvoiceRequest createConvertExternalInvoiceRequest() {
        return new ConvertExternalInvoiceRequest();
    }

    /**
     * Create an instance of {@link CreateInvoiceResponse }
     * 
     */
    public CreateInvoiceResponse createCreateInvoiceResponse() {
        return new CreateInvoiceResponse();
    }

    /**
     * Create an instance of {@link GetInvoiceDataRequest }
     * 
     */
    public GetInvoiceDataRequest createGetInvoiceDataRequest() {
        return new GetInvoiceDataRequest();
    }

    /**
     * Create an instance of {@link DownloadInvoicesRequest }
     * 
     */
    public DownloadInvoicesRequest createDownloadInvoicesRequest() {
        return new DownloadInvoicesRequest();
    }

    /**
     * Create an instance of {@link CreateInvoiceRequest }
     * 
     */
    public CreateInvoiceRequest createCreateInvoiceRequest() {
        return new CreateInvoiceRequest();
    }

    /**
     * Create an instance of {@link DownloadInvoicesResponse }
     * 
     */
    public DownloadInvoicesResponse createDownloadInvoicesResponse() {
        return new DownloadInvoicesResponse();
    }

    /**
     * Create an instance of {@link DownloadCashReceiptResponse }
     * 
     */
    public DownloadCashReceiptResponse createDownloadCashReceiptResponse() {
        return new DownloadCashReceiptResponse();
    }

    /**
     * Create an instance of {@link CreateCashReceiptResponse }
     * 
     */
    public CreateCashReceiptResponse createCreateCashReceiptResponse() {
        return new CreateCashReceiptResponse();
    }

    /**
     * Create an instance of {@link CreateCashReceiptRequest }
     * 
     */
    public CreateCashReceiptRequest createCreateCashReceiptRequest() {
        return new CreateCashReceiptRequest();
    }

    /**
     * Create an instance of {@link DownloadInvoiceRequest }
     * 
     */
    public DownloadInvoiceRequest createDownloadInvoiceRequest() {
        return new DownloadInvoiceRequest();
    }

    /**
     * Create an instance of {@link ConvertExternalInvoiceResponse }
     * 
     */
    public ConvertExternalInvoiceResponse createConvertExternalInvoiceResponse() {
        return new ConvertExternalInvoiceResponse();
    }

    /**
     * Create an instance of {@link GetInvoiceDataResponse }
     * 
     */
    public GetInvoiceDataResponse createGetInvoiceDataResponse() {
        return new GetInvoiceDataResponse();
    }

    /**
     * Create an instance of {@link DownloadCashReceiptRequest }
     * 
     */
    public DownloadCashReceiptRequest createDownloadCashReceiptRequest() {
        return new DownloadCashReceiptRequest();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link RequestBase }
     * 
     */
    public RequestBase createRequestBase() {
        return new RequestBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "GetInvoiceDataResponse")
    public JAXBElement<GetInvoiceDataResponse> createGetInvoiceDataResponse(GetInvoiceDataResponse value) {
        return new JAXBElement<GetInvoiceDataResponse>(_GetInvoiceDataResponse_QNAME, GetInvoiceDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCashReceiptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "CreateCashReceiptResponse")
    public JAXBElement<CreateCashReceiptResponse> createCreateCashReceiptResponse(CreateCashReceiptResponse value) {
        return new JAXBElement<CreateCashReceiptResponse>(_CreateCashReceiptResponse_QNAME, CreateCashReceiptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceDataRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "GetInvoiceDataRequest")
    public JAXBElement<GetInvoiceDataRequest> createGetInvoiceDataRequest(GetInvoiceDataRequest value) {
        return new JAXBElement<GetInvoiceDataRequest>(_GetInvoiceDataRequest_QNAME, GetInvoiceDataRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadCashReceiptRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadCashReceiptRequest")
    public JAXBElement<DownloadCashReceiptRequest> createDownloadCashReceiptRequest(DownloadCashReceiptRequest value) {
        return new JAXBElement<DownloadCashReceiptRequest>(_DownloadCashReceiptRequest_QNAME, DownloadCashReceiptRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertExternalInvoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "ConvertExternalInvoiceResponse")
    public JAXBElement<ConvertExternalInvoiceResponse> createConvertExternalInvoiceResponse(ConvertExternalInvoiceResponse value) {
        return new JAXBElement<ConvertExternalInvoiceResponse>(_ConvertExternalInvoiceResponse_QNAME, ConvertExternalInvoiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadInvoicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadInvoicesResponse")
    public JAXBElement<DownloadInvoicesResponse> createDownloadInvoicesResponse(DownloadInvoicesResponse value) {
        return new JAXBElement<DownloadInvoicesResponse>(_DownloadInvoicesResponse_QNAME, DownloadInvoicesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "RequestBase")
    public JAXBElement<RequestBase> createRequestBase(RequestBase value) {
        return new JAXBElement<RequestBase>(_RequestBase_QNAME, RequestBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertExternalInvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "ConvertExternalInvoiceRequest")
    public JAXBElement<ConvertExternalInvoiceRequest> createConvertExternalInvoiceRequest(ConvertExternalInvoiceRequest value) {
        return new JAXBElement<ConvertExternalInvoiceRequest>(_ConvertExternalInvoiceRequest_QNAME, ConvertExternalInvoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCashReceiptRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "CreateCashReceiptRequest")
    public JAXBElement<CreateCashReceiptRequest> createCreateCashReceiptRequest(CreateCashReceiptRequest value) {
        return new JAXBElement<CreateCashReceiptRequest>(_CreateCashReceiptRequest_QNAME, CreateCashReceiptRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInvoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "CreateInvoiceResponse")
    public JAXBElement<CreateInvoiceResponse> createCreateInvoiceResponse(CreateInvoiceResponse value) {
        return new JAXBElement<CreateInvoiceResponse>(_CreateInvoiceResponse_QNAME, CreateInvoiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateInvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "CreateInvoiceRequest")
    public JAXBElement<CreateInvoiceRequest> createCreateInvoiceRequest(CreateInvoiceRequest value) {
        return new JAXBElement<CreateInvoiceRequest>(_CreateInvoiceRequest_QNAME, CreateInvoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadInvoicesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadInvoicesRequest")
    public JAXBElement<DownloadInvoicesRequest> createDownloadInvoicesRequest(DownloadInvoicesRequest value) {
        return new JAXBElement<DownloadInvoicesRequest>(_DownloadInvoicesRequest_QNAME, DownloadInvoicesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "ResponseBase")
    public JAXBElement<ResponseBase> createResponseBase(ResponseBase value) {
        return new JAXBElement<ResponseBase>(_ResponseBase_QNAME, ResponseBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadCashReceiptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadCashReceiptResponse")
    public JAXBElement<DownloadCashReceiptResponse> createDownloadCashReceiptResponse(DownloadCashReceiptResponse value) {
        return new JAXBElement<DownloadCashReceiptResponse>(_DownloadCashReceiptResponse_QNAME, DownloadCashReceiptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadInvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadInvoiceRequest")
    public JAXBElement<DownloadInvoiceRequest> createDownloadInvoiceRequest(DownloadInvoiceRequest value) {
        return new JAXBElement<DownloadInvoiceRequest>(_DownloadInvoiceRequest_QNAME, DownloadInvoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadInvoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Billzone.Billgate.Invoicing.Messages", name = "DownloadInvoiceResponse")
    public JAXBElement<DownloadInvoiceResponse> createDownloadInvoiceResponse(DownloadInvoiceResponse value) {
        return new JAXBElement<DownloadInvoiceResponse>(_DownloadInvoiceResponse_QNAME, DownloadInvoiceResponse.class, null, value);
    }

}
