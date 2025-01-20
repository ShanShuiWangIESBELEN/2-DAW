<%-- nuevaCategoria.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Agregar Nueva Categoría</title>
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

    form {
      max-width: 500px;
      margin: 20px auto;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #ddd;
      border-radius: 8px;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
    }

    input[type="text"], textarea {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button {
      background-color: #007bff;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    .actions {
      text-align: center;
      margin-top: 20px;
    }

    .actions a {
      text-decoration: none;
      color: #007bff;
      margin-left: 10px;
    }

    .actions a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<h1>Agregar Nueva Categoría</h1>
<form action="<%= request.getContextPath() %>/categorias" method="post">
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required>

  <label for="descripcion">Descripción:</label>
  <textarea id="descripcion" name="descripcion" required></textarea>

  <button type="submit">Agregar</button>
</form>
<div class="actions">
  <a href="<%= request.getContextPath() %>/categorias">Volver a la lista</a>
</div>
</body>
</html>
