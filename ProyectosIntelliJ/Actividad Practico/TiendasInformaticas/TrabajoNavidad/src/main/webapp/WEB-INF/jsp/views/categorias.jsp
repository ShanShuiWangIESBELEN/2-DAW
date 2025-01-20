<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Productos por Categoría</title>
</head>
<body>
<h1>Productos</h1>
<ul>
    <%
        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
        if (productos != null && !productos.isEmpty()) {
            for (Producto producto : productos) {
    %>
    <li>
        <strong><%= producto.getNombre() %></strong><br>
        Precio: $<%= producto.getPrecio() %><br>
        <%= producto.getDescripcion() %><br>
        <a href="productos.jsp?productoId=<%= producto.getId() %>">Ver más</a>
    </li>
    <%
        }
    } else {
    %>
    <li>No hay productos disponibles en esta categoría.</li>
    <%
        }
    %>
</ul>
</body>
</html>
