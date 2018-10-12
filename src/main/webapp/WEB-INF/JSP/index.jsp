<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<title>Frituur Frida</title>
<link rel='icon' href='images/frida.ico'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='css/frituurfrida.css'>
</head>
<img src="images/${OpenGesloten}.png" alt="{OpenGesloten}">
<body>
	<h1>Frituur Frida</h1>
	<dl>
	<dt>Adres: </dt>
			<dd>${adres.straat} ${adres.huisNr} <br>
			    ${adres.gemeente.postCode} ${adres.gemeente.naam}</dd>
	</dl>
	</body>
</html>


