<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<%-- ENCABEZADO --%>
	<jsp:include page="encabezado-cliente.jsp"></jsp:include>


	<%-- CUERPO --%>

	<div class="container">
		<div class="row">

			<p>Cancelacion de Reserva</p>
			<p>Seleccione una reserva para su cancelacion</p>
			
			<p>CONDICIONES DE CANCELACION</p>
			<p>Si la cancelación se realiza antes de los 30 días de la fecha de la realización del evento, la devolución será del 20% de lo abonado</p><br>
			<p>Si la cancelación se realiza antes de los 15 días de la fecha de la realización del evento, la devolución será del 10% de lo abonado</p><br>
			<p>Si la cancelación se realiza antes de los 30 días de la fecha de la realización del evento, la devolución será del 5% de lo abonado</p><br>
			
			
			<c:if test="${!empty mensajeerror}">
	 			<div class="alert alert-danger">${mensajeerror}</div>
			</c:if>
			
			<form:form action="detalle-cancelacion-reserva-seleccionada" method="POST" modelAttribute="idreserva">
				<table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
					<thead>
						<tr>
							<th>Salón</th>
							<th>Dirección</th>
							<th>Fecha</th>
							<th>Horario</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listadoPendientesCliente}">

							<tr>
								<td>${item.salon.nombre}</td>
								<td>${item.salon.direccion}</td>
								<td>${item.fecha}</td>
								<td>${item.horario}</td>
								<td><input type="radio" name="idreserva" value="${item.idReserva}"></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				
				<c:if test="${empty idreserva}">
					<input type="hidden" value=0 name="idreserva" />
				</c:if>
				
				<button class="btn-agregar" Type="Submit" />Seleccionar</button>
				<a href="/proyecto-limpio-spring/home" class="btn btn-danger">Cancelar</a>
			</form:form>
			<br> <br> <br>
		</div>
	</div>
	<%-- PIE --%>
	<jsp:include page="pie.jsp"></jsp:include>

</body>
</html>