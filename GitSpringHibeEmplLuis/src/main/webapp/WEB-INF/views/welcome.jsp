<%-- 
    Document   : welcome
    Created on : 25-abr-2014, 19:04:10
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body style="padding: 10px">
        <div class="jumbotron">
			  <h1>Spring-Hibernate<br> <small>Portal de Gestión de Empleados</small></h1>
		</div>

        <table class="col-lg-12">
            <tr>
                <td style="padding: 2px"><a href="empleados.htm" class="btn btn-success col-lg-12">Ver Empleados</a></td>
                <td style="padding: 2px"><a href="conocimientos.htm" class="btn btn-success col-lg-12">Ver Conocimientos</a></td>
                <td style="padding: 2px"><a href="puestos.htm" class="btn btn-success col-lg-12">Ver Puestos</a></td>
            </tr>
            <tr>
                <td style="padding: 2px"><a href="altaempleado.htm" class="btn btn-success col-lg-12">Nuevo Empleado</a></td>
                <td style="padding: 2px"><a href="altaconocimiento.htm" class="btn btn-success col-lg-12">Nuevo Conocimiento</a></td>
                <td style="padding: 2px"><a href="altapuesto.htm" class="btn btn-success col-lg-12">Nuevo Puesto</a></td>
            </tr>
        </table>
        
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
