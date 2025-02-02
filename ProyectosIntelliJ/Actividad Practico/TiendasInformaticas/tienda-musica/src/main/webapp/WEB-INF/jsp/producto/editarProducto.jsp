<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Editar Producto</h1>
    <%
        org.iesbelen.model.Producto producto = (org.iesbelen.model.Producto) request.getAttribute("producto");
        if (producto != null) {
    %>
    <form action="<%= request.getContextPath() %>/productos/editar/<%= producto.getId() %>" method="post">
        <input type="hidden" name="id" value="<%= producto.getId() %>">

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" value="<%= producto.getNombre() %>" required>
        </div>

        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción:</label>
            <textarea id="descripcion" name="descripcion" class="form-control" required><%= producto.getDescripcion() %></textarea>
        </div>

        <div class="mb-3">
            <label for="precio" class="form-label">Precio:</label>
            <input type="number" step="0.01" id="precio" name="precio" class="form-control" value="<%= producto.getPrecio() %>" required>
        </div>

        <div class="mb-3">
            <label for="stock" class="form-label">Stock:</label>
            <input type="number" id="stock" name="stock" class="form-control" value="<%= producto.getStock() %>" required>
        </div>

        <div class="mb-3">
            <label for="id_categoria" class="form-label">Categoría:</label>
            <select name="id_categoria" id="id_categoria" class="form-select" required>
                <c:forEach var="categoria" items="${categorias}">
                    <option value="${categoria.id}" ${producto.idCategoria == categoria.id ? 'selected' : ''}>
                            ${categoria.nombre}
                    </option>
                </c:forEach>
            </select>
        </div>


        <button type="submit" class="btn btn-primary">Actualizar Producto</button>
    </form>
        <a href="<%= request.getContextPath() %>/productos" class="btn btn-secondary">Volver a la lista</a>
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
