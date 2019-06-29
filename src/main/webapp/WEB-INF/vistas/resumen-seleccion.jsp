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

Resumen de lo seleccionado para el evento<br><br><br>

	  		

<!--${reservafinal.cantidadDeInvitados}<br><br>
${reservafinal.fecha}<br><br>
${reservafinal.salon.nombre}  ${reservafinal.salon.precio}<br><br>
${reservafinal.horario}<br><br>-->

	  			<c:forEach var="detalle" items="${reservafinal.menu}">


 
${detalle.descripcion}<br><br>

				</c:forEach>			




        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
