<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/extras.css">
	
	<title>Listado</title>
</head>

<header>
				<center><b><i>Nerón - Seleccione los extras deseados para su evento</i></b></center><br><br>

	
	
	</header>

<body>
	<center><table border="6" cellpadding="4" cellspacing="6">
	<thead>
	<tr>
	<th><i>Show</i></th>
	<th><i>Precio</i></th>
	</tr>
	</thead>
	<form:form action="sele-extras?idReserva=${id}" method="POST" modelAttribute="mvExtras">
 <!-- sacar el form y ponerlo afuera del foreach -->					
	<c:forEach var="variable" items="${listadoFinal2}"> 
		<tr>
		<td><b><i>${variable.nombre}</i></b></td>

		<td><b>$<i>${variable.precio}</i></b></td>

		<td><input name="id" type="checkbox" value="${variable.id}"/></td>
			

		</tr>
   	</c:forEach>  

   	<input type="submit">
</form:form>
	

 
</body>
</html>