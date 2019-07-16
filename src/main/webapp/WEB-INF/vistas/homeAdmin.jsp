<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="row central">
        <div class="navbar-form navbar-left">
            <center><p class="grande"><h2>Bienvenido a</p></h2></center>
           <center> <p class="grande"><h2>Organización de Eventos NERON</h2></p></center>
        </div>

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
