<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario</title>
</head>
<body>
    <h1>FORMULARIO</h1>
    <p><label><b>Nombre: </b><br></label><input type="text"></p>
    <p><label><b>Apellidos: </b><br></label><input type="text"></p>
    <p><label><b>Edad: </b><br></label><input type="text"></p>
    <p><label><b>Peso: </b><br></label><input type="text"></p>

    <p>
        <label><b>Sexo: </b></label><input type="radio" id="hombre" name="sexo">
        <label for="hombre">Hombre </label> <input type="radio" id="mujer" name="sexo">
        <label for="mujer"> Mujer </label>
    </p>

    <p>
        <label><b>Estado Civil: </b></label>
        <input type="radio" id="soltero" name="estadoCivil"> <label for="soltero">Soltero </label>
        <input type="radio" id="casado" name="estadoCivil"> <label for="casado"> Casado </label>
        <input type="radio" id="otro" name="estadoCivil"> <label for="otro"> Otro </label>
    </p>

    <p>
        <label><b>Aficiones: </b></label>
        <input type="checkbox" >
    </p>
</body>
</html>