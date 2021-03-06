<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title="sauzen"/>
</head>
<body>
<vdab:menu/>
	<h1>Sauzen</h1>
	<c:forEach var='saus' items='${sauzen}'>
			<h2>${saus.naam}</h2>
			<img src="images/${saus.naam}.png" alt="${saus.naam}"> 
			ingredienten:
			<c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status"> 
					${ingredient} <c:if test='${not status.last}'>, </c:if>
			</c:forEach>
	</c:forEach>
</body>
</html>