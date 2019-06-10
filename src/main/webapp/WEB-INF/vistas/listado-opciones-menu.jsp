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
		<tr>
		<td>${menu.descripcion}</td>
		<td>${menu.costo}</td>
		<td>${menu.tipoDeEvento}</td>
		<td><input type="checkbox" value="${menu.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>   	     
</body>
</html>