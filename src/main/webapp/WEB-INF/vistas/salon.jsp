<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
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
	  
	  
<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <form class="border border-success" method="GET" action="tomarDatos">
                <h2>Buscar salones</h2>


                <br>
                <label>Cantidad de invitados</label>
                <input class="form-control"  value="${cantidad}" type="number"  name="cantidad">
                <br>
                <label>Fecha</label>
                <input class="form-control" value="${fecha}" type="date"  name="fecha">




                <br>
                <input class="btn btn-success" type="submit" name="enviar"  value="Buscar salones">
                <br>
            </form>

        </div>
    </div>
</div>



<c:if test="${not empty isset}">
    <div class="container">
        <div class="row">

            <form:form class="border border-success"  ModelAttribute="salon" action="validar" method ="post" >
                <input  type="hidden" value="${fecha}" name="fecha"/>
                <input  type="hidden" value="${cantidad}" name="cantidad"/>

                <c:forEach var = "i" begin = "1" end = "4">
                    <c:forEach var="zona" items="${zonas}">
                        <c:if test="${zona.id==i}">
                            <h3>${zona.nombre}</h3>
                        </c:if>
                    </c:forEach>
                    <table class="table table-hover text-center mt-4" border="1" cellpadding="1" cellspacing="0">
                        <thead>
                        <tr>
                            <th width="400" class="enc">Nombre</th>
                            <th width="100" class="enc">Precio</th>
                            <th width="100" class="enc">Capacidad</th>
                            <th width="400" class="enc">Direccion</th>
                            <th width="100" class="enc">Valoración</th>
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
	                <div >
                    <h3>Horarios</h3>
                    <select class="list-group" name="horario">
                        <option >de 9:00 hs a 13:00hs</option>
                        <option>de 15:00 hs a 19:00hs</option>
                        <option>de 21:00 hs a 00:00hs o mas</option>
                    </select><br>
                </div>


                <c:if test="${empty id}">
                    <input  type="hidden" value=0 name="id"/>
                </c:if>

                <a><input  class=" btn btn-success" type="button" value="Cancelar"/></a>
                <input  class=" btn btn-success" type="submit" value="Confirmar y continuar"/>
			</div>
		</div>


            </form:form>
        </div>
    </div>
    </div>

</c:if>


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
