<%@ page import="com.example.ejercicio3.entity.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: EMI
  Date: 29/10/2023
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listUsuarios");

%>

<html>
<head>
    <title>Mostrar usuarios</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div id="contenedor">
    <form action="${pageContext.request.contextPath}/index.jsp">
    <input class="boton-enviar" type="submit" value="Volver"/>
    </form>
    <h1>Lista de Usuarios</h1>

    <% for (Usuario usuario : listaUsuarios) {

    %>

    <h2>Usuario </h2>
    <p><b>Nombre:</b> <%=usuario.getNombre()%></p>
    <p><b>Apellidos:</b> <%=usuario.getApellidos()%></p>
    <p><b>Edad:</b> <%=usuario.getEdad()%></p>
    <p><b>Peso:</b> <%=usuario.getPeso()%></p>
    <p><b>Sexo:</b> <%=usuario.getSexo()%></p>
    <p><b>Estado Civil:</b> <%=usuario.getEstadoCivil()%></p>
    <p><b>Aficiones:</b></p>
    <%
        List<String> aficiones = usuario.getAficiones();

            for (String aficion : aficiones) {%>

    <p><%=aficion%></p>
    <%}%>

    <p>-------------------------------------------------</p>


    <% } %>
</div>
</body>
</html>
