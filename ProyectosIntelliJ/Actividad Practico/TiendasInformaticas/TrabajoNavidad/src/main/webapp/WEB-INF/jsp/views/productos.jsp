<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.iesbelen.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
  <title>Detalle del Producto</title>
</head>
<body>
<%
  Producto producto = (Producto) request.getAttribute("producto");
  if (producto != null) {
%>
<h1><%= producto.getNombre() %></h1>
<p>Precio: $<%= producto.getPrecio() %></p>
<p>Descripción: <%= producto.getDescripcion() %></p>
<form action="carrito" method="post">
  <input type="hidden" name="productoId" value="<%= producto.getId() %>">
  <button type="submit">Añadir al Carrito</button>
</form>
<%
} else {
%>
<h1>Producto no encontrado</h1>
<%
  }
%>
</body>
</html>
