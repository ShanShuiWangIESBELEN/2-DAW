<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<form action="nombre-servlet" method="get">
  <input type="text" name="nombre"/>
  <input type="submit" value="enviar"/>
</form>

</body>
</html>