<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>



	<nav class="">
		<h1>Bienvenidos a</h1>
		<h1>Organizacion de Eventos NERON</h1>
		<a class="navbar-brand" href=#><img id="logo-nav" src="Webroot/img/logotipo.png" alt="Logo de OnMarket"></a>

       <div>

			<form action="salon" method="post">
			<input type="submit" value="Reservar" class="btn btn-light">
			</form>
		</div>


		<div>
			<form  method="post"  action="cerrarsesion"  >
				<input type="submit" value="Cerrar session" class="btn btn-secondary">
			</form>
		</div>


		<a href="salones-a-puntuar"> Nuestros Salones</a>
		<a href="menus-a-puntuar"> Nuestros Menus</a>
		<!--<div>
			registrar
			<form  method="post"  action="+"  >
			<input type="submit" value="Registrarse" class="btn btn-secondary">
			</form>
		</div>-->
	</nav>
<main>
	tope= ${tope}
	<c:forEach items="${salones}" var="salon">

			${salon.nombre}<br>
			${salon.ubicacion.localidad}<br>
			${salon.ubicacion.calle}<br>
			${salon.ubicacion.numero}<br>
			${salon.precio}<br>
			<a href="VerImagenes?id=${salon.id}">
				<input  class=" btn btn-success" type="button" value="Ver mas"/>
			</a>
			Valoracion Actual:${salon.puntaje}<br>



	</c:forEach>
</main>
	</body>
</html>