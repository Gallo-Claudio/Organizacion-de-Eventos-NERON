<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>
				


	<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='1'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><form:checkbox value="${menu.id}"></form:checkbox></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>
		<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='2'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>	
			  	<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='3'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>
		<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='4'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>
			  	<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='5'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>
		<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Descripcion</th>
	<th>Costo</th>
	<th>Tipo</th>
	<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="menu" items="${listaopciones}"> 
		<c:if test="${menu.tipoDeEvento.id=='6'}">
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento.detalle}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
		</c:if>	
    </c:forEach>  
	</tbody>
	</table>   
			  
			  <br><br><br>	        		     
</body>
</html>
