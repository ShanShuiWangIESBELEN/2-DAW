<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login de Usuario</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Login de Usuario</h1>
<form action="${pageContext.request.contextPath}/tienda/usuarios/login" method="post">
    <div>
        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required>
    </div>
    <div>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <input type="submit" value="Iniciar Sesión">
    </div>
    <div class="error">
        <c:if test="${not empty error}">
            <p>${error}</p>
        </c:if>
    </div>
</form>
</body>
</html>
