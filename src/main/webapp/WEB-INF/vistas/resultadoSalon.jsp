<%--
  Created by IntelliJ IDEA.
  User: rocio
  Date: 13/6/2019
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/extras.css">
    <title>Resultados de la busqueda de salones</title>
</head>
<body>
 <c:if test="${mensaje==1}">
    <h2>Seleccion de salon exitosa </h2>
</c:if>
 <c:if test="${mensaje==2}">
     <h2>Seleccione un salon </h2>
 </c:if>



</body>
</html>
