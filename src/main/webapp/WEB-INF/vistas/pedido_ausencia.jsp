<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<%-- ENCABEZADO --%>
	<jsp:include page="encabezado-personal.jsp"></jsp:include>



	<%-- CUERPO --%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<form class="border border-success" method="POST" action="validar__Datos" modelAttribute="Licencia">
				<br><br><br>
					<h4>Seleccione la fecha que no podra asistir</h4>

					<c:if test="${!empty mensajefecha}">
	 			  		 <div class="alert alert-danger">${mensajefecha}</div>
					</c:if>


					<br> <label>Fecha</label>
					<input class="form-control" value="${fecha}" type="date" name="fecha">

					<center><br> <input class="btn btn-success" type="submit" name="enviar" value="Aceptar"></center> <br><br><br>
				</form>
			</div>
			<div>
			<br>
			<br>
			<br>
			</div>
			
		</div>
	</div>


<tbody>
					<c:forEach var="variable" items="${listadoFinal}">
						<tr>
							<td class="alt-celda">${variable.fecha}</td>
						</tr>
					</c:forEach>
				</tbody>

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
