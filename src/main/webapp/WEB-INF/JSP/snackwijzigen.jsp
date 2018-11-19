<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title="snack wijzigen"/>
</head>
<body>
<vdab:menu/>
	<h1>${snack.naam} wijzigen</h1>
	<spring:url value='/snacks/{id}/wijzigen' var='url'>
		<spring:param name='id' value='${snack.id}' />
	</spring:url>
	<form:form action='${url}' modelAttribute='snack' method='post' id='wijzigenForm'>
		<form:label path='naam'>Naam: <form:errors path='naam' />
		</form:label>
		<form:input path='naam' required="required" autofocus='autofocus' />
		<form:label path='prijs'>Prijs: <form:errors path='prijs' />
		</form:label>
		<form:input path='prijs' type='number' required="required" min='0' step='0.01' />
		<input type='submit' value='Opslaan' id='opslaanKnop'>
	</form:form>
	<script>
		document.getElementById('wijzigenForm').onsubmit = function() {
			document.getElementById('opslaanKnop').disabled = true;
		};
	</script>
</body>
</html>