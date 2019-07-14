<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	    <!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

	    <title>Agregar Extras</title>	    
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
            <h5>Organizacion de Eventos NERON</h5>
        </div>

        <form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
            <div class="form-group">
                <input type="submit" value="cerrar sesion" class="btn btn-success">
            </div>
        </form>

    </div>
</nav>


	  <%-- CUERPO --%>
	  
        <div class="container">
            <div class="row">


	<div>
				<center><b><i>Agregar extras</i></b></center><br><br>

	
	
	</div>

	<center>
				<form:form action="registro-extras" method="POST" modelAttribute="Extras">
				<b><i>Por favor, ingrese un extra:</i></b>     <center><input name="nombre" placeholder="Mago"><br><br></center>
				<b><i>Por favor, ingrese un precio:</i></b>	<center><input name="precio" placeholder="200" /><br><br></center>
					

				
					<button class="btn btn-success" Type="Submit"/>Agregar extra</button>
				</form:form>
				<br>
				<a href="/proyecto-limpio-spring/listado-final-extras"><i>Obtener un listado</i></a>
				</center>
				<a href="/proyecto-limpio-spring/homeAdmin" class="btn-agregar btn btn success">Salir</a>
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
	</body>
</html>






