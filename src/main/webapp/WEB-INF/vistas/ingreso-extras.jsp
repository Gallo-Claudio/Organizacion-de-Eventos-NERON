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
				<form:form action="registro-extras" method="POST" modelAttribute="Extras">
				<b><i>Por favor, ingrese un extra:</i></b>     <center><input name="nombre" placeholder="Mago"><br><br></center>
				<b><i>Por favor, ingrese un precio:</i></b>	<center><input name="precio" placeholder="200" /><br><br></center>
					

				
					<button Type="Submit"/>Agregar extra</button>
				</form:form>
				<br>
				<a href="/proyecto-limpio-spring/listado-final-extras"><i>Obtener un listado</i></a>
				</center>
	</body>
</html>






