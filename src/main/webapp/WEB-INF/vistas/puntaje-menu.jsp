<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Menus</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<%-- ENCABEZADO --%>
	<jsp:include page="encabezado-cliente.jsp"></jsp:include>



	<%-- CUERPO --%>

	<div class="container">
		<div class="row call-to-action">
			<form class="navbar-form navbar-left" method="post" action="salon">
				<div class="form-group">
					<input type="submit" value="Reservar" class="btn btn-success btn-grande">
				</div>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="row">

			<h3>Nuestros Menus</h3>

			<c:if test="${!empty mensaje}">
				<h1>${mensaje}</h1>
			</c:if>
<h1>${mensaje}</h1>

			<c:forEach var="i" begin="1" end="6">
				<c:forEach items="${listaopciones}" var="menu">


					<table class="table table-hover text-center mt-4" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td><img class="card-img-top imagen-salon"
									src="img/${menu.imagenCard}" alt="Card image cap"></td>
								<td><c:forEach var="tipo" items="${secciones}">
										<c:if test="${tipo.id==i}">
											<h3 class="card-title">${tipo.detalle}</h3>
										</c:if>
									</c:forEach> <form:form action="puntuar-menu" method="Post"
										modelAttribute="mvMenu">

										<p class="card-title">${menu.descripcion}</p>
										<p class="card-text">Precio: $<fmt:formatNumber currencySymbol="" value="${menu.precio}" type="currency"/></p>


										<h3 class="card-title">Valoración Actual: <fmt:formatNumber type="number" pattern="#0.00" maxFractionDigits="2" value="${menu.puntaje}"/> / 10</h3>
										<input name="id" type="hidden" value="${menu.idMenu}" />
										<h3 class="card-title">Danos tu opinion</h3>
										<input type="number" max="10" min="1" name="puntaje">
										
											<c:if test="${empty puntaje}">
												<input type="hidden" value=0 name="puntaje" />
											</c:if>
										<input class=" btn btn-success" type="submit" value="puntuar">
									</form:form></td>
							</tr>
						</tbody>
					</table>

				</c:forEach>
			</c:forEach>

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
