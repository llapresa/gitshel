<%-- 
    Document   : welcome
    Created on : 25-abr-2014, 19:04:10
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
        <link href="/WEB-INF/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 10px">
            
        <h1>Portal de Gestión de Empleados</h1>

        <table>
            <tr>
                <td style="padding: 2px"><a href="empleados.htm" class="btn btn-success">Ver Empleados</a></td>
                <td style="padding: 2px"><a href="conocimientos.htm" class="btn btn-success">Ver Conocimientos</a></td>
                <td style="padding: 2px"><a href="puestos.htm" class="btn btn-success">Ver Puestos</a></td>
            </tr>
            <tr>
                <td style="padding: 2px"><a href="altaempleado.htm" class="btn btn-success">Nuevo Empleado</a></td>
                <td style="padding: 2px"><a href="altaconocimiento.htm" class="btn btn-success">Nuevo Conocimiento</a></td>
                <td style="padding: 2px"><a href="altapuesto.htm" class="btn btn-success">Nuevo Puesto</a></td>
            </tr>
        </table>
        
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="/WEB-INF/js/bootstrap.min.js"></script>
    </body>
</html>
