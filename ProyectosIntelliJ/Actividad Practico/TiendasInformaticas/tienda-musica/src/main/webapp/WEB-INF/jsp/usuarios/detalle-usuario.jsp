
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.iesbelen.model.Usuario" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

    </style>
</head>
<body>
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Detalle Producto</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/usuarios">
                    <input type="submit" value="Volver"/>
                </form>
            </div>

        </div>
    </div>

    <div class="clearfix">
        <hr/>
    </div>
        <% Optional<Usuario> optUser = (Optional<Usuario>) request.getAttribute("usuario");
        if (optUser.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Código</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUser.get().getIdUsuario() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Usuario</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUser.get().getUsuario() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Password</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optUser.get().getPassword() %>" readonly="readonly"/>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Rol</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input value="<%= optUser.get().getRol() %>" readonly="readonly"/>
            </div>
        </div>

        <% } else { %>

        request.sendRedirect("usuarios/");

        <% } %>

    </div>


</body>
</html>
