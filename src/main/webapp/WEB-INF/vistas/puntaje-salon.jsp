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
${tope}
<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>
<c:forEach items="${salones}" var="salon">
 <form:form action="puntuar-salon" method="Post" modelAttribute="mvSalon">
        ${salon.nombre}<br>
        ${salon.ubicacion.localidad}<br>
        ${salon.ubicacion.calle}<br>
        ${salon.ubicacion.numero}<br>
        ${salon.precio}<br>
     <a href="VerImagenes?id=${salon.id}">
         <input  class=" btn btn-success" type="button" value="Ver mas"/>
     </a>
        Valoracion Actual:${salon.puntaje}<br>
        <input   name="id"   type="hidden" value="${salon.id}"/>
        <label>Pon aqui tu puntaje</label>
        <input type="number"  name="puntaje" >
        <input type="submit" value="puntuar" >
 </form:form>
</c:forEach>
</body>
</html>
