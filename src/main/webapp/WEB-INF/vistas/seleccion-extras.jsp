<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/extras.css">
		
	    <title>Agregar Extras</title>
	    
	</head>
	
	<header>
				<center><b><i>Nerón - Agregar extras</i></b></center><br><br>

	
	
	</header>
	<body><center>
	
	
			<form:form action="sele-extras" method="POST" modelAttribute="Extras">
				<c:forEach var="variable" items="${listadoFinal2}">
					<form:checkbox path="nombre" id="nombre" type="nombre" value="${variable.nombre}"/>
					<form:checkbox path="precio" id="precio" type="precio" value="${variable.precio}"/>	
				</c:forEach>		
			</form:form>
	</body>
</html>