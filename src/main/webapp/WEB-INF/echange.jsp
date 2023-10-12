<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<!-- Tests sur l'échange de fichiers -->

    <c:if test="${ !empty file }"><p><c:out value="Le fichier ${ file } (${ description }) a été uploadé !" /></p></c:if>
	<form method="post" action="echange" enctype="multipart/form-data" >
		<div>
			<label for="description">Description :</label>
			<input type="text" id="description" name="description" />
		</div>
		<div>
			<label for="file">Fichier :</label> 
			<input type="file" id="file" name="file" />
		</div>
		<input type="submit" value="Envoyer" />
	</form>

</body>
</html>