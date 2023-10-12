<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<p><c:out value="Helloo" /></p>
	<p>Bonjour ${ author.surname } ${ author.name }</p>
	<p>${ author.active ? "Vous êtes très actif." : "Vous êtes inactif." }</p>
</body>
</html>