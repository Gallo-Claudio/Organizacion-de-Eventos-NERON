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
 <%-- ENCABEZADO --%>
 
<nav class="navbar navbar-default" role="navigation">
    <!-- El logotipo y el icono que despliega el menú se agrupan
         para mostrarlos mejor en los dispositivos móviles -->
    <div class="logotipo-encabezado"></div>

    <!-- Agrupar los enlaces de navegación, los formularios y cualquier
         otro elemento que se pueda ocultar al minimizar la barra -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li><a class="btn" href="home">Inicio</a></li>
            <li><a class="btn" href="salones-a-puntuar"> Nuestros Salones</a></li>
			<li><a class="btn" href="menus-a-puntuar"> Nuestros Menus</a></li> 
        </ul>

        <div class="navbar-form navbar-left">
            <h5>Organizacion de Eventos NERON</h5>
        </div>

        <form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
            <div class="form-group">
                <input type="submit" value="cerrar sesion" class="btn btn-danger">
            </div>
        </form>

    </div>
</nav>
	
	
	
	  <%-- CUERPO --%>
<div class="container">
    <div class="row">	  
	  
<h2>Seleccion del menu</h2><br>
<p><b>Debe seleccionar para:</b><br>
Finger Food: minímo 8 y máximo 14 opciones<br>
Entrada: minímo 1 y máximo 2 opciones<br>
Plato Principal: minímo 1 y máximo 2 opciones<br>
Bebida: minímo 4 y máximo 7 opciones<br>
Postre: minímo 1 y máximo 2 opciones<br>
Mesa Dulce: minímo 4 y máximo 6 opciones<br>
</p>
<br><br>
<div class="table70">
<form:form action="registra-reserva-menu" method="POST" modelAttribute="vm">


<c:if test="${!empty mensajeerror}">
    <div class="alert alert-danger">${mensajeerror}</div>
</c:if>
<form:errors path="*" element="div" class="alert alert-danger" /> 

 
	<c:forEach var = "i" begin = "1" end = "6">
	  			<c:forEach var="tipo" items="${secciones}">
					<c:if test="${tipo.id==i}">
						<h3>${tipo.detalle}</h3>
					</c:if>
				</c:forEach>
		<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th width="650" class="enc">Descripcion</th>
				<th width="100" class="enc">Precio</th>
				<th width="50" class="enc"></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="menu" items="${listaopciones}">
					<c:if test="${menu.tipoDeMenu.id==i}">
						<tr>
						<td class="alt-celda margina-izq">${menu.descripcion}</td>
						<td class="alt-celda">${menu.precio}</td>
						<td class="alt-celda"><input type="checkbox" name="idmenu[${menu.idMenu}]" value="${menu.idMenu}"></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

    </c:forEach>


	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>
</div>

<div class="container ofrecidos">
<h3>Menus que te pueden interesar</h3>
    <div class="row slider">

	<table class=" table table-hover text-center mt-4">


			<c:forEach var = "i" begin = "1" end = "6">

			<c:forEach items="${menus}" var="menu">
				<td class="card border-primary p-3">
			<img class="card-img-top imagen-salon-mini" src="img/${menu.imagenCard}" alt="Card image cap">
			<div class="card-body>">
				<c:forEach var="tipo" items="${secciones}">
					<c:if test="${tipo.id==i}">
						<h4 class="card-title">${tipo.detalle}</h4>
					</c:if>
				</c:forEach>


					<p class="card-title"> ${menu.descripcion}</p>
					<p class="card-text" >Precio:${menu.precio}</p>


					<h4 class="card-title"> Valoracion Actual:${menu.puntaje}/10</h4>
					<input   name="id"   type="hidden" value="${menu.idMenu}"/>
					<h4 class="card-title">Danos tu opinion</h4>
					<input class="puntuacion" type="number"  name="puntaje" >
					<input class=" btn btn-success" type="submit" value="puntuar" >
				</td>
				</c:forEach>
				</c:forEach>

	</table>
	</div></div>
</div>
</div>

  <%-- PIE --%>
  
       <footer class="footer container pie">
		<div class="row">
            <div class="col-md-4">
                Universidad Nacional<br>de la Matanza<br>
            </div>

            <div class="col-md-4">
                Taller Web 1<br>
                Tecnicatura en desarrollo Web
            </div>

            <div class="col-md-4">
                Integrantes:<br>
                Rocio,
                Julieta,
                Agustina,
                Claudio
            </div>

        </div>
    </footer>

        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
