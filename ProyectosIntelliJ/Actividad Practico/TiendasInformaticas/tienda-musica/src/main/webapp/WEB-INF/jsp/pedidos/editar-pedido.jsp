<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Editar Pedido</title>
</head>
<body>
<h1>Editar Pedido</h1>
<form action="${pageContext.request.contextPath}/pedidos/editar" method="post">
  <input type="hidden" name="idPedido" value="${pedido.idPedido}">
  <label for="idUsuario">ID Usuario:</label>
  <input type="number" id="idUsuario" name="idUsuario" value="${pedido.idUsuario}" required><br>
  <label for="total">Total:</label>
  <input type="number" id="total" name="total" step="0.01" value="${pedido.total}" required><br>
  <button type="submit">Guardar Cambios</button>
</form>
<a href="${pageContext.request.contextPath}/pedidos">Volver a la lista</a>
</body>
</html>
