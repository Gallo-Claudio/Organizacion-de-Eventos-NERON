<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	    <!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
	   <h1>Ingreso de Tipos de Menus</h1>
	
				<form:form action="registro-tipo-menu" method="POST" modelAttribute="agregartipomenu">
				  	<input name="detalle" placeholder="Ingrese el nuevo tipo de menu" />			
					<button Type="Submit"/>Agregar</button>
				</form:form>
        <a href="/proyecto-limpio-spring/home">Salir</a>
	
	<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
