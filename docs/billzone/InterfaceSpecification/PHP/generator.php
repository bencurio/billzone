<?php

	//Betöltjük a WSDLInterpreter.php -t
	require_once 'WSDLInterpreter-v1.0.0/WSDLInterpreter.php';
	
	//Megadjuk a wsdl-t
	$wsdlLocation = 'https://sandbox.billzone.eu/billgate?wsdl';
	
	$wsdlInterpreter = new WSDLInterpreter($wsdlLocation);
	
	//Elmentjük a legenerált php fájlt
	$wsdlInterpreter->savePHP('.');
	
?>