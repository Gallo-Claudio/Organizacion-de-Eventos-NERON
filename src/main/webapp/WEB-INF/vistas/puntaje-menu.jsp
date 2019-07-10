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
    <title>Menus</title>
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
<h3>Nuestros Menus </h3>

<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>


<c:forEach var = "i" begin = "1" end = "6">
<c:forEach items="${listaopciones}" var="menu">
    <div class="container" >
        <div class="border border-success">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <c:forEach var="tipo" items="${secciones}">
        <c:if test="${tipo.id==i}">
        <h3 class="card-title">${tipo.detalle}</h3>
        </c:if>
    </c:forEach>
    <form:form action="puntuar-menu" method="Post" modelAttribute="mvMenu">
        <img class="card-img-top" src=".." alt="Card image cap">
       <h2 class="card-title"> ${menu.descripcion}</h2>
        <p class="card-text" >Precio:${menu.precio}(cada 10 personas)</p>


    <h3 class="card-title"> Valoracion Actual:${menu.puntaje}/10</h3>
        <input   name="id"   type="hidden" value="${menu.idMenu}"/>
    <h3 class="card-title">Danos tu opinion</h3>
        <input type="number" max="10" min="1" name="puntaje" >
        <input class=" btn btn-success" type="submit" value="puntuar" >
    </form:form>
    </div>

    </div>
    </div>
</c:forEach>
</c:forEach>



</body>
</html>
