<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String animal = (String) request.getAttribute("animalRandom");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Nombres de animales</h1>
<p>Actualice la página para mostrar un nuevo animal.</p>
<h2><%=animal%></h2>
<img src="imgAnimales/<%=animal.toLowerCase()%>.svg">
</body>
</html>