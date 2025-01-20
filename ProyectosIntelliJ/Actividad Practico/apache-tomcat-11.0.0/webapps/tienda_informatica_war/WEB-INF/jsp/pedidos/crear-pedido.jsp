<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Crear Pedido</title>
</head>
<body>
<h1>Crear Pedido</h1>
<form action="${pageContext.request.contextPath}/pedidos/crear" method="post">
  <label for="idUsuario">ID Usuario:</label>
  <input type="number" id="idUsuario" name="idUsuario" required><br>
  <label for="total">Total:</label>
  <input type="number" id="total" name="total" step="0.01" required><br>
  <button type="submit">Crear</button>
</form>
<a href="${pageContext.request.contextPath}/pedidos">Volver a la lista</a>
</body>
</html>
