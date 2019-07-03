<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Listado para la seleccion del menu</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>

Seleccion de Extras<br><br><br>

<form:form action="registra-reserva-extras" method="POST" modelAttribute="vm">

		<table border="1" cellpadding="1" cellspacing="0">
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