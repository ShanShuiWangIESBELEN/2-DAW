<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Fabricante" %>
<%@page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Producto</title>
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
    <form action="${pageContext.request.contextPath}/tienda/productos/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Producto</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Precio
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="precio"/>
            </div>
        </div>


            <%List<String> listaFab = (List<String>) request.getAttribute("fabricantesNombres");
                if (listaFab != null) {
                %>
            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    <label for="fabricanteId">Nombre fabricante</label>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <select name="fabricante" id="fabricanteId">
                    <% for (int indice = 0; indice < listaFab.size(); indice++) {%>
                    <option value="<%=(indice+1)%>"><%= listaFab.get(indice)%></option>
                    <% } %>
                </select>
                </div>
            </div>
        <% } else { %>
            request.sendRedirect("productos/");
        <% } %>
    </form>
</div>

</body>

<%@ include file="/WEB-INF/jsp/formato/footer.jspf" %>

</html>