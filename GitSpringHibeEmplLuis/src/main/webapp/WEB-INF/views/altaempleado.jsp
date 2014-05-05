<%-- 
    Document   : altaempleado
    Created on : 29-abr-2014, 21:06:29
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Empleado</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 10px">
        
        <form:form method="post" commandName="empleado" role="form">
            <div class="form-group col-lg-2">
                <form:label class="control-label" path="nombre">Nombre:</form:label>
                <form:input class="form-control" path="nombre"/>
                <form:errors paht="nombre"/>
            </div>
            <div class="form-group col-lg-2">
                <form:label class="control-label" path="salario">Salario:</form:label>
                <form:input class="form-control" path="salario"/>
                <form:errors paht="salario"/>
            </div>
            <br>
            <input type="submit" value="Insert" class="btn btn-success">
        </form:form>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
