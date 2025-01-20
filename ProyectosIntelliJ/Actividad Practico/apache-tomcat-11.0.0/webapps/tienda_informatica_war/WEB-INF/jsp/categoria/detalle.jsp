<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Detalle de Categoría</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      background-color: #f9f9f9;
      color: #333;
    }

    h1 {
      text-align: center;
      color: #444;
    }

    .container {
      max-width: 600px;
      margin: 20px auto;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #ddd;
      border-radius: 8px;
    }

    p {
      font-size: 14px;
      margin: 10px 0;
    }

    p strong {
      color: #555;
    }

    .actions {
      text-align: center;
      margin-top: 20px;
    }

    .actions a {
      text-decoration: none;
      color: #fff;
      background-color: #007bff;
      padding: 8px 12px;
      border-radius: 5px;
      font-size: 14px;
      margin: 0 5px;
      display: inline-block;
    }

    .actions a:hover {
      background-color: #0056b3;
    }

    .not-found {
      color: #d9534f;
      font-weight: bold;
      text-align: center;
    }
  </style>
</head>
<body>
<h1>Detalle de Categoría</h1>
<div class="container">
  <%
    org.iesbelen.model.Categoria categoria = (org.iesbelen.model.Categoria) request.getAttribute("categoria");
    if (categoria != null) {
  %>
  <p><strong>ID:</strong> <%= categoria.getId() %></p>
  <p><strong>Nombre:</strong> <%= categoria.getNombre() %></p>
  <p><strong>Descripción:</strong> <%= categoria.getDescripcion() %></p>
  <div class="actions">
    <a href="<%= request.getContextPath() %>/categorias">Volver a la lista</a>
    <a href="<%= request.getContextPath() %>/categorias/editar/<%= categoria.getId() %>">Editar</a>

  </div>
  <%
  } else {
  %>
  <p class="not-found">Categoría no encontrada.</p>
  <div class="actions">
    <a href="<%= request.getContextPath() %>/categorias">Volver a la lista</a>
  </div>
  <%
    }
  %>
</div>
</body>
</html>
