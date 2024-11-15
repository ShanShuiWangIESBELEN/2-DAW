
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.iesbelen.model.Pala"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Marca" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Palas</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

        body{
            background-image:url("<%=request.getContextPath()%>/imgFondo/fondo1.jpg");
            background-repeat: no-repeat;
            background-position: center center;
            background-size: cover;
            height: 635px;
        }

        footer{
            margin-top: auto;
        }
        #volver{
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 15px;
        }

        #boton{
            border: 2px solid #3498db;
            border-radius: 5px;
            color: #ffffff;
            background-color: #3498db;
            height: 40px;
            width: 100px;
        }

    </style>
</head>

<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Palas</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/tienda/pala/crear">
                    <input type="submit" value="Carrito">
                </form>
            </div>

        </div>
    </div>

    <div class="clearfix">

        <form action="${pageContext.request.contextPath}/tienda/pala" method="GET">
            <input name="filtrar-por">
            <button type="submit">Filtrar</button>
        </form>
    </div>

    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left;width: 20%">Modelo</div>
        <div style="float: left;width: 20%">Tipo</div>
        <div style="float: left;width: 20%">Precio</div>
        <div style="float: left;width: 20%;overflow: hidden;">Acción</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaPala") != null) {
            List<Pala> listaPala= (List<Pala>)request.getAttribute("listaPala");

            for (Pala pala : listaPala) {
    %>

    <div style="margin-top: 12px;" class="clearfix">
        <div style="float: left;width: 20%"><%= pala.getModelo()%></div>
        <div style="float: left;width: 20%"><%= pala.getTipo()%></div>
        <div style="float: left;width: 20%"><%= pala.getPrecio()%></div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/tienda/pala/<%= pala.getCodigo()%>" style="display: inline;">
                <input type="submit" value="Ver Detalle" />
            </form>

        </div>
    </div>
    <%
        }
    } else {
    %>
    No hay registros de producto
    <% } %>
</div>

<footer>
    <div id="volver">
        <form action="${pageContext.request.contextPath}">
            <input id="boton" type="submit" value="Volver"/>
        </form>
    </div>
</footer>
</body>

</html>
