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
	
		<tbody>
	<c:forEach var="variable" items="${listadoFinal}"> 
		<tr>
		<td><b><i>${variable.nombre}</i></b></td>
		<td><b>$<i>${variable.precio}</i></b></td>
		<td><input type="checkbox" value="${variable.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	
	
	
				<form:form action="selecciono-extras" method="POST" modelAttribute="Extras">
							
					<button Type="Submit"/>Agregar extra</button>
				</form:form>
				<br>
				</center>
	</body>
</html>

