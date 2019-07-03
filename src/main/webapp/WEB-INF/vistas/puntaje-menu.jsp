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
</head>
<body>
<h3>Nuestros Menus </h3>

<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>
<div class="table-bordered" style="width: 18rem;">

<c:forEach var = "i" begin = "1" end = "6">
<c:forEach items="${listaopciones}" var="menu">
    <img class="card-img-top" src=".." alt="Card image cap">
    <div class="card-body>">
    <c:forEach var="tipo" items="${secciones}">
        <c:if test="${tipo.id==i}">
        <h3 class="card-title">${tipo.detalle}</h3>
        </c:if>
    </c:forEach>
    <form:form action="puntuar-menu" method="Post" modelAttribute="mvMenu">

       <h2 class="card-title"> ${menu.descripcion}</h2>
        <p class="card-text" >Precio:${menu.precio}(cada 10 personas)</p>


    <h3 class="card-title"> Valoracion Actual:${menu.puntaje}/10</h3>
        <input   name="id"   type="hidden" value="${menu.idMenu}"/>
    <h3 class="card-title">Danos tu opinion</h3>
        <input type="number"  name="puntaje" >
        <input class=" btn btn-success" type="submit" value="puntuar" >
    </form:form>
</c:forEach>
</c:forEach>
    </div>
</div>

</body>
</html>
