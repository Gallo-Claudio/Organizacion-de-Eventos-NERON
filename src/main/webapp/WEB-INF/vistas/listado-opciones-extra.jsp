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

<h2>Seleccion de Extras</h2><br><br><br>
<div class="table70">
<form:form action="registra-reserva-extras" method="POST" modelAttribute="vm">

		<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th class="enc">Descripcion</th>
				<th class="enc">Precio</th>
				<th class="enc"></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="menu" items="${listaopciones}">
						<tr>
						<td width="650" class="alt-celda margina-izq"">${menu.nombre}</td>
						<td width="100" class="alt-celda">${menu.precio}</td>
						<td width="50" class="alt-celda"><input type="checkbox" name="idmenu[${menu.id}]" value="${menu.id}"></td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
		<br><br><br>

	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>
</div>
</div></div>
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