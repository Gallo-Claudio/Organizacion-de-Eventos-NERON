<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<!--Carousel Wrapper-->
<div class="row">
    <div class="col-md-12">
          <div class="mdb-lightbox no-margin">


            <c:forEach items="${imagenes}" var="imagenes">
            <figure class="col-md-4">

                    <img alt="${imagenes.nombre}" src="img/${imagenes.nombre}" width="790" height="444">

                    <h3 class="text-center my-3">Photo title</h3>

            </figure>
       </c:forEach>








    </div>
    </div>
</div>

</body>
</html>
