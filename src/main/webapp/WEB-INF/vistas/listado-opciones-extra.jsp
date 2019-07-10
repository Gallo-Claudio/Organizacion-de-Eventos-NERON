<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Listado para la seleccion del menu</title>
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
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
			<li ><a  href="home"> Inicio    </a></li>
			<li><a  href="salones-a-puntuar"> Nuestros Salonest</a></li>
			<li><a  href="menus-a-puntuar"> Nuestros Menus</a></li>

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

Seleccion de Extras<br><br><br>

<form:form action="registra-reserva-extras" method="POST" modelAttribute="vm">

		<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Descripcion</th>
				<th>Precio</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="menu" items="${listaopciones}">
						<tr>
						<td>${menu.nombre}</td>
						<td>${menu.precio}</td>
						<td><input type="checkbox" name="idmenu[${menu.id}]" value="${menu.id}"></td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
		<br><br><br>

	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>


        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>