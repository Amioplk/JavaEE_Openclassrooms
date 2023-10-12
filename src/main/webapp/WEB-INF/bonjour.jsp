<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<c:set var="pseudo" value="${ author.surname }77400" scope="page" />
	<c:if test="${ !author.active }">
		<c:set target="${ author }" property="name" value="Lambourg" />
	</c:if>
	<h2>
		Votre pseudo :
		<c:out value="${ pseudo }" />
	</h2>
	<p>
		Bonjour
		<c:out value="${ author.surname }" />
		<c:out value="${ author.name }" />
	</p>
	<p>${ author.active ? "Vous êtes très actif." : "Vous êtes inactif." }</p>
</body>
</html>