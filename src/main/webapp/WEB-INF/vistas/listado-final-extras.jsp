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

<title>Listado</title>
</head>

<body>

	<%-- ENCABEZADO --%>
	<jsp:include page="encabezado-administrador.jsp"></jsp:include>


	<%-- CUERPO --%>

	<div class="container">
		<div class="row">

			<div>
				<center>
					<b><i>Listado de Extras</i></b>
				</center>
				<br>
				<br>
			</div>


			<table class="table table-hover text-center mt-4" border="1"
				cellpadding="1" cellspacing="0">
				<thead>
					<tr>
						<th><i>Tipo de show</i></th>
						<th><i>Precio</i></th>
					</tr>
				</thead>
				</center>
				<tbody>
					<c:forEach var="variable" items="${listadoFinal}">
						<tr>
							<td><b><i>${variable.nombre}</i></b></td>
							<td><b>$<i>${variable.precio}</i></b></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/proyecto-limpio-spring/homeAdmin"
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