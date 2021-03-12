<?php
// Egy nyugta letöltése

	//Betöltjük a generált InvoicingService.php-t
	require_once 'InvoicingService.php';
	
	//InvoicingService objektum létrehozása
	$InvoicingService = new InvoicingService();

	
	//CashReceiptNumber értéke
	$CashReceiptNumber = 'ALCR0001';	
	
	//DownloadCashReceiptQuery objektum létrehozása és feltöltése
	$DownloadCashReceiptQuery = new DownloadCashReceiptQuery();
	$DownloadCashReceiptQuery -> CashReceiptNumber	= $CashReceiptNumber;	
	
	//DownloadInvoiceRequest objektum létrehozása és feltöltése
	$DownloadCashReceiptRequest = new DownloadCashReceiptRequest();
	$DownloadCashReceiptRequest -> DownloadCashReceiptQuery = $DownloadCashReceiptQuery;
	$DownloadCashReceiptRequest -> RequestId = '222';
	$DownloadCashReceiptRequest -> SecurityToken = '9ICOPE3QYHT4LS3JM1ECZRJF47NLGN3GSLJ2R2WE';	
	
	//DownloadCashReceipt objektum létrehozása és feltöltése
	$DownloadCashReceipt = new DownloadCashReceipt();
	$DownloadCashReceipt -> request = $DownloadCashReceiptRequest;		
	
	//DownloadCashReceipt függvény meghívása az előbbiekben beállított értékekkel
	$DownloadCashReceiptResponse = $InvoicingService -> DownloadCashReceipt($DownloadCashReceipt);
		
	//CashReceiptDocument értéke a válaszból
	$CashReceiptDocument = $DownloadCashReceiptResponse -> DownloadCashReceiptResult -> QueryResult -> CashReceiptDocument;
		
	//CashReceiptNumber fájlba mentese
	$myCashReceipt = "myCashReceipt.pdf";
	$fh = fopen($myCashReceipt, 'w');
	fwrite($fh, $CashReceiptDocument);
	fclose($fh);
?>


