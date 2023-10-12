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
	<c:forEach items="${ authors }" var='authorForEach'
		varStatus="statusAuthor">
		<p>
			<c:if test="${ statusAuthor.last }">
				Et pour finir...
			</c:if>
			Bonjour
			<c:out value="${ authorForEach.surname }" />
			<c:out value="${ authorForEach.name }" />
			!
		</p>
	</c:forEach>
	<p>${ author.active ? "Vous êtes très actif." : "Vous êtes inactif." }</p>
	<c:if test="${ !empty age }">
		<p>Vous avez ${ age } ${ age <= 1 ? "an" : "ans" } !</p>
	</c:if>

	<!-- Tests sur les formulaires -->
	<c:if test="${ !empty connectionForm.result }">
		<p>
			<c:out value="${ connectionForm.result }" />
		</p>
	</c:if>
	
	<p>Mon login : <c:out value="${ sessionScope.login }" /></p>

	<c:if test="${ empty sessionScope.login }">
		<form method="post" action="bonjour">
			<div>
				<label for="login">Login :</label> 
				<input type="text" id="login" name="login" />
			</div>
			<div>
				<label for="pass">Password :</label> 
				<input type="password" id="pass" name="pass" />
			</div>
			<div>
				<label for="age">Age :</label> 
				<input type="number" id="age" name="age" min=0 max=100/>
			</div>
			<input type="submit" value="Envoyer" />
		</form>
	</c:if>


</body>
</html>