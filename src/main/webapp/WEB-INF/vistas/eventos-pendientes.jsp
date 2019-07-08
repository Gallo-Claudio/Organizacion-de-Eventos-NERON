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
				<p>Eventos pendientes a realizarse</p>
				
 <form:form action="listado-personal-asignado" method="POST" modelAttribute="idreserva">  
		<table border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Salon</th>
				<th>Dirección</th>
				<th>Fecha</th>
				<th>Horario</th>
				<th></th>
				<th></th>							
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="item" items="${listadopendientes}">

						<tr>
						<td>${item.salon.nombre}</td>
						<td>${item.salon.direccion}</td>
						<td>${item.fecha}</td>
						<td>${item.horario}</td>						
						<td>${item.idReserva}</td>
						<td><input type="radio" name="idreserva" value="${item.idReserva}"></td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
	<button class="btn-agregar" Type="Submit"/>Seleccionar</button>
</form:form>		
		<br><br><br>

	     
</body>
</html>