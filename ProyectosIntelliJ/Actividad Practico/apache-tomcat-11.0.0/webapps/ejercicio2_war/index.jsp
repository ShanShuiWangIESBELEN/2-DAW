<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejercicio2</title>
</head>
<body>
<%
    String[] dados = { "1.svg", "2.svg", "3.svg", "4.svg", "5.svg", "6.svg" };
    int longitud = (int)(Math.random() * 6)+2;
    int[] tirada = new int[longitud];
%>
<br/>
<h1>Ordenar dados</h1>
<br/>
<p>Actualice la página para obtener una nueva tirada</p>
<h2>Tirada de <%= longitud %> datos</h2>
<br/>
<% for ( int i = 0; i < tirada.length; i++ ) {
    tirada[i] = (int)(Math.random()*6);
%>
<img src = "imgDados/<%=dados[tirada[i]] %>" alt = "imagen"alt="Dado <%= tirada[i] + 1 %>"/>
<%
}
%>
<br/>
<h2>Dados ordenados:</h2>
<br/>
<%
    int arrayOrdenado[] = Arrays.copyOf(tirada, tirada.length);
    Arrays.sort(arrayOrdenado);
    for (int i = 0; i < arrayOrdenado.length; i++) {
%>
<img src="imgDados/<%= dados[arrayOrdenado[i]] %>" alt="Dado <%= arrayOrdenado[i] + 1 %>" />
<%
    }
%>
<br/>
</body>
</html>