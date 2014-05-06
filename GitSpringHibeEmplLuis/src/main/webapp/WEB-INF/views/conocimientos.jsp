<%-- 
    Document   : conocimientos
    Created on : 25-abr-2014, 19:26:10
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Conocimientos</title>
        
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body style="padding: 10px">
        
        <div class="col-xs-10 col-sm-8 col-md-6 col-lg-5">
            <h3>Listado de conocimientos a dia <fmt:formatDate value="${fecha}"/></h3>

            <table class="table table-bordered">
                <thead>
                    <tr class="success">
                        <th>Id</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${conocimientos}">
                    <tr>
                        <td>${c.idconocimientos}</td>
                        <td>${c.nombre}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="welcome.htm" class="btn btn-success">Inicio</a>
        </div>
        
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
