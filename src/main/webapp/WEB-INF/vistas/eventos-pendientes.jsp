<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<p>Eventos pendientes a realizarse</p>
				
 <form:form action="listado-personal-asignado" method="POST" modelAttribute="idreserva">  
		<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Salon</th>
				<th>Dirección</th>
				<th>Fecha</th>
				<th>Horario</th>
				<th></th>
				<th></th>							
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="item" items="${listadopendientes}">

						<tr>
						<td>${item.salon.nombre}</td>
						<td>${item.salon.direccion}</td>
						<td>${item.fecha}</td>
						<td>${item.horario}</td>						
						<td>${item.idReserva}</td>
						<td><input type="radio" name="idreserva" value="${item.idReserva}"></td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
	<button class="btn-agregar" Type="Submit"/>Seleccionar</button>
</form:form>		
		<br><br><br>

	     
</body>
</html>