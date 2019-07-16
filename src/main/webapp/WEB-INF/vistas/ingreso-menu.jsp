<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	    <!-- Bootstrap core CSS -->
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
            <li ><a class="btn" href="homeAdmin">inicio</a></li>
            <!-- <li><a href="listado-final-extras">Extras</a></li>
            <li><a href="listado-final-menu">Menu</a></li>
            <li><a href="listado-final-salon">Salon</a></li> -->  
            <li><a class="btn" href="ingresar-menu">Ingresar Menú</a></li>
            <li><a class="btn" href="listado-eventos-pendientes">REASIGNACION PERSONAL - Eventos pendientes</a></li>
            <li><a class="btn" href="ingreso-extras">Ingresar Extras</a></li>
            <li><a class="btn" href="listado-final-extras">Listado de Extras</a></li>
            
        </ul>

        <div class="navbar-form navbar-left">
            <h5>Organización de Eventos NERON</h5>
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
            <div class="row">
	   <center><h2>Ingreso de los distintos platos y bebidas que componen el Menú</h2></center>
	   <p class="descripcion"><center><h4>Desde aquí se ingresan los diferentes platos/bebidas/postres que componen el listado de opciones a elegir por el cliente</p></h4></center>
	   
	   
				<form:form action="registro-plato-menu" method="POST" modelAttribute="vmIngresoMenu" class="rpm">
				
				<form:errors path="*" element="div" class="alert alert-danger" />
				
				  	<input class="tipomenu" name="descripcion" value="${descripcion}" placeholder="Ingrese la descripcion del plato o bebida" />
				  	<p><h4>El precio debe ser ingresado en el siguiente formato  10.00</p></h4>
				  	<input class="tipomenu" name="precio" value="${precio}" placeholder="Ingrese el costo" />
				  	
				     	<select class="tipomenu" name="tipoDeMenu">
						<c:forEach var="tipodemenu" items="${listatiposmenu}"> 
							<option value="${tipodemenu.id}">${tipodemenu.detalle}</option>
    					</c:forEach>
					    </select>

					<center><button class="btn-agregar btn btn success" Type="Submit"/>Agregar</button>
					<a href="/proyecto-limpio-spring/homeAdmin" class="btn-agregar btn btn success">Salir</a></center>
				</form:form>
            </div>
        </div>
     
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
        
        	<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
