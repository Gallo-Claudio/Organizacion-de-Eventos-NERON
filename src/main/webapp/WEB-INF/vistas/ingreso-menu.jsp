<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	    <link href="css/gallo.css" rel="stylesheet" >
	</head>
	<body>
	   <h1>Ingreso de los distintos platos y bebidas que componen el Menu</h1>
	
				<form:form action="registro-plato-menu" method="POST" modelAttribute="descripcion, costo, tipoDeEvento">
				  	<input name="descripcion" placeholder="Ingrese la descripcion del plato o bebida" />
				  	<input name="costo" placeholder="Ingrese el costo" />
				  	
				     	<select name="tipoDeEvento">
						<c:forEach var="tipodemenu" items="${listatiposmenu}"> 
							<option value="${tipodemenu.id}">${tipodemenu.detalle}</option>
    					</c:forEach>
					    </select>

					<button Type="Submit"/>Agregar</button>
				</form:form>
        <a href="/proyecto-limpio-spring/home">Salir</a>
	</body>
</html>
