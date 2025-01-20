<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda Digital</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Encabezado -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Tienda Digital</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="carrito.jsp">Carrito</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Iniciar Sesión</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="registro.jsp">Registrarse</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Área de Bienvenida -->
<div class="container mt-5 text-center">
    <h1 class="mb-4">¡Bienvenido a la Tienda Digital!</h1>
    <p class="mb-5">Explora nuestra colección de productos y haz tu compra fácilmente.</p>
    <div class="d-grid gap-3 col-6 mx-auto">
        <a href="${pageContext.request.contextPath}/categorias" class="btn btn-primary btn-lg">Ver Categorías</a>
        <a href="${pageContext.request.contextPath}/carrito" class="btn btn-secondary btn-lg">Ir al Carrito</a>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-success btn-lg">Iniciar Sesión</a>
    </div>
</div>

<!-- Footer -->
<footer class="bg-light text-center text-lg-start mt-5">
    <div class="text-center p-3">
        © 2023 Tienda Digital. Todos los derechos reservados.
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
