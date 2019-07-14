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

			<p>Eventos pendientes</p>
			<p>Seleccione un evento para ver el detalle del mismo</p>
			

			<form:form action="listado-eventos-pendientes-cliente" method="POST" modelAttribute="idreserva">
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
				<button class="btn-agregar" Type="Submit" />Seleccionar</button>
			</form:form>
			<br> <br> <br>
		</div>
	</div>
	<%-- PIE --%>
	<jsp:include page="pie.jsp"></jsp:include>

</body>
</html>