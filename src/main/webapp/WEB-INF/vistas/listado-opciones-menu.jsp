<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado para la selección del menú</title>
<link href="css/gallo.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="css/extras.css">
</head>
<body>
				
<center><h2><i>Listado para la selección del menú</i></h2></center><br><br><br>
<center><form:form action="registra-reserva-menu" method="GET" modelAttribute="idmenu">
	<c:forEach var = "i" begin = "1" end = "6">
	  			<p><h2><i><c:forEach var="tipo" items="${secciones}">
					<c:if test="${tipo.id==i}">
						<td>${tipo.detalle}</td>
					</c:if>	
				</c:forEach></i></p></h2>
		<table border="6" cellpadding="4" cellspacing="6">
			<thead>
				<tr>
				<th>Descripción</th>
				<th>Precio</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="menu" items="${listaopciones}">
					<c:if test="${menu.tipoDeEvento.id==i}">
						<tr>
						<td>${menu.descripcion}</td>
						<td>${menu.costo}</td>
						<td><input type="checkbox" name="idmenu" value="${menu.id}"></td>
						</tr>
					</c:if>	
				</c:forEach>
			</tbody>
		</table>
		<br><br><br>
    </c:forEach>    

	<button class="btn-agregar" Type="Submit"/>Agregar</button>   
</form:form></center>		  
			 
        
        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>			          		     
</body>
</html>
