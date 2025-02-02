<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Carrito de Compras</title>
</head>
<body>
<h1>Tu Carrito</h1>
<%
  List<Producto> carrito = (List<Producto>) request.getAttribute("carrito");
  if (carrito != null && !carrito.isEmpty()) {
%>
<ul>
  <%
    double total = 0;
    for (Producto producto : carrito) {
      total += producto.getPrecio();
  %>
  <li>
    <strong><%= producto.getNombre() %></strong><br>
    Precio: $<%= producto.getPrecio() %><br>
    <form action="carrito" method="post" style="display:inline;">
      <input type="hidden" name="action" value="remove">
      <input type="hidden" name="productoId" value="<%= producto.getId() %>">
      <button type="submit">Eliminar</button>
    </form>
  </li>
  <%
    }
  %>
</ul>
<p>Total: $<%= total %></p>
<form action="checkout" method="post">
  <button type="submit">Proceder al Pago</button>
</form>
<%
} else {
%>
<p>El carrito está vacío.</p>
<%
  }
%>
</body>
</html>
