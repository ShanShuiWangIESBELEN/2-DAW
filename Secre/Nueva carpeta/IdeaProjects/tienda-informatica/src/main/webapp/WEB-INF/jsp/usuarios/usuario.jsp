<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Fabricante" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.dao.FabricanteDTO" %>
<%@ page import="org.iesbelen.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
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
            <h1>Usuarios</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/tienda/usuarios/crear">
                    <input type="submit" value="Crear">
                </form>
            </div>

        </div>
    </div>


    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left;width: 16.5%">Id</div>
        <div style="float: left;width: 16.5%">Usuario</div>
        <div style="float: left;width: 16.5%">Password</div>
        <div style="float: left;width: 16.5%;">Rol</div>
        <div style="float: left;width: 16.5%;overflow: hidden;">Accion</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaUsu") != null) {
            List<Usuario> listaUsu = (List<Usuario>) request.getAttribute("listaUsu");

            for (Usuario usuario : listaUsu) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 16.5%"><%= usuario.getIdUsuario()%>
        </div>
        <div style="float: left;width: 16.5%"><%= usuario.getUsuario()%>
        </div>
        <div style="float: left;width: 16.5%"><%= usuario.getPassword()%>
        </div>
        <div style="float: left;width: 16.5%"><%= usuario.getRol()%>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/tienda/usuarios/<%= usuario.getIdUsuario()%>"
                  style="display: inline;">
                <input type="submit" value="Ver Detalle"/>
            </form>
            <form action="${pageContext.request.contextPath}/tienda/usuarios/editar/<%= usuario.getIdUsuario()%>"
                  style="display: inline;">
                <input type="submit" value="Editar"/>
            </form>
            <form action="${pageContext.request.contextPath}/tienda/usuarios/borrar/" method="post"
                  style="display: inline;">
                <input type="hidden" name="__method__" value="delete"/>
                <input type="hidden" name="codigo" value="<%= usuario.getIdUsuario()%>"/>
                <input type="submit" value="Eliminar"/>
            </form>
        </div>
    </div>

    <%
        }
    } else {
    %>
    No hay registros de fabricante
    <% } %>
</div>
</body>
</html>
