<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado Historial de trabajo del Personal</title>
<link href="css/gallo.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="css/extras.css">
</head>
<body>
				
	<center><table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Identificador</th>
	<th>Nombre</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="personal" items="${listado}"> 
		<tr>
		<td>${personal.id}</td>
		<td>${personal.nombre}</td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>   </center>
		     
</body>
</html>