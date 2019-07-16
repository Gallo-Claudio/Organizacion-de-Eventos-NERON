<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menus</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/extras.css">
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
	  
<center><h1>Nuestros Menus </h1></center>

<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>


<c:forEach var = "i" begin = "1" end = "6">
<c:forEach items="${listaopciones}" var="menu">
  
  
  	<table class="table table-hover text-center mt-4" border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
		<td>
<img class="card-img-top imagen-salon" src="img/${menu.imagenCard}" alt="Card image cap">
		</td>
		<td>
    <c:forEach var="tipo" items="${secciones}">
        <c:if test="${tipo.id==i}">
        <h3 class="card-title">${tipo.detalle}</h3>
        </c:if>
    </c:forEach>
    
        <form:form action="puntuar-menu" method="Post" modelAttribute="mvMenu">

       <p class="card-title"> ${menu.descripcion}</p>
        <p class="card-text" >Precio:${menu.precio}</p>


    <h3 class="card-title"> Valoracion Actual:${menu.puntaje}/10</h3>
        <input   name="id"   type="hidden" value="${menu.idMenu}"/>
    <h3 class="card-title">Danos tu opinion</h3>
        <input type="number" max="10" min="1" name="puntaje" >
        <input class=" btn btn-success" type="submit" value="puntuar" >
    </form:form>
    
		</td>
		</tr>
	</tbody>
	</table> 
 
</c:forEach>
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
