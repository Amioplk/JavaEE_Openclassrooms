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
	<p>${ author.active ? "Vous �tes tr�s actif." : "Vous �tes inactif." }</p>
</body>
</html>