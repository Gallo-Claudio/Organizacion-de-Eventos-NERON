<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/extras.css">
    <title>Recomendaciones Menu</title>
</head>
<body>
<center><table border="6" cellpadding="4" cellspacing="6">
	<thead>
	<tr>
	<th><b><i>Id</i></b></th>
	<th><b><i>Descripción</i></b></th>
	<th><b><i>Precio</i></b></th>
	</tr>
	</thead>
<h2><i>Menus</i></h2>
<c:forEach items="${menus}" var="menu">

<tr>
   <td><b>${menu.id}</b></td>  
   <td><b>${menu.descripcion}</b></td>  
   <td><b>${menu.costo}</b></td>  
</tr>

</c:forEach>
</body>
</html>
