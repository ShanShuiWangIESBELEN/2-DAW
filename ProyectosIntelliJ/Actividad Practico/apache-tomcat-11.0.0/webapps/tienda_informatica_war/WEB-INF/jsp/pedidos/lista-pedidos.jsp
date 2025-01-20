<%@ page import="org.iesbelen.model.Pedido" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Pedidos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
<div class="container mt-5">
  <h1 class="mb-4">Lista de Pedidos</h1>
  <table class="table table-bordered">
    <thead class="table-dark">
    <tr>
      <th>ID Pedido</th>
      <th>ID Usuario</th>
      <th>Fecha</th>
      <th>Total</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Pedido> pedidos = (List<org.iesbelen.model.Pedido>) request.getAttribute("listaPedidos");
      if (pedidos != null && !pedidos.isEmpty()) {
        for (org.iesbelen.model.Pedido pedido : pedidos) {
    %>
    <tr>
      <td><%= pedido.getIdPedido() %></td>
      <td><%= pedido.getIdUsuario() %></td>
      <td><%= pedido.getFecha() %></td>
      <td><%= pedido.getTotal() %></td>
      <td>
        <a href="<%= request.getContextPath() %>/pedidos/<%= pedido.getIdPedido() %>" class="btn btn-info btn-sm">Ver</a>
        <a href="<%= request.getContextPath() %>/pedidos/editar/<%= pedido.getIdPedido() %>" class="btn btn-warning btn-sm">Editar</a>
        <form action="<%= request.getContextPath() %>/pedidos/eliminar" method="post" style="display: inline;">
          <input type="hidden" name="idPedido" value="<%= pedido.getIdPedido() %>">
          <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que quieres eliminar este pedido?');">Eliminar</button>
        </form>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="5" class="text-center">No hay pedidos disponibles.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <a href="<%= request.getContextPath() %>/pedidos/crear" class="btn btn-success">Agregar Nuevo Pedido</a>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>

</html>
