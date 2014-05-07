<%-- 
    Document   : empleados
    Created on : 25-abr-2014, 19:12:38
    Author     : alumno
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Empleados</title>
        
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body style="padding: 10px">
        <div class="col-xs-10 col-sm-8 col-md-6 col-lg-5">
            <h3>Listado de empleados a dia <fmt:formatDate value="${fecha}"/></h3>

            <table class="table table-bordered" >
                <thead>
                    <tr class="success">
                        <th>Nombre</th>
                        <th>Salario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${empleados}" var="e">
                    <tr>
                        <td>${e.nombre}</td>
                        <td><fmt:formatNumber type="currency" value="${e.salario}"/></td>
                        <td>
                        	<a href="modificarempleado.htm?id=${e.idEmpleado}" class="btn btn-success">Modificar</a>
                        	<a href="#" id="lnkBor" data-code="${e.idEmpleado}" class="btn btn-success">Borrar</a>
                        </td>
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
