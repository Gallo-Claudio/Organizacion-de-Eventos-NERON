<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
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
            <li ><a class="btn" href="homeAdmin">inicio</a></li>
       <!-- <li><a href="listado-final-extras">Extras</a></li>
            <li><a href="listado-final-menu">Menu</a></li>
            <li><a href="listado-final-salon">Salon</a></li> -->  
            <li><a class="btn" href="ingresar-menu">Ingresar Menú</a></li>
            <li><a class="btn" href="listado-eventos-pendientes">REASIGNACION PERSONAL - Eventos pendientes</a></li>
            <li><a class="btn" href="ingreso-extras">Ingresar Extras</a></li>
            <li><a class="btn" href="listado-final-extras">Listado de Extras</a></li>
            
        </ul>

        <div class="navbar-form navbar-left">
            <h5>Organizacion de Eventos NERON</h5>
        </div>

        <form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
            <div class="form-group">
                <input type="submit" value="cerrar sesion" class="btn btn-success">
            </div>
        </form>

    </div>
</nav>


	  <%-- CUERPO --%>
	  
        <div class="container">
            <div class="row">
            
<form:form action="reasigna-personal" method="POST" modelAttribute="vmReasignaPersonal">
<input type="hidden" name="idreserva" value="${idreserva}">

<p>Listado del personal asignado al evento de la reserva numero: ${idreserva}</p>
<p>Con reasignaciones</p>

	<c:forEach var = "i" begin = "1" end = "6">
	  			<c:forEach var="tipo" items="${cargos}">
					<c:if test="${tipo.id==i}">
						<td>Categoria: ${tipo.cargo}</td>
					</c:if>	
				</c:forEach>   
		<table class="table table-hover text-center mt-4"  border="1" cellpadding="1" cellspacing="0">
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
	<a href="/proyecto-limpio-spring/homeAdmin" class="btn-agregar btn btn success">Salir</a>
</form:form>
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
</body>
</html>