<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/extras.css">
	
	<title>Listado</title>
</head>

<header>
				<center><b><i>Nerón - Listado salones eliminados</i></b></center><br><br>

	
	
	</header>

<body>
	<center><table border="6" cellpadding="4" cellspacing="6">
	<thead>
	<tr>
	<th><i>Salon</i></th>
	</tr>
	</thead></center>
	<tbody>
	<c:forEach var="variable" items="${listadoFinal}"> 
		<tr>
		<td><b><i>${variable.nombre}</i></b></td>
		<td><input type="checkbox" value="${variable.id}"></td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>   	     
</body>
</html>