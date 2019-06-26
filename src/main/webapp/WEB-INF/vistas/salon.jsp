<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" type="text/css" href="css/extras.css">
    <title>Seleccion de Salon</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <form class="border border-success" method="GET" action="tomarDatos">
                <h2>Buscar salones</h2>


                <br>
                <label><p>Cantidad de invitados</p></label>
                <input class="form-control"  value="${cantidad}" type="number"  name="cantidad">
                <br>
                <label><p>Fecha</p></label>
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

            <form:form class="border border-success"  ModelAttribute="id,horario,fecha" action="validar" method ="post" >
                <input  type="hidden" value="${fecha}" name="fecha"/>

                <label>Resultados</label>
                <div>
                    <h2>Capital</h2>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success">Nombre</td>
                            <td class="success">Localidad</td>
                            <td class="success">Calle</td>
                            <td class="success">Numero</td>
                            <td class="success">Precio</td>
                            <td class="success">Mas </td>

                        </tr>
                        <c:forEach items="${capital}" var="salon">
                            <tr>
                                <td><input   name="id"   type="radio" value="${salon.id}"/></td>
                                <td>${salon.nombre}</td>

                                <td>${salon.ubicacion.localidad}</td>
                                <td>${salon.ubicacion.calle}</td>
                                <td>${salon.ubicacion.numero}</td>
                                <td>${salon.precio}</td>
                                <td>
                                    <a href="VerImagenes?id=${salon.id}">
                                        <input  class=" btn btn-success" type="button" value="Ver mas"/></a>
                                </td>
                            </tr>


                        </c:forEach>

                    </table>
                </div>


                <br>
                <div>
                    <h2>Zona Oeste</h2>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">- </td>
                            <td class="success">Nombre</td>
                            <td class="success">Localidad</td>
                            <td class="success">Calle</td>
                            <td class="success">Numero</td>
                            <td class="success">Precio</td>
                            <td class="success">Mas</td>

                        </tr>
                        <c:forEach items="${oeste}" var="salon">
                            <tr>
                                <td><input name="id"   type="radio" value="${salon.id}"/></td>
                                <td>${salon.nombre}</td>
                                <td>${salon.ubicacion.localidad}</td>
                                <td>${salon.ubicacion.calle}</td>
                                <td>${salon.ubicacion.numero}</td>
                                <td>${salon.precio}</td>
                                <td>
                                    <a href="VerImagenes?id=${salon.id}">
                                        <input  class=" btn btn-success" type="button" value="Ver mas"/></a>
                                </td>
                            </tr>


                        </c:forEach>
                    </table>
                </div>
                <br>

                <div>
                    <h2>Zona Sur</h2>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success">Nombre</td>
                            <td class="success">Localidad</td>
                            <td class="success">Calle</td>
                            <td class="success">Numero</td>
                            <td class="success">Precio</td>
                            <td class="success">Mas</td>

                        </tr>
                        <c:forEach items="${sur}" var="salon">
                            <tr>
                                <td><input   name="id"   type="radio" value="${salon.id}"/></td>
                                <td>${salon.nombre}</td>
                                <td>${salon.ubicacion.localidad}</td>
                                <td>${salon.ubicacion.calle}</td>
                                <td>${salon.ubicacion.numero}</td>
                                <td>${salon.precio}</td>
                                <td>
                                    <a href="VerImagenes?id=${salon.id}">
                                        <input  class=" btn btn-success" type="button" value="Ver mas"/></a>
                                </td>
                            </tr>


                        </c:forEach>
                    </table>
                </div>

                <br>
                <div>
                    <h2>Zona Norte</h2>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success">Nombre</td>
                            <td class="success">Localidad</td>
                            <td class="success">Calle</td>
                            <td class="success">Numero</td>
                            <td class="success">Precio</td>
                            <td class="success">Mas </td>

                        </tr>
                        <c:forEach items="${norte}" var="salon">
                            <tr>
                                <td>
                                    <input  name="id"  type="radio" value="${salon.id}"/>
                                </td>
                                <td>${salon.nombre}</td>
                                <td>${salon.ubicacion.localidad}</td>
                                <td>${salon.ubicacion.calle}</td>
                                <td>${salon.ubicacion.numero}</td>

                                <td>${salon.precio}</td>
                                <td>
                                    <a href="VerImagenes?id=${salon.id}">
                                        <input  class=" btn btn-success" type="button" value="Ver mas"/></a>
                                </td>

                            </tr>


                        </c:forEach>
                    </table>
                </div>

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

<h2>Recomendaciones de Menu</h2>
<a href="RecomendacionesMenu">
    <input  class=" btn btn-success" type="button" value="Menus"/>
</a>
</body>
</html>
