<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registrarse</title>
</head>
<body>
<h1>Registro</h1>
<form action="registro" method="post">
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required>
  <br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>
  <br>
  <label for="password">Contraseña:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <button type="submit">Registrarse</button>
</form>
</body>
</html>
