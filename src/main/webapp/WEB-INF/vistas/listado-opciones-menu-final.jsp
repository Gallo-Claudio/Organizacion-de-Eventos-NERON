<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado del Menu</title>
<link href="css/gallo.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="css/extras.css">
</head>
<body>
				
<form:form action="registrar-menu?id=${id}" method="POST" modelAttribute="idReserva,eleccionfingerfood, eleccionentrada, eleccionplatoprincipal, eleccionbebida, eleccionpostre, eleccionmesadulce">
    
    <p>Opciones para el Finger Food</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menufingerfood" items="${fingerfood}"> 
		<tr>
		<td>${menufingerfood.descripcion}</td>
		<td>$ ${menufingerfood.costo}</td>
		<td><input name="eleccionfingerfood" type="checkbox" value="${menufingerfood.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br> 
	
    <p>Opciones para la Entrada</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menuentrada" items="${entrada}"> 
		<tr>
		<td>${menuentrada.descripcion}</td>
		<td>$ ${menuentrada.costo}</td>
		<td><input name="eleccionentrada" type="checkbox" value="${menuentrada.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br>

    <p>Opciones para el Plato Principal</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menuplatoprincipal" items="${platoprincipal}"> 
		<tr>
		<td>${menuplatoprincipal.descripcion}</td>
		<td>$ ${menuplatoprincipal.costo}</td>
		<td><input name="eleccionplatoprincipal" type="checkbox" value="${menuplatoprincipal.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br>
	
	<p>Opciones para la Bebida</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menubebida" items="${bebida}"> 
		<tr>
		<td>${menubebida.descripcion}</td>
		<td>$ ${menubebida.costo}</td>
		<td><input name="eleccionbebida" type="checkbox" value="${menubebida.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br>
	
	<p>Opciones para el Postre</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menupostre" items="${postre}"> 
		<tr>
		<td>${menupostre.descripcion}</td>
		<td>$ ${menupostre.costo}</td>
		<td><input name="eleccionpostre" type="checkbox" value="${menupostre.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br>
	
	<p>Opciones para la Mesa dulce</p>
	<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menumesadulce" items="${mesadulce}"> 
		<tr>
		<td>${menumesadulce.descripcion}</td>
		<td>$ ${menumesadulce.costo}</td>
		<td><input name="eleccionmesadulce" type="checkbox" value="${menumesadulce.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>
	<br><br><br>
	<input type="text" mane="idReserva" value="${id}">
	<button class="btn-agregar" Type="Submit"/>Siguiente</button>
</form:form>    		     
</body>
</html>
