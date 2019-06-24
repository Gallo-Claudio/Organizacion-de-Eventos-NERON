<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" type="text/css" href="css/extras.css">
    <title>Selección de Salon</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <form class="border border-success" method="GET" action="tomarDatos">
                <h2><i><u>Buscar</u> <u>salones</u></i></h2>


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

            <center><form:form class="border border-success"  ModelAttribute="id,horario,fecha" action="validar" method ="post" >
                <input  type="hidden" value="${fecha}" name="fecha"/>

                <h2><i><u>Resultados</u></i></h2>
                <div>
                    <h3>Capital</h3>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success"><label>Nombre</label></td>
                            <td class="success"><label>Localidad</label></td>
                            <td class="success"><label>Calle</label></td>
                            <td class="success"><label>Número</label></td>
                            <td class="success"><label>Precio</label></td>
                            <td class="success"><label>Más</label> </td>

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
                    <h3>Zona Oeste</h3>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">- </td>
                            <td class="success"><label>Nombre</label></td>
                            <td class="success"><label>Localidad</label></td>
                            <td class="success"><label>Calle</label></td>
                            <td class="success"><label>Número</label></td>
                            <td class="success"><label>Precio</label></td>
                            <td class="success"><label>Más</label></td>

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
                    <h3>Zona Sur</h3>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success"><label>Nombre</label></td>
                            <td class="success"><label>Localidad</label></td>
                            <td class="success"><label>Calle</label></td>
                            <td class="success"><label>Número</label></td>
                            <td class="success"><label>Precio</label></td>
                            <td class="success"><label>Más</label></td>

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
                    <h3>Zona Norte</h3>
                    <table class="table table-condenced">
                        <tr>
                            <td class="success">-</td>
                            <td class="success"><label>Nombre</label></td>
                            <td class="success"><label>Localidad</label></td>
                            <td class="success"><label>Calle</label></td>
                            <td class="success"><label>Número</label></td>
                            <td class="success"><label>Precio</label></td>
                            <td class="success"><label>Más </label></td>

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
                
                <br><br><br>
                    <h3>Horarios</h3>
                    <select class="list-group" name="horario">

                        <option >de 9:00 hs a 13:00hs</option>


                        <option>de 15:00 hs a 19:00hs</option>


                        <option>de 21:00 hs a 00:00hs o más</option>


                    </select><br>
                </div>


                <c:if test="${empty id}">
                    <input  type="hidden" value=0 name="id"/>
                </c:if>

                <a><input  class=" btn btn-success" type="button" value="Cancelar"/></a>
                <input  class=" btn btn-success" type="submit" value="Confirmar y continuar"/>




            </form:form></center>
        </div>
    </div>
    </div>

</c:if>
 <br><br><br>
<center><h2><i>Recomendaciones de Menú</i></h2>
<a href="RecomendacionesMenu">
    <input  class=" btn btn-success" type="button" value="Menus"/></center>
</a>
</body>
</html>