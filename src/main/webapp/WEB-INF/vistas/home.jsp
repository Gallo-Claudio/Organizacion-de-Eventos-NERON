<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/EstiloSinFondo.css">
</head>
	<body>

 <%-- ENCABEZADO --%>
 
<nav class="navbar navbar-default" role="navigation">
    <!-- El logotipo y el icono que despliega el menú se agrupan
         para mostrarlos mejor en los dispositivos móviles -->
    <div class="logotipo-encabezado"></div>

    <!-- Agrupar los enlaces de navegación, los formularios y cualquier
         otro elemento que se pueda ocultar al minimizar la barra -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li><a class="btn" href="home">Inicio</a></li>
            <li><a class="btn" href="salones-a-puntuar"> Nuestros Salones</a></li>
			<li><a class="btn" href="menus-a-puntuar"> Nuestros Menus</a></li> 
        </ul>

        <div class="navbar-form navbar-left">
            <h5>Organizacion de Eventos NERON</h5>
        </div>

        <form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
            <div class="form-group">
                <input type="submit" value="cerrar sesion" class="btn btn-danger">
            </div>
        </form>

    </div>
</nav>
	
	
	
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
			<form class="navbar-form navbar-left"  method="post"  action="salon"  >
						<div class="form-group">
						<input type="submit" value="Reservar" class="btn btn-success btn-grande">
						</div>
			</form>
			</div>
		</div>
<table class=" table table-hover text-center mt-4">
	<center><h1>Nuestros mejores salones </h1></center>


	<c:forEach items="${salones}" var="salon">

		<td class="border border-success" >
			<img class="card-img-top imagen-salon-grande" src="img/${salon.imagenCard}" alt="Card image cap">
			<h1>${salon.nombre}</h1><br>

			<h4> Precio: $${salon.precio}</h4>
		<%-- 	<a href="VerImagenes?id=${salon.id}">
				<input  class=" btn btn-success" type="button" value="Ver mas"/>
			</a>--%>
			
			<h4> Valoracion Actual:${salon.puntaje}</h4><br>

       </td>

	</c:forEach>


</table>
	
	  <%-- PIE --%>
  
       <footer class="footer container pie">
		<div class="row">
            <div class="col-md-4">
                Universidad Nacional<br>de la Matanza<br>
            </div>

            <div class="col-md-4">
                Taller Web 1<br>
                Tecnicatura en desarrollo Web
            </div>

            <div class="col-md-4">
                Integrantes:<br>
                Rocio,
                Julieta,
                Agustina,
                Claudio
            </div>

        </div>
    </footer>
	
	
	</body>
</html>