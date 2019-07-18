<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<jsp:include page="encabezado-cliente-index.jsp"></jsp:include>


	<%-- CUERPO --%>

	<%-- <div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="la.jpg" alt="Los Angeles">
			</div>

			<div class="item">
				<img src="chicago.jpg" alt="Chicago">
			</div>

			<div class="item">
				<img src="ny.jpg" alt="New York">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>  --%>
	<div class="container">
		<div class="row call-to-action">
			<form class="navbar-form navbar-left" method="post" action="salon">
				<div class="form-group">
					<input type="submit" value="Reservar" class="btn btn-success btn-grande">
				</div>
			</form>
		</div>
	</div>
	<table class=" table table-hover text-center mt-4">
		<h2>Nuestros mejores salones</h2>


		<c:forEach items="${salones}" var="salon">

			<td class="border border-success">
			<img class="card-img-top imagen-salon-grande" src="img/${salon.imagenCard}" alt="Card image cap">
				<h2>${salon.nombre}</h2> <br>

				<h4>Precio: $<fmt:formatNumber currencySymbol="" value="${salon.precio}" type="currency"/></h4>
				
				<%-- 	<a href="VerImagenes?id=${salon.id}"> <input  class=" btn btn-success" type="button" value="Ver mas"/></a>--%>
  
				<h4>Valoración Actual: <fmt:formatNumber type="number" pattern="#0.00" maxFractionDigits="2" value="${salon.puntaje}"/> / 10</h4>
				</td>

		</c:forEach>
	</table>

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