<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<%-- ENCABEZADO --%>
	<jsp:include page="encabezado-cliente.jsp"></jsp:include>



	<%-- CUERPO --%>


	<c:if test="${!empty mensaje}">
		<h1>${mensaje}</h1>
	</c:if>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<form class="border border-success" method="GET" action="tomarDatos">
					<h2>Buscar salones</h2>


					<br> <label>Cantidad de invitados</label> <input
						class="form-control" value="${cantidad}" type="number"
						name="cantidad"> <br> <label>Fecha</label> <input
						class="form-control" value="${fecha}" type="date" name="fecha">




					<br> <input class="btn btn-success" type="submit"
						name="enviar" value="Buscar salones"> <br>
				</form>

			</div>
		</div>
	</div>



	<c:if test="${not empty isset}">
		<div class="container">
			<div class="row">

				<form:form class="border border-success" ModelAttribute="salon"
					action="validar" method="post">
					<input type="hidden" value="${fecha}" name="fecha" />
					<input type="hidden" value="${cantidad}" name="cantidad" />

					<c:forEach var="i" begin="1" end="4">
						<c:forEach var="zona" items="${zonas}">
							<c:if test="${zona.id==i}">
								<h3>${zona.nombre}</h3>
							</c:if>
						</c:forEach>
						<table class="table table-hover text-center mt-4" border="1"
							cellpadding="1" cellspacing="0">
							<thead>
								<tr>
									<th width="400" class="enc">Nombre</th>
									<th width="100" class="enc">Precio</th>
									<th width="100" class="enc">Capacidad</th>
									<th width="400" class="enc">Direcci�n</th>
									<th width="100" class="enc">Valoraci�n</th>
									<th width="70" class="enc"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="salon" items="${salones}">
									<c:if test="${salon.zona.id==i}">
										<tr>
											<td class="alt-celda">${salon.nombre}</td>
											<td class="alt-celda">${salon.precio}</td>
											<td class="alt-celda">${salon.capacidadMaxima}</td>
											<td class="alt-celda">${salon.direccion}</td>
											<td class="alt-celda">${salon.puntaje}/10</td>

											<td><input type="radio" name="id" value="${salon.id}"></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>


					</c:forEach>


					<div class="container">
						<div class="row call-to-action">
							<div>
								<h3>Horarios</h3>
								<select class="list-group" name="horario">
									<option>de 9:00 hs a 13:00hs</option>
									<option>de 15:00 hs a 19:00hs</option>
									<option>de 21:00 hs a 00:00hs o m�s</option>
								</select><br>
							</div>


							<c:if test="${empty id}">
								<input type="hidden" value=0 name="id" />
							</c:if>

							<a><input class=" btn btn-success" type="button"
								value="Cancelar" /></a> <input class=" btn btn-success"
								type="submit" value="Confirmar y continuar" />
						</div>
					</div>


				</form:form>
			</div>
		</div>
		</div>

	</c:if>

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
