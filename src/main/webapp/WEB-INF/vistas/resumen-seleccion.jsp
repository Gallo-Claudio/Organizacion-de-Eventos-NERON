<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>

Resumen de lo seleccionado para el evento<br><br><br>

	  		

Cantidad de Invitados: ${reservafinal.cantidadDeInvitados}<br><br>
Fecha del evento: ${reservafinal.fecha}<br><br>
Horario: ${reservafinal.horario}<br><br>

--------------------------------------------------------------------------------------------------<br><br>
Salon: ${reservafinal.salon.nombre}     -----> Precio:    ${reservafinal.salon.precio}<br><br>

--------------------------------------------------------------------------------------------------<br><br>
Menu elegido<br><br><br><br>
	  			<c:forEach var="tipomenu" items="${menuseleccionado}">

${tipomenu.descripcion}   ---> Precio por plato:      ${tipomenu.precio}   <br><br>

				</c:forEach>	
				precio del menu por persona: ${precios[0]}
				precio total del menu: ${precios[1]}
				<br><br>			
----------------------------------------------------------------------------------------------<br><br>
Extras seleccionado<br><br><br><br>
	  			<c:forEach var="tipoextra" items="${extraseleccionado}">

${tipoextra.nombre}   ---> Precio:      ${tipoextra.precio}   <br><br>

				</c:forEach>
				precio total de los extras: ${precios[2]}
				<br><br>
----------------------------------------------------------------------------------------------<br><br>
Rersonal para asistir al evento
precio: ${precios[3]}
	
----------------------------------------------------------------------------------------------<br><br>
PRECIO FINAL:${precios[4]}

<br><br><br><br><br><br>


<a href="home">Aceptar</a>
        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
