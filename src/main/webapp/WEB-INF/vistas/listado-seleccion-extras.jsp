<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<c:forEach var="variable" items="${listaSeleccionDeExtras}"> 
		<tr>
		<td>${variable.nombre}</td>
		<td>${variable.precio}</td>
		<td><input type="checkbox" value="${variable.id}"></td>
		</tr>
    </c:forEach>       
</body>
</html>