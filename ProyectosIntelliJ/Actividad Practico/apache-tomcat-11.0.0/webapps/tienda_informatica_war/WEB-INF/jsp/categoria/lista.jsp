<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Categorías</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
<div class="container mt-5">
    <h1 class="mb-4">Lista de Categorías</h1>
    <table class="table table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Categoria> categorias = (List<org.iesbelen.model.Categoria>) request.getAttribute("categorias");
            if (categorias != null && !categorias.isEmpty()) {
                for (org.iesbelen.model.Categoria categoria : categorias) {
        %>
        <tr>
            <td><%= categoria.getId() %></td>
            <td><%= categoria.getNombre() %></td>
            <td><%= categoria.getDescripcion() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/categorias/<%= categoria.getId() %>" class="btn btn-info btn-sm">Ver</a>
                <a href="<%= request.getContextPath() %>/categorias/editar/<%= categoria.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                <form action="<%= request.getContextPath() %>/categorias/eliminar" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="<%= categoria.getId() %>">
                    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que quieres eliminar esta categoría?');">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4" class="text-center">No hay categorías disponibles.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/categorias/crear" class="btn btn-success">Agregar Nueva Categoría</a>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>

</html>
