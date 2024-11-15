<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String[] nombres = {
          "Ballena",
          "Hipocampo",
          "Camello",
          "Cebra",
          "Elefante",
          "Hipopótamo",
          "Jirafa",
          "León",
          "Leopardo",
          "Medusa",
          "Mono",
          "Oso",
          "Oso blanco",
          "Pájaro",
          "Pingüino",
          "Rinoceronte",
          "Serpiente",
          "Tigre",
          "Tortuga",
          "Tortuga marina"
  };
  String[] imgs = {
          "ballena.svg",
          "caballito-mar.svg",
          "camello.svg",
          "cebra.svg",
          "elefante.svg",
          "hipopotamo.svg",
          "jirafa.svg",
          "leon.svg",
          "leopardo.svg",
          "medusa.svg",
          "mono.svg",
          "oso.svg",
          "oso-blanco.svg",
          "pajaro.svg",
          "pinguino.svg",
          "rinoceronte.svg",
          "serpiente.svg",
          "tigre.svg",
          "tortuga.svg",
          "tortuga-marina.svg"
  };
  int numeroRandom = (int) (Math.random() * 20);
%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Ejercicio de la Relacion 1" %></h1>
<br/>
<h2><%= nombres[numeroRandom] %></h2>
<img src="imagen/<%= imgs[numeroRandom] %>" alt="<%= nombres[numeroRandom] %>" />
<p><%= nombres[numeroRandom] %></p>
</body>
</html>
