<?php
// Nyugta létrehozása, számlakiegyenlítéssel

//Betöltjük a generált InvoicingService.php-t
require_once 'InvoicingService.php';	

	
//InvoicingService objektum létrehozása
$InvoicingService = new InvoicingService();	

	
//AllocatedPayment objektum létrehozása és feltöltése
$AllocatedPayment = new AllocatedPayment();
$AllocatedPayment -> BankIdentifier = 'BUDAPESTBANK';
$AllocatedPayment -> InvoiceNumber = 'BLF001';
$AllocatedPayment -> PaymentDate = date("Y-m-d",time());
$AllocatedPayment -> Description = 'Megjegyzés';


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
$CreateCashReceiptTransaction -> TransactionId = '8099144c-56d0-4c79-8cda-794b3fef3ce5';
$CreateCashReceiptTransaction -> Payment = $AllocatedPayment;
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


