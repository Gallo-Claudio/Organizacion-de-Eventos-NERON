<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

<title>CATERING</title>
</head>

<body class="bg-success">
 <h1>INGRESE SU RESERVA:</h1>
 
<form class="form-inline mt-5 " action="recibirReserva" modelAttribute="reservaAttribute" method="post">
  <div class="form-group">
   <label for="fecha">
  INGRESE UNA FECHA:<br></label>
  <input type="text" class="form-control mb-2 mt-5" name="fecha" path="fecha" ><br>
  </div>
  
    <div class="form-group">
   <label for="numeroInvitados">
  INGRESE UN NUMERO DE INVITADOS:<br></label>
  <input type="text" class="form-control" name="numeroInvitados" path="numeroInvitados" ><br>
  </div>
   <div class="form-group">
   <label for="zona">
  Ingrese zona:<br></label>
  <input type="text" class="form-control" name="zona" path="zona" ><br>
</div>
  <div class="form-group">
   <label for="cliente.nombre">
  Ingrese su nombre:<br></label>
  <input type="text" class="form-control" name="cliente.nombre" path="cliente.nombre" ><br>
</div>

  <div class="form-group">
   <label for="cliente.apellido">
  Ingrese apellido:<br></label>
  <input type="text" class="form-control" name="cliente.apellido" path="cliente.apellido" ><br>
</div>

  <div class="form-group">
   <label for="cliente.email">
  Ingrese email:<br></label>
  <input type="text" class="form-control" name="cliente.email" path="cliente.email" ><br>
</div>

<div class="form-group">
   <label for="fingerFood">
  
  Finger-food:<br></label>
<select name="fingerFood" class="form-control" multiple path="fingerFood">
  <option value="fatay">Fatay</option>
  <option value="bastones de muzzarella y espinaca">Bastones de muzzarella y espinaca</option>
  <option value="sandwich de pollo">Sándwich de pollo</option>
  <option value="chips saludables">Chips saludables</option>
  <option value="brick al huevo">Brick al huevo</option>
  <option value="salchichas con cheddar">Salchichas con cheddar</option>
</select><br><br>
</div>

<div class="form-group">
   <label for="bebidas">

  Bebidas:<br></label>
<select name="bebidas" class="form-control" multiple path="bebidas">
  <option value="gaseosas">Gaseosas</option>
  <option value="gaseosas sin azucar">Gaseosas sin azucar</option>
  <option value="Jugos exprimidos">Jugos exprimidos</option>
  
  <option value="Cerveza artesanal">Cerveza artesanal</option>
  
</select><br><br>
</div>

<div class="form-group">
   <label for="evento">
Ingrese el tipo de evento:<br></label>
<select name="evento" multiple path="evento" class="form-control">
  <option value="casamiento">Casamiento</option>
  <option value="cumpleaños de 15">Cumpleaños de 15</option>
  <option value="Bar mitzvá">Bar mitzvá</option>
  <option value="Reuniones">Reuniones</option>
</select><br>
</div>
 
  <input type="submit" name="submit" class=" btn btn-primary mt-5" value="enviar">
  
  
  
</form>



<
<h1>${reservasKey}</h1>
<h1>Reservas realizadas por otros clientes:</h1>
<c:forEach var="reserva" items="${reservasKey}"> 
							"${reserva.fingerFood}"
							"${reserva.bebidas}"
							"${reserva.evento}"
    					</c:forEach>


</body>
</html>