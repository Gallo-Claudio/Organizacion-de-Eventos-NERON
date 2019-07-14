<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
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

			<h2>Resumen de lo seleccionado para el evento</h2>
			<br> <br>

			<p>
				<b>Cantidad de Invitados:</b> ${reservafinal.cantidadDeInvitados}<br>
				<b>Fecha del evento:</b> ${reservafinal.fecha}<br> <b>Horario:</b>
				${reservafinal.horario}
			</p>


			<h3>Salon:</h3>
			<table class="table  tabla-ancho2" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="700">Nombre: ${reservafinal.salon.nombre}</td>
					<td width="100">Precio:</td>
					<td width="100">$ ${reservafinal.salon.precio}</td>
				</tr>
			</table>
			<br>


			<h3>Menu elegido:</h3>
			<table class="table tabla-ancho" border="0" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th colspan="2" width="600" class="detalle">Precio por plato</th>
					</tr>
				</thead>

				<c:forEach var="tipomenu" items="${menuseleccionado}">
					<tbody>
						<tr>
							<td width="520">${tipomenu.descripcion}</td>
							<td>$ ${tipomenu.precio}</td width="80">
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<table class="table  tabla-ancho2" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="520">Precio del menu por persona:</td>
					<td width="80">$ ${precios[0]}</td>
					<td width="200">Precio total del menu:</td>
					<td width="100">$ ${precios[1]}</td>
				</tr>
			</table>
			<br>


			<h3>Extras seleccionado:</h3>
			<table class="table tabla-ancho" border="0" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th colspan="2" width="600" class="detalle">Precio</th>
					</tr>
				</thead>

				<c:forEach var="tipoextra" items="${extraseleccionado}">
					<tbody>
						<tr>
							<td width="520">${tipoextra.nombre}</td>
							<td>$ ${tipoextra.precio}</td width="80">
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<table class="table  tabla-ancho2" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="520">Precio total de los extras:</td>
					<td width="80">$ ${precios[2]}</td>
					<td width="200"></td>
					<td width="100">$ ${precios[2]}</td>
				</tr>
			</table>
			<br>



			<h3>Personal para asistir al evento</h3>
			<table class="table  tabla-ancho2" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="700"></td>
					<td width="100">Precio:</td>
					<td width="100">$ ${precios[3]}</td>
				</tr>
			</table>
			<br>


			<table class="table  tabla-ancho2" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="750">
						<h2>PRECIO FINAL:</h2>
					</td>
					<td width="150">
						<h3>$ ${precios[4]}</h3>
					</td>
				</tr>
			</table>
			<br> <a href="/proyecto-limpio-spring/home"
				class="btn-agregar btn btn success">Salir</a>


		</div>
	</div>

	<%-- PIE --%>
	<jsp:include page="pie.jsp"></jsp:include>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
