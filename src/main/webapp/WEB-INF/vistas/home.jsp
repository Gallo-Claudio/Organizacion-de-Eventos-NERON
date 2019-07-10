<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
	<body>

	<nav class="navbar navbar-default" role="navigation">
		<!-- El logotipo y el icono que despliega el menú se agrupan
             para mostrarlos mejor en los dispositivos móviles -->
		<div class="navbar-header">

			<a class="navbar-brand" href="#">Logotipo</a>
		</div>

		<!-- Agrupar los enlaces de navegación, los formularios y cualquier
             otro elemento que se pueda ocultar al minimizar la barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li ><a  href="home"> Inicio    </a></li>
				<li><a  href="salones-a-puntuar"> Nuestros Salonest</a></li>
				<li><a  href="menus-a-puntuar"> Nuestros Menus</a></li>

			</ul>


				<div class="navbar-form navbar-left">
					<h5>Bienvenidos a</h5>
					<h5>Organizacion de Eventos NERON</h5>
				</div>




					<form class="navbar-form navbar-left"  method="post"  action="salon"  >
						<div class="form-group">
						<input type="submit" value="Reservar" class="btn btn-success">
						</div>
					</form>


					<form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
						<div class="form-group">
						<input type="submit" value="cerrar sesion" class="btn btn-success">
						</div>
					</form>

		</div>
	</nav>

<div>
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
</div>

<table class=" table table-hover text-center mt-4">
	<h2>Nuestros mejores salones </h2>


	<c:forEach items="${salones}" var="salon">

		<td class="border border-success" >
			<img class="card-img-top" src=".." alt="Card image cap">
			<h2>${salon.nombre}</h2><br>

			<h4> Precio: $${salon.precio}</h4><br>
			<a href="VerImagenes?id=${salon.id}">
				<input  class=" btn btn-success" type="button" value="Ver mas"/>
			</a><br>
			<h4> Valoracion Actual:${salon.puntaje}</h4><br>

       </td>

	</c:forEach>


</table>
	<!-- Footer -->
	<footer class="page-footer font-small blue pt-4">

		<!-- Footer Links -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<!-- Content -->
					<h5 class="text-uppercase">Footer Content</h5>
					<p>Here you can use rows and columns to organize your footer content.</p>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none pb-3">

				<!-- Grid column -->


				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>

					<ul class="list-unstyled">
						<li>
							<a href="#!">Link 1</a>
						</li>
						<li>
							<a href="#!">Link 2</a>
						</li>

					</ul>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Links -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">© 2018 Copyright:
			<a href="https://mdbootstrap.com/education/bootstrap/"> MDBootstrap.com</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
	</body>
</html>