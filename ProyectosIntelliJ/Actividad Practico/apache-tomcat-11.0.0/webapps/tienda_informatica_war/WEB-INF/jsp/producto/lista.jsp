<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Productos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
<div class="container mt-5">
  <h1 class="mb-4">Lista de Productos</h1>
  <table class="table table-bordered">
    <thead class="table-dark">
    <tr>
      <th>ID</th>
      <th>Nombre</th>
      <th>Descripción</th>
      <th>Precio</th>
      <th>Stock</th>
      <th>Categoría</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Producto> productos = (List<Producto>) request.getAttribute("productos");
      if (productos != null && !productos.isEmpty()) {
        for (Producto producto : productos) {
    %>
    <tr>
      <td><%= producto.getId() %></td>
      <td><%= producto.getNombre() %></td>
      <td><%= producto.getDescripcion() %></td>
      <td>$<%= producto.getPrecio() %></td>
      <td><%= producto.getStock() %></td>
      <td><%= producto.getIdCategoria() %></td>
      <td>
        <a href="<%= request.getContextPath() %>/productos/<%= producto.getId() %>" class="btn btn-info btn-sm">Ver</a>
        <a href="<%= request.getContextPath() %>/productos/editar/<%= producto.getId() %>" class="btn btn-warning btn-sm">Editar</a>
        <form action="<%= request.getContextPath() %>/productos/eliminar" method="post" style="display:inline;">
          <input type="hidden" name="id" value="<%= producto.getId() %>">
          <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que deseas eliminar este producto?');">Eliminar</button>
        </form>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="6" class="text-center">No hay productos disponibles.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <a href="<%= request.getContextPath() %>/productos/crear" class="btn btn-success">Agregar Nuevo Producto</a>
</div>
<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
