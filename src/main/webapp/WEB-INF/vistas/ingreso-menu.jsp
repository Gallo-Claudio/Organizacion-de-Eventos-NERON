<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	    <!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/neron.css" rel="stylesheet" >
	</head>
	<body>
        <div class="container">
            <div class="row">
	   <h1>Ingreso de los distintos platos y bebidas que componen el Menu</h1>
	   <p class="descripcion">Desde aquí se ingresan los diferentes platos/bebidas/postres que componen el listado de opciones a elegir por el cliente</p>
	   
	   
				<form:form action="registro-plato-menu" method="POST" modelAttribute="vmIngresoMenu">
				
				<form:errors path="*" element="div" class="alert alert-danger" />
				
				  	<input class="tipomenu" name="descripcion" value="${descripcion}" placeholder="Ingrese la descripcion del plato o bebida" />
				  	<p>El precio debe ser ingresado en el siguiente formato  10.00</p>
				  	<input class="tipomenu" name="precio" value="${precio}" placeholder="Ingrese el costo" />
				  	
				     	<select class="tipomenu" name="tipoDeMenu">
						<c:forEach var="tipodemenu" items="${listatiposmenu}"> 
							<option value="${tipodemenu.id}">${tipodemenu.detalle}</option>
    					</c:forEach>
					    </select>

					<button class="btn-agregar" Type="Submit"/>Agregar</button>
					<a href="/proyecto-limpio-spring/home" class="btn-salir">Salir</a>
				</form:form>
        
        
            </div>
        </div>
        	<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
