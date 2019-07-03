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
</head>
<body>
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
<div class="">
<c:forEach items="${salones}" var="salon">
    <img class="card-img-top" src=".." alt="Card image cap">
    <div class="card-body>">
 <form:form action="puntuar-salon" method="Post" modelAttribute="mvSalon">

     <h2 class="card-title">  ${salon.nombre}</h2>

     <h2 class="card-title">    Precio:${salon.precio}</h2>h2
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
</c:forEach>
</div>
</body>
</html>
