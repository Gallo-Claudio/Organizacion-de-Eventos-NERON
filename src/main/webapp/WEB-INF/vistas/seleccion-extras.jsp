<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado</title>
</head>
<body>
<c:forEach items="listaFinal" var="variable" >

<input type="checkbox" path="listaFinal" value="${variable.nombre }"/><br>
<input type="checkbox" path="hobbies" value="Astronomy"/><br>
<input type="checkbox" path="hobbies" value="Snowboarding"/><br>


</c:forEach>


</body>
</html>