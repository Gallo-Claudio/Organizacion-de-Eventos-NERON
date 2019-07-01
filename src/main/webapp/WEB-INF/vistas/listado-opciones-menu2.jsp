<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Listado para la seleccion del menu</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>

COPIA PARA EXTRAS<br><br><br>

<form:form action="registra-reserva-menu2" method="POST" modelAttribute="vm">
 


		<table border="1" cellpadding="1" cellspacing="0">
			<thead>
				<tr>
				<th>Descripcion</th>
				<th>Precio</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
	  			<c:forEach var="menu" items="${listaopciones}">
						<tr>
						<td>${menu.nombre}</td>
						<td>${menu.precio}</td>
						<td><input type="checkbox" name="idmenu[${menu.id}]" value="${menu.id}"></td>
						</tr>

				</c:forEach>
			</tbody>
		</table>
		<br><br><br>




	<button class="btn-agregar" Type="Submit"/>Agregar</button>
</form:form>


        <!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>


<div>
	<h2>Menus que te pueden interesar</h2>
   TOPEEE:${tope}

	<br>

	<c:if test="${tope>=1}">
		<h2>menu</h2><br>
		<c:forEach items="${menus1}" var="menu">

			${menu.descripcion}
			$${menu.costo}<br>


		</c:forEach>
	</c:if>

	<br>


	<br>

	<c:if test="${tope>=2}">
		<h2>menu</h2><br>
		<c:forEach items="${menus2}" var="menu">

			${menu.descripcion}
			$${menu.costo}<br>


		</c:forEach>
	</c:if>

	<br>


	<br>

	<c:if test="${tope>=3}">
		<h2>menu</h2><br>
		<c:forEach items="${menus3}" var="menu">

			${menu.descripcion}
			$${menu.costo}<br>


		</c:forEach>
	</c:if>

	<br>


	<br>

	<c:if test="${tope>=4}">
		<h2>menu</h2><br>
		<c:forEach items="${menus4}" var="menu">

			${menu.descripcion}
			$${menu.costo}<br>


		</c:forEach>
	</c:if>

	<br>


	<br>

	<c:if test="${tope>=5}">
		<h2>menu</h2><br>
		<c:forEach items="${menus5}" var="menu">

			${menu.descripcion}
			$${menu.costo}<br>


		</c:forEach>
	</c:if>

	<br>



</div>


</body>
</html>
