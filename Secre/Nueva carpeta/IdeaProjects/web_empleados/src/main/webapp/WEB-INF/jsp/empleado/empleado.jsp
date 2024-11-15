<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Empleado" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Empleado</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }
    </style>
</head>

<%@ include file="/WEB-INF/jsp/formato/header.jspf" %>

<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >

    <div style="float: left; width: 50%">
        <h1>Empleado</h1>
    </div>

    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left;width: 10%">Código</div>
        <div style="float: left;width: 10%">NIF</div>
        <div style="float: left;width: 10%">Nombre</div>
        <div style="float: left;width: 10%">Apellido 1</div>
        <div style="float: left;width: 10%">Apellido 2</div>
        <div style="float: left;width: 10%">Codigo Departamento</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaEm") != null) {
            List<Empleado> listaEm= (List<Empleado>)request.getAttribute("listaEm");

            for (Empleado empleado : listaEm) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 10%"><%= empleado.getCodigo()%></div>
        <div style="float: left;width: 10%"><%= empleado.getNif()%></div>
        <div style="float: left;width: 10%"><%= empleado.getNombre()%></div>
        <div style="float: left;width: 10%"><%= empleado.getApellido1()%></div>
        <div style="float: left;width: 10%"><%= empleado.getApellido2()%></div>
        <div style="float: left;width: 10%"><%= empleado.getCodigo_departamento()%></div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/sitio/empleado/" style="display: inline;">
                <input type="submit" value="Ver Detalle" />
            </form>
            <form action="${pageContext.request.contextPath}/sitio/empleado/editar/<%= empleado.getCodigo()%>" style="display: inline;">
                <input type="submit" value="Editar" />
            </form>
            <form action="${pageContext.request.contextPath}/sitio/empleado/" method="post" style="display: inline;">
                <input type="hidden" name="__method__" value="delete"/>
                <input type="submit" value="Eliminar" />
            </form>
        </div>
    </div>
    <%
        }
    } else {
    %>
    No hay registros de empleados
    <% } %>
</div>
</body>


</html>