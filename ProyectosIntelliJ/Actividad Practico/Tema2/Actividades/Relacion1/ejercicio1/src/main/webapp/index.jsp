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
  <title>Ejercicio 1</title>
</head>
<body>
<h1>Nombre de Animales</h1>
<br/>
<p>Actualiza la página para obtener un nuevo animal</p>
<h2><%=nombres[numeroRandom] %></h2>
<img src="imgAnimales/<%= imgs[numeroRandom] %>"/>
</body>
</html>