<%-- index.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio - Tienda Digital</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        #contenedor {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
            font-size: 20px;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<div class="d-grid gap-2" id="contenedor">
    <h1>Bienvenido a la Tienda Miusical</h1>
    <p>Hola, Ricardo este mensaje es para explicar un poco de lo que puedes encontrar en este proyecto,en principio estaba haciendo com un base de datos
    creado por mi,que me arrepiento muchisimo,porque me he enfrentado con muchos problema, como en el usuario,  que al final he decidido usar al de
    que hemos hecho, pero resulta que tampoco me funciona, asi por lo que no he podido seguir con el proyecto haciendo juego con el administrador y vendedor.
        En el que el admin puede modificar el producto y el vendedor  solo puede comprar etc.
    </p>
    <p>Explora nuestras categorias y productos para encontrar lo que necesitas.</p>
</div>
<%@ include file="/WEB-INF/jsp/fragmentos/boostrap.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>