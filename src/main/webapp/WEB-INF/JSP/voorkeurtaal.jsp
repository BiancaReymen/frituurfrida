<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head title="voorkeurtaal"/>
</head>
<body>
<vdab:menu/>
<p>
	je voorkeurtaal is ${nederlands ? "nederlands" : "geen nederlands" }
</p>
</body>
</html>