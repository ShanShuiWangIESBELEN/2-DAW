<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Pala" %>
<%@page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Pala</title>
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

        #foto{
            margin-top: 70px;
            margin-left: 130px;
        }


        #volver{
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 45px;
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

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Detalle Pala</h1>
        </div>

    </div>

    <div class="clearfix">
        <hr/>
    </div>

    <% Optional<Pala> pala = (Optional<Pala>) request.getAttribute("pala");
        if (pala.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Modelo</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= pala.get().getModelo() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Tipo</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= pala.get().getTipo() %>" readonly="readonly"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Precio</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= pala.get().getPrecio() %>" readonly="readonly"/>
        </div>
    </div>

    <div id="foto">
        <img src="<%=request.getContextPath()%>/imgPala/<%=pala.get().getCodigo()%>.jpg">
    </div>
    <% } else { %>

    request.sendRedirect("pala/");

    <% } %>

</div>

<footer>
    <div id="volver">
        <form action="${pageContext.request.contextPath}/tienda/pala/">
            <input id="boton" type="submit" value="Volver"/>
        </form>
    </div>
</footer>
</body>



</html>