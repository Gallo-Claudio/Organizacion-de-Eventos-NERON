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
Listado para la seleccion del menu<br><br><br>

<form:form action="registra-reserva-menu" method="POST" modelAttribute="vm">
 
	<c:forEach var = "i" begin = "1" end = "6">
	  			<c:forEach var="tipo" items="${secciones}">
					<c:if test="${tipo.id==i}">
						<td>${tipo.detalle}</td>
					</c:if>
				</c:forEach>
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
					<c:if test="${menu.tipoDeMenu.id==i}">
						<tr>
						<td>${menu.descripcion}</td>
						<td>${menu.precio}</td>
						<td><input type="checkbox" name="idmenu[${menu.idMenu}]" value="${menu.idMenu}"></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<br><br><br>

    </c:forEach>


	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>


        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>



	<h2>Menus que te pueden interesar</h2>
	<table class=" table table-hover text-center mt-4">


			<c:forEach var = "i" begin = "1" end = "6">

			<c:forEach items="${menus}" var="menu">
				<td class="card border-primary p-3">
			<img class="card-img-top" src=".." alt="Card image cap">
			<div class="card-body>">
				<c:forEach var="tipo" items="${secciones}">
					<c:if test="${tipo.id==i}">
						<h3 class="card-title">${tipo.detalle}</h3>
					</c:if>
				</c:forEach>


					<h2 class="card-title"> ${menu.descripcion}</h2>
					<p class="card-text" >Precio:${menu.precio}(cada 10 personas)</p>


					<h3 class="card-title"> Valoracion Actual:${menu.puntaje}/10</h3>
					<input   name="id"   type="hidden" value="${menu.idMenu}"/>
					<h3 class="card-title">Danos tu opinion</h3>
					<input type="number"  name="puntaje" >
					<input class=" btn btn-success" type="submit" value="puntuar" >
				</td>
				</c:forEach>
				</c:forEach>







	</table>


</body>
</html>
