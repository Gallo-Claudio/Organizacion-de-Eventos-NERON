<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	
<title>Opiniones</title>
</head>
<body>
Nos interesa conocer su opinión para poder mejorar nuestro servicio:
<form action="recibirOpinion" method="post" modelAttribute="opinionAttribute">

Salón:<br>

  <input type="radio" name="salon" value="100" path="salon">Excelente <br>
  <div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="100"
  aria-valuemin="0" aria-valuemax="100" style="width:100%">
    <span class="sr-only">Excelente </span>
  </div>
</div>

  <input type="radio" name="salon" value="70" path="salon">Bueno
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="70"
  aria-valuemin="0" aria-valuemax="100" style="width:70%">
    <span class="sr-only">Bueno </span>
  </div>
</div>


  
  <input type="radio" name="salon" value="20" path="salon">Malo <br>
  <div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="20"
  aria-valuemin="0" aria-valuemax="100" style="width:20%">
    <span class="sr-only">Malo </span>
  </div>
</div>
${mensaje2}
Menu:<br>
 <input type="radio" name="menu" value="100" path="menu">Excelente <br>
  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-success active" role="progressbar" aria-valuenow="100"
  aria-valuemin="0" aria-valuemax="100" style="width:100%">
    <span class="sr-only">Excelente </span>
  </div>
</div>

  <input type="radio" name="menu" value="70" path="menu">Bueno
<div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-success active" role="progressbar" aria-valuenow="70"
  aria-valuemin="0" aria-valuemax="100" style="width:70%">
    <span class="sr-only">Bueno </span>
  </div>
</div>


  
  <input type="radio" name="menu" value="20" path="menu">Malo <br>
  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-success active" role="progressbar" aria-valuenow="20"
  aria-valuemin="0" aria-valuemax="100" style="width:20%">
    <span class="sr-only">Malo </span>
  </div>
</div>
${mensaje3}
Show/Música:<br>
  <input type="radio" name="show" value="100" path="show">Excelente <br>
  <div class="progress">
  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="100"
  aria-valuemin="0" aria-valuemax="100" style="width:100%">
    <span class="sr-only">Excelente </span>
  </div>
</div>

  <input type="radio" name="show" value="70" path="show">Bueno
<div class="progress">
  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="70"
  aria-valuemin="0" aria-valuemax="100" style="width:70%">
    <span class="sr-only">Bueno </span>
  </div>
</div>


  
  <input type="radio" name="show" value="20" path="show">Malo <br>
  <div class="progress">
  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
  aria-valuemin="0" aria-valuemax="100" style="width:20%">
    <span class="sr-only">Malo </span>
  </div>
</div>
${mensaje1}
Ballet de mozos:<br>
  <input type="radio" name="empleados" value="100" path="empleados">Excelente <br>
  <div class="progress">
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100"
  aria-valuemin="0" aria-valuemax="100" style="width:100%">
    <span class="sr-only">Excelente </span>
  </div>
</div>

  <input type="radio" name="empleados" value="70" path="empleados">Bueno
<div class="progress">
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="70"
  aria-valuemin="0" aria-valuemax="100" style="width:70%">
    <span class="sr-only">Bueno </span>
  </div>
</div>


  
  <input type="radio" name="empleados" value="20" path="empleados">Malo <br>
  <div class="progress">
  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
  aria-valuemin="0" aria-valuemax="100" style="width:20%">
    <span class="sr-only">Malo </span>
  </div>
</div>
${mensaje4}


<button class="btn btn-primary" Type="Submit">Enviar</button>
</form><BR>

EVENTOS RECOMENDADOS, SEGUN LAS CALIFICACIONES DE NUESTROS CLIENTES:
${recomendadas}
${puntaje}

<c:forEach var="reserva" items="${recomendadas}"> 
						<H2>Cliente	"${reserva.cliente.nombre}"</H2>
						<H2>Evento	"${reserva.evento}"</H2>
						<H2>Bebidas	"${reserva.bebidas}"</H2>
						<H2>Salon	"${reserva.salon.nombre}"</H2>
						<H2>FingerFood	"${reserva.fingerFood}"</H2>
						<H2>Calificacion	"${reserva.puntaje}"</H2>
							
							
							
    					</c:forEach>
    					

</body>
</html>