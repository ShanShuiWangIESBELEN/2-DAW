<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Detalle de Producto</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Detalle de Producto</h1>
  <%
    org.iesbelen.model.Producto producto = (org.iesbelen.model.Producto) request.getAttribute("producto");
    if (producto != null) {
  %>
  <div class="card" style="max-width: 600px; margin: auto;">
    <div class="card-body">
      <p><strong>ID:</strong> <%= producto.getId() %></p>
      <p><strong>Nombre:</strong> <%= producto.getNombre() %></p>
      <p><strong>Descripción:</strong> <%= producto.getDescripcion() %></p>
      <p><strong>Precio:</strong> $<%= producto.getPrecio() %></p>
      <p><strong>Stock:</strong> <%= producto.getStock() %></p>
      <p><strong>Categoría ID:</strong> <%= producto.getIdCategoria() %></p>
      <div class="mt-4">
        <a href="<%= request.getContextPath() %>/productos" class="btn btn-primary">Volver a la lista</a>
        <a href="<%= request.getContextPath() %>/productos/editar/<%= producto.getId() %>" class="btn btn-warning">Editar</a>
      </div>
    </div>
  </div>
  <%
  } else {
  %>
  <div class="alert alert-danger text-center">
    <p>Producto no encontrado.</p>
    <a href="<%= request.getContextPath() %>/productos" class="btn btn-primary">Volver a la lista</a>
  </div>
  <%
    }
  %>
</div>
</body>
</html>
