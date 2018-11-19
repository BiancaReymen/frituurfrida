<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces='true'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title="beginnaam"/>
</head>
<body>
<vdab:menu/>
	<h1>snacks (begin naam)</h1>
	<c:url value='/snacks/beginnaam' var='url' />

	<form:form action='${url}' modelAttribute='beginNaamForm' method='get'>
		<form:label path='beginnaam'>Begin naam: 
	  		<form:errors path='beginnaam' />
		</form:label>
		<form:input path='beginnaam' autofocus='autofocus' type='text' required='required' />
			<input type='submit' value='Zoeken'>
		<form:errors />
	</form:form>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach var='snack' items='${snacks}'>
			<spring:url value='/snacks/{id}/wijzigen' var='url'>
				<spring:param name='id' value='${snack.id}' />
			</spring:url>
				<li><a href ='${url}'>${snack.naam}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>