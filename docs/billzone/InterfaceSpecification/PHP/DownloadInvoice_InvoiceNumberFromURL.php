<?php
// Egy számla letöltése

	//Paraméterben megadott Invoice Number, Billzone Security Token, Authenticity Token
	if(!(isset($_GET["IN"])))
	{
		echo ("Invoice number not specified!");
		exit();
	}
		//Betöltjük a generált InvoicingService.php-t
		require_once 'InvoicingService.php';

		//InvoicingService objektum létrehozása
		$InvoicingService = new InvoicingService();

		//InvoiceNumber értéke az URL-ben megadott IN paraméter
		$InvoiceNumber = $_GET["IN"];

		//DownloadInvoiceQuery objektum létrehozása és feltöltése
		$DownloadInvoiceQuery = new DownloadInvoiceQuery();
		$DownloadInvoiceQuery -> InvoiceNumber	= $InvoiceNumber;	
		
		//DownloadInvoiceRequest objektum létrehozása és feltöltése
		$DownloadInvoiceRequest = new DownloadInvoiceRequest();
		$DownloadInvoiceRequest -> DownloadInvoiceQuery = $DownloadInvoiceQuery;
		$DownloadInvoiceRequest -> RequestId = '222';
		$DownloadInvoiceRequest -> SecurityToken = '9ICOPE3QYHT4LS3JM1ECZRJF47NLGN3GSLJ2R2WE';	
		
		//DownloadInvoice objektum létrehozása és feltöltése
		$DownloadInvoice = new DownloadInvoice();
		$DownloadInvoice -> request = $DownloadInvoiceRequest;		
		
		//DownloadInvoice függvény meghívása az előbbiekben beállított értékekkel
		$DownloadInvoiceResponse = $InvoicingService -> DownloadInvoice($DownloadInvoice);
		
		//Helyes válaszkód
		$OKRESULT = "61001";
		
		//Kapott válaszkód
		$ResultCode = $DownloadInvoiceResponse -> DownloadInvoiceResult -> RequestResult -> Code;
		
		//Ha a válasz nem OK, kilépünk
		if($ResultCode != $OKRESULT)
		{
			echo ("Error code: ".$ResultCode);
			echo "<br>";
			exit($ResultCode);
		}
		
		//InvoiceDocument értéke a válaszból
		$InvoiceDocument = $DownloadInvoiceResponse -> DownloadInvoiceResult -> QueryResult -> InvoiceDocument;
		
		//Ha van mit letölteni...
		if(strlen($InvoiceDocument) > 10)
		{
			//Letöltendő fájl neve
			$myInvoice = $InvoiceNumber.".pdf";

			header("Content-type: application/pdf");
			header("Content-Disposition: attachment; filename=".$myInvoice);
			echo $InvoiceDocument;
		}
		//Ha nincs mit letölteni, jelezzük (nem létezik a számla)
		else
		{
			echo ("Wrong invoice number: ".$InvoiceNumber.". There is nothing to download.");
			exit();
		}

//http://localhost:8080/bz/DownloadInvoice.php?IN=EGER0001
	?>


