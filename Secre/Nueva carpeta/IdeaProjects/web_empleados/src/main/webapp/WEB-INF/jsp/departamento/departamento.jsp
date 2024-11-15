<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Departamento" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.dto.DepartamentoDTO" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departamento</title>
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

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Departamento</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/sitio/departamento/crear">
                    <input type="submit" value="Crear">
                </form>
            </div>

        </div>
    </div>


    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left;width: 12.5%">Código</div>
        <div style="float: left;width: 12.5%">Nombre</div>
        <div style="float: left;width: 12.5%">Presupuesto</div>
        <div style="float: left;width: 12.5%">Gastos</div>
        <div style="float: left;width: 12.5%">Num empleados</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaDep") != null) {
            List<DepartamentoDTO> listaDep = (List<DepartamentoDTO>) request.getAttribute("listaDep");

            for (DepartamentoDTO departamento : listaDep) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 12.5%"><%= departamento.getCodigo()%>
        </div>
        <div style="float: left;width: 12.5%"><%= departamento.getNombre()%>
        </div>
        <div style="float: left;width: 12.5%"><%= departamento.getPresupuesto()%>
        </div>
        <div style="float: left;width: 12.5%"><%= departamento.getGastos()%>
        </div>
        <div style="float: left;width: 12.5%"><%= departamento.getCountEmpleados()%>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/sitio/departamento/"
                  style="display: inline;">
                <input type="submit" value="Ver Detalle"/>
            </form>
            <form action="${pageContext.request.contextPath}/sitio/departamento/"
                  style="display: inline;">
                <input type="submit" value="Editar"/>
            </form>
            <form action="${pageContext.request.contextPath}/sitio/departamento/" method="post"
                  style="display: inline;">
                <input type="hidden" name="__method__" value="delete"/>
                <input type="submit" value="Eliminar"/>
            </form>
        </div>
    </div>

    <%
        }
    } else {
    %>
    No hay registros de departamentos
    <% } %>
</div>
</body>

</html>