
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.iesbelen.model.Pala"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Marca" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Optional" %>

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
        #pagar{
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 15px;
        }

        #boton{
            border: 2px solid orange;
            border-radius: 5px;
            color: #ffffff;
            background-color: orange;
            height: 40px;
            width: 100px;
        }

    </style>
</head>

<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Pagar</h1>
        </div>
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
        Optional<Pala> carrito = (Optional<Pala>) request.getAttribute("carrito");
        if (carrito.isPresent()) {
    %>

    <div style="margin-top: 12px;" class="clearfix">
        <div style="float: left;width: 20%"><%= carrito.get().getModelo()%></div>
        <div style="float: left;width: 20%"><%= carrito.get().getTipo()%></div>
        <div style="float: left;width: 20%"><%= carrito.get().getPrecio()%></div>
        <div style="float: none;width: auto;overflow: hidden;">
        </div>
    </div>
    <%

    } else {
    %>
    No hay registros de producto
    <% } %>
</div>

<footer>
    <div id="pagar">
        <form action="${pageContext.request.contextPath}">
            <input id="boton" type="submit" value="Pagar"/>
        </form>
    </div>
</footer>
</body>

</html>
