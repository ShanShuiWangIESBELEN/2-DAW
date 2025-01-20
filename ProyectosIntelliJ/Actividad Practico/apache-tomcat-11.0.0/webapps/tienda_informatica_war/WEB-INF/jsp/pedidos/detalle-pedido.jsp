<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Detalle del Pedido</title>
</head>
<body>
<h1>Detalle del Pedido</h1>
<p><strong>ID Pedido:</strong> ${pedido.idPedido}</p>
<p><strong>ID Usuario:</strong> ${pedido.idUsuario}</p>
<p><strong>Fecha:</strong> ${pedido.fecha}</p>
<p><strong>Total:</strong> ${pedido.total}</p>
<a href="${pageContext.request.contextPath}/pedidos">Volver a la lista</a>
</body>
</html>
