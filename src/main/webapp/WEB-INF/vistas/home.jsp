<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>


<nav>


		<h1>Bienvenidos a</h1>
		<h1>Organizacion de Eventos NERON</h1>
		<a class="navbar-brand" href=#><img id="logo-nav" src="Webroot/img/logotipo.png" alt="Logo de OnMarket"></a>

    <a href="home"> Inicio</a>
	<a href="salones-a-puntuar"> Nuestros Salones</a>

	<a href="menus-a-puntuar"> Nuestros Menus</a>

    <a href="salon"> Reservar</a>
    <a href="cerrarsesion"> cerrar sesion</a>




		<!--<div class="col">
			registrar
			<form  method="post"  action="+"  >
			<input type="submit" value="Registrarse" class="btn btn-secondary">
			</form>
		</div>-->


	</nav>

	<table>

	<c:forEach items="${salones}" var="salon">

        <td>
			${salon.nombre}<br>

			${salon.precio}<br>
			<a href="VerImagenes?id=${salon.id}">
				<input  class=" btn btn-success" type="button" value="Ver mas"/>
			</a>
			Valoracion Actual:${salon.puntaje}<br>

       </td>

	</c:forEach>

	</table>

	</body>
</html>