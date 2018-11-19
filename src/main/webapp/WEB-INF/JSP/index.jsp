<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head title="index"/>
</head>
<img src="images/${OpenGesloten}.png" alt="{OpenGesloten}">
<body>
	<h1>Frituur Frida</h1>
	<c:if test = "${reedsBezocht}">
		<h2>Welkom terug</h2>
	</c:if>
	<dl>
	<dt>Adres: </dt>
			<dd>${adres.straat} ${adres.huisNr} <br>
			    ${adres.gemeente.postCode} ${adres.gemeente.naam}</dd>
	</dl>
	</body>
</html>


