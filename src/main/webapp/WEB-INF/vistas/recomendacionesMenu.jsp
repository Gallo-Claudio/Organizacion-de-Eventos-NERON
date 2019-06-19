<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recomendaciones Menu</title>
</head>
<body>
<h2>Menus</h2>
<c:forEach items="${menus}" var="menu">


    <h2>${menu.id}</h2>


</c:forEach>
</body>
</html>
