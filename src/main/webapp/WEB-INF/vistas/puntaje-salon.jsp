<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rocio
  Date: 2/7/2019
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salones</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <!-- El logotipo y el icono que despliega el menú se agrupan
         para mostrarlos mejor en los dispositivos móviles -->
    <div class="navbar-header">

        <a class="navbar-brand" href="#">Logotipo</a>
    </div>

    <!-- Agrupar los enlaces de navegación, los formularios y cualquier
         otro elemento que se pueda ocultar al minimizar la barra -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li ><a  href="home"> Inicio    </a></li>
            <li><a  href="salones-a-puntuar"> Nuestros Salonest</a></li>
            <li><a  href="menus-a-puntuar"> Nuestros Menus</a></li>

        </ul>


        <div class="navbar-form navbar-left">
            <h5>Bienvenidos a</h5>
            <h5>Organizacion de Eventos NERON</h5>
        </div>




        <form class="navbar-form navbar-left"  method="post"  action="salon"  >
            <div class="form-group">
                <input type="submit" value="Reservar" class="btn btn-success">
            </div>
        </form>


        <form class="navbar-form navbar-left"  method="post"  action="cerrarsesion"  >
            <div class="form-group">
                <input type="submit" value="cerrar sesion" class="btn btn-success">
            </div>
        </form>

    </div>
</nav>
<h3>Nuestros Salones </h3>

<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>


<div>
    <form action="buscar" method="GET">
        <input type="search" name="input" placeholder="Nombre del salon">
        <input type="submit" value="buscar">

    </form><br>
</div>
<c:forEach items="${salones}" var="salon">
    <div class="container border border-success" >
        <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <img class="card-img-top" src=".." alt="Card image cap">

 <form:form action="puntuar-salon" method="Post" modelAttribute="mvSalon">

     <h2 class="card-title">  ${salon.nombre}</h2>

     <h2 class="card-title">    Precio:${salon.precio}</h2>
     <a href="VerImagenes?id=${salon.id}">
         <input  class=" btn btn-success" type="button" value="Ver mas"/>
     </a>
     <br>
     <h2 class="card-title">   Valoracion Actual:${salon.puntaje}/10</h2>
        <input   name="id"   type="hidden" value="${salon.id}"/>
        <label>Pon aqui tu puntaje</label>
        <input type="number" max="10" min="1" name="puntaje" >
        <input type="submit" value="puntuar" >

 </form:form>
    </div>
    </div>
</c:forEach>

</body>
</html>
