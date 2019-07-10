<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">

	    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/extras.css">
		
	    <title>Agregar Extras</title>
	    
	</head>
	
	<header>
				<center><b><i>Ner�n - Agregar extras</i></b></center><br><br>

	
	
	</header>
	<body>

	<nav class="navbar navbar-default" role="navigation">
		<!-- El logotipo y el icono que despliega el menú se agrupan
             para mostrarlos mejor en los dispositivos móviles -->
		<div class="navbar-header">

			<a class="navbar-brand" href="#">Logotipo</a>
		</div>

		<!-- Agrupar los enlaces de navegación, los formularios y cualquier
             otro elemento que se pueda ocultar al minimizar la barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li ><a href="homeAdmin">inicio</a></li>
				<li><a href="listado-final-extras">Extras</a></li>

				<li><a href="listado-final-menu">Menu</a></li>
				<li><a href="listado-final-salon">Salon</a></li>
				<li><a href="">Personal</a></li>
			</ul>


			<div class="navbar-form navbar-left">
				<h5>Bienvenidos a</h5>
				<h5>Organizacion de Eventos NERON</h5>
			</div>




			<form class="navbar-form navbar-left"  method="post"  action="salon"  >
				<div class="form-group">
					<input type="submit" value="Reservar" class="btn btn-success">
				</div>
			</form>


			<form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
				<div class="form-group">
					<input type="submit" value="cerrar sesion" class="btn btn-success">
				</div>
			</form>

		</div>
	</nav>

	<center>
				<form:form action="registro-extras" method="POST" modelAttribute="Extras">
				<b><i>Por favor, ingrese un extra:</i></b>     <center><input name="nombre" placeholder="Mago"><br><br></center>
				<b><i>Por favor, ingrese un precio:</i></b>	<center><input name="precio" placeholder="200" /><br><br></center>
					

				
					<button class="btn btn-success" Type="Submit"/>Agregar extra</button>
				</form:form>
				<br>
				<a href="/proyecto-limpio-spring/listado-final-extras"><i>Obtener un listado</i></a>
				</center>
	</body>
</html>






