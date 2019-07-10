<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="css/gallo.css" rel="stylesheet" >
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
				
<form:form action="reasigna-personal" method="POST" modelAttribute="vmReasignaPersonal">
<input type="hidden" name="idreserva" value="${idreserva}">

<p>Personal asignado al evento de la reserva numero: ${idreserva}</p>

	<c:forEach var = "i" begin = "1" end = "6">
	  			<c:forEach var="tipo" items="${cargos}">
					<c:if test="${tipo.id==i}">
						<td>Categoria: ${tipo.cargo}</td>
					</c:if>	
				</c:forEach>   
		<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="personal" items="${listadop}">
					<c:if test="${personal.categoriaPersonal.id==i}">
						<tr>
						<td>${personal.apellido}</td>
						<td>${personal.nombre}</td>
						<td><input type="checkbox" name="idpersonal[${personal.idPersonal}]" value="${personal.idPersonal}"></td>
						</tr>
					</c:if>	
				</c:forEach>
			</tbody>
		</table>
		<br><br><br>
    </c:forEach>
	<button class="btn-agregar" Type="Submit"/>Bajar del evento</button>
</form:form>	     
</body>
</html>