<?php
// Nyugta létrehozása, befizetéssel

//Betöltjük a generált InvoicingService.php-t
require_once 'InvoicingService.php';	

	
//InvoicingService objektum létrehozása
$InvoicingService = new InvoicingService();	


//Currency létrehozása
$Currency = new CurrencyShortName ();
$Currency -> ShortName = 'HUF';
	
//Customer létrehozása
$Customer = new CustomerIdentifier ();
$Customer -> Identifier = 'T1VEVO1';
	
	
//UnallocatedPayment objektum létrehozása és feltöltése
$UnallocatedPayment = new UnallocatedPayment();
$UnallocatedPayment -> BankIdentifier = 'BUDAPESTBANK';
$UnallocatedPayment -> PaymentTotal = 3000;
$UnallocatedPayment -> Currency = $Currency;
$UnallocatedPayment -> Customer = $Customer;
$UnallocatedPayment -> PaymentDate = date("Y-m-d",time());
$UnallocatedPayment -> Description = 'Megjegyzés';


//CashReceiptHeader objektumok létrehozása és feltöltése
$CashReceiptHeader = new CashReceiptHeader();
$CashReceiptHeader -> CashReceiptBlockPrefix = 'ALCR';
$CashReceiptHeader -> CashierName = 'Pénztáros neve';
$CashReceiptHeader -> CreatorName = 'Kiállító neve';
$CashReceiptHeader -> ContributorName = 'Befizető neve';
$CashReceiptHeader -> ContributorDocument = 'Befizető okmánya';
$CashReceiptHeader -> Description = 'Megjegyzés';

	
//CreateCashReceiptTransaction objektum létrehozása és feltöltése
$CreateCashReceiptTransaction = new CreateCashReceiptTransaction();
$CreateCashReceiptTransaction -> TransactionId = '8099144c-56d0-4c79-8cda-794b3fef3cf5';
$CreateCashReceiptTransaction -> Payment = $UnallocatedPayment;
$CreateCashReceiptTransaction -> CashReceiptHeader = $CashReceiptHeader;

//CreateInvoiceRequest objektum létrehozása és feltöltése
$CreateCashReceiptRequest = new CreateCashReceiptRequest();
$CreateCashReceiptRequest -> CreateCashReceiptTransaction = $CreateCashReceiptTransaction; 
$CreateCashReceiptRequest -> RequestId = '111';
$CreateCashReceiptRequest -> SecurityToken = '9ICOPE3QYHT4LS3JM1ECZRJF47NLGN3GSLJ2R2WE';	
	
//CreateInvoice objektum létrehozása és feltöltése
$CreateCashReceipt = new CreateCashReceipt();
$CreateCashReceipt -> request = $CreateCashReceiptRequest; 
	
//CreateInvoice függvény meghívása az előbbiekben beállított értékekkel
$CreateCashReceiptResponse = new CreateCashReceiptResponse();
$CreateCashReceiptResponse = $InvoicingService -> CreateCashReceipt($CreateCashReceipt);

?>


