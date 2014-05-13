
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Empleado</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body style="padding: 10px">
        
        <form:form method="post" commandName="empleado" role="form">
        	<form:hidden path="idEmpleado"/>
            <div class="form-group col-md-4 col-lg-2">
                <form:label class="control-label" path="nombre">Nombre:</form:label>
                <form:input class="form-control" path="nombre"/>
                <form:errors path="nombre"/>
            </div>
            <div class="form-group col-md-4 col-lg-2">
                <form:label class="control-label" path="salario">Salario:</form:label>
                <form:input class="form-control" path="salario"/>
                <form:errors path="salario"/>
            </div>
            <div class="form-group col-md-4 col-lg-3">
            	<form:label class="control-label" path="puesto">Puesto:</form:label>
            	<form:select class="form-control" path="puesto"><!--  multiple="true" permite varios -->
            		<!-- Si queremos añadir una opcion por defecto -->
            		<form:option value="-1" label="-De que curra este-"/>
            		<form:options items="${puestos}" />
            	</form:select>
            	<form:errors path="puesto"/>
            </div>
            <div class="form-group col-md-4 col-lg-3">
            	<form:label class="control-label" path="conocimientos">Conocimientos:</form:label>
            	<form:select class="form-control" path="conocimientos" multiple="multiple"><!--  multiple="true" permite varios -->
            		<form:options items="${conocimientos}" />
            	</form:select>
            	<form:errors path="conocimientos"/>
            </div>
            <div class="form-group col-md-4 col-lg-2">
            	<form:label class="control-label" path="foto">File input:</form:label>
            	<form:input path="foto" type="file" />
            </div>
            
            <br>
            <div class="col-md-4 col-lg-2">
            	<input type="submit" value="Insert" class="btn btn-success">
            </div>
            
        </form:form>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
