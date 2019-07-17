<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salones</title>
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
	  
	         <div class="container">
            <div class="row call-to-action">
			<form class="navbar-form navbar-left"  method="post"  action="salon"  >
						<div class="form-group">
						<input type="submit" value="Reservar" class="btn btn-success btn-grande">
						</div>
			</form>
			</div>
		</div>
	  
        <div class="container">
            <div class="row">	  
	  
<h3>Nuestros Salones </h3>

<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>


<div>
    <form action="buscar" method="GET">
        <input type="search" name="input" placeholder="Nombre del salon">
        <input type="submit" value="buscar">

    </form><br>
</div>
<c:forEach items="${salones}" var="salon">


	<table class="table table-hover text-center mt-4" border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
		<td>
   		 <img class="card-img-top imagen-salon" src="img/${salon.imagenCard}" alt="Card image cap">	
		</td>
		<td>
		 <form:form action="puntuar-salon" method="Post" modelAttribute="mvSalon">
     <h2 class="card-title">  ${salon.nombre}</h2>
     <h3><p class="card-title">    Precio:${salon.precio}</p></h3>
 <!--     <a href="VerImagenes?id=${salon.id}">
         <input  class=" btn btn-success" type="button" value="Ver mas"/>
     </a>--> 
     <h3 class="card-title">   Valoración Actual:${salon.puntaje}/10</h3>
        <input   name="id"   type="hidden" value="${salon.id}"/>
        <label>Pon aquí tu puntaje</label>
        <input type="number" max="10" min="1" name="puntaje" >
        <input type="submit" value="puntuar" >
 </form:form>
		</td>
		</tr>
	</tbody>
	</table> 

</c:forEach>
</div></div>

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
