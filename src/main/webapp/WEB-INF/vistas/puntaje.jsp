<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	    <!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/neron.css" rel="stylesheet" >
	    <link href="css/extras.css" rel="stylesheet" >
	</head>
	<body>
	
	<body>
		<div class = "container">
	  <center><h2>Ingreso de puntajes</h2></center> <br><br><br>
	  
	   
	   
				<center><form:form action="ingresar-puntaje" method="POST" modelAttribute="puntajesMenu,tipoDeEvento">
				  	<input class="tipodemenu" name="puntaje" placeholder="Ingrese el puntaje" /> <br><br>
				  	
				  	<select class="tipomenu" name="tipoDeEvento">
						<c:forEach var="tipodemenu" items="${listatiposmenu}"> 
							<option value="${tipodemenu.id}">${tipodemenu.detalle}</option>
    					</c:forEach>
					    </select>
				  	
				     	
						<c:forEach var="tipodemenu" items="${listaPuntaje}"> 
							<option value="${tipodemenu.id}">${tipodemenu.puntaje}</option>
    					</c:forEach>
					    

					<button class="btn-agregar" Type="Submit"/>Agregar</button>
					<a href="/proyecto-limpio-spring/home" class="btn-salir">Salir</a>
				</form:form> </center>       
        </div>
        	<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>