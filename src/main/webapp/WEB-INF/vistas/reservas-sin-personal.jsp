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

Reservas sin personal asignado<br><br><br>

<form:form action="registra-reserva-menu" method="GET">


				
		<table border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Reserva Id numero</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="reserva" items="${listaReservaSinPersonal}">
						<tr>
						<td>${reserva.id}</td>
						<td><input type="checkbox" name="idmenu" value="${reserva.id}"></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>

		
		<br><br><br><br><br><br>
		
				<table border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Reserva Id numero</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="reser" items="${listaSinPersonal}">
						<tr>
						<td>${reser.id}</td>
						<td><input type="checkbox" name="idmenu" value="${reser.id}"></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>



	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>


        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
