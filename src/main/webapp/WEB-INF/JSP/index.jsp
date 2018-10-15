<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Frituur Frida"/>
</c:import>
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


