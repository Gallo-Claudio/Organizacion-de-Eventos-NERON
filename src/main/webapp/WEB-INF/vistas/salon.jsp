<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <title>Seleccion de Salon</title>
</head>
<body>
<c:if test="${!empty mensaje}">
    <h1>${mensaje}</h1>
</c:if>
${salon}
${zona}
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <form class="border border-success" method="GET" action="tomarDatos">
                <h2>Buscar salones</h2>


                <br>
                <label>Cantidad de invitados</label>
                <input class="form-control"  value="${cantidad}" type="number"  name="cantidad">
                <br>
                <label>Fecha</label>
                <input class="form-control" value="${fecha}" type="date"  name="fecha">




                <br>
                <input class="btn btn-success" type="submit" name="enviar"  value="Buscar salones">
                <br>
            </form>

        </div>
    </div>
</div>



<c:if test="${not empty isset}">
    <div class="container">
        <div class="col-md-4 col-md-offset-4">

            <form:form class="border border-success"  ModelAttribute="salon" action="validar" method ="post" >
                <input  type="hidden" value="${fecha}" name="fecha"/>
                <input  type="hidden" value="${cantidad}" name="cantidad"/>

                <c:forEach var = "i" begin = "1" end = "4">
                    <c:forEach var="zona" items="${zonas}">
                        <c:if test="${zona.id==i}">
                            <td>${zona.nombre}</td>
                        </c:if>
                    </c:forEach>
                    <table border="1" cellpadding="1" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Pombre</th>
                            <th>Precio</th>
                            <th>Capacidad</th>
                            <th>direccion</th>
                            <th>Valoracion</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="salon" items="${salones}">
                            <c:if test="${salon.zona.id==i}">
                                <tr>
                                    <td>${salon.nombre}</td>
                                    <td>${salon.precio}</td>
                                    <td>${salon.capacidadMaxima}</td>
                                    <td>${salon.direccion}</td>
                                    <td>${salon.puntaje}/10</td>

                                    <td><input type="checkbox" name="id" value="${salon.id}"></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                    <br><br><br>

                </c:forEach>
                <div >
                    <h2>Horarios</h2>
                    <select class="list-group" name="horario">

                        <option >de 9:00 hs a 13:00hs</option>


                        <option>de 15:00 hs a 19:00hs</option>


                        <option>de 21:00 hs a 00:00hs o mas</option>


                    </select><br>
                </div>


                <c:if test="${empty id}">
                    <input  type="hidden" value=0 name="id"/>
                </c:if>

                <a><input  class=" btn btn-success" type="button" value="Cancelar"/></a>
                <input  class=" btn btn-success" type="submit" value="Confirmar y continuar"/>




            </form:form>
        </div>
    </div>
    </div>

</c:if>

</body>
</html>
