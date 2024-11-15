<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div id="contenedor">
    <h1>Formulario</h1>
    <br/>
    <form action="formulario" method="POST">
        <label style="margin: 1em">Nombre:
            <input type="text" name="nombre" placeholder="Escriba su nombre"/>
        </label>
        <label style="margin: 1em">Apellidos:
            <input type="text" name="apellidos" placeholder="Escriba sus apellidos"/>
        </label>
        <label style="margin: 1em">Edad:
            <select name="edad" style="margin: 1em">
                <option>Seleccione una opción</option>
                <option value="Menor de Edad">Menor de 18 años</option>
                <option value="Mayor de Edad">Igual o mayor de 18 años</option>
            </select>
        </label>
        <label style="margin: 1em">Peso:
            <input type="number" name="peso"/>
        </label>
        <label style="margin: 1em">Sexo:
            <input type="radio" name="sexo" value="mujer" checked/> Mujer
            <input type="radio" name="sexo" value="hombre"/> Hombre
        </label>
        <label style="margin: 1em">Estado Civil:
            <input type="radio" name="estadoCivil" value="Soltero" checked/> Soltero
            <input type="radio" name="estadoCivil" value="Casado"/> Casado
            <input type="radio" name="estadoCivil" value="Otro"/> Otro
        </label>
        <label style="margin: 1em">Aficiones:
            <div id="aficiones">
                <input type="checkbox" name="aficiones" value="cine"/> Cine
                <input type="checkbox" name="aficiones" value="literatura"/> Literatura
                <input type="checkbox" name="aficiones" value="tebeos"/> Tebeos
                <input type="checkbox" name="aficiones" value="deporte"/> Deporte
                <input type="checkbox" name="aficiones" value="musica"/> Música
                <input type="checkbox" name="aficiones" value="television"/> Televisión
            </div>
        </label>

        <input class="boton-enviar" type="submit" value="Enviar"/>
        <input class="boton-borrar" type="reset" value="Borrar"/>
    </form>
    <form action="formulario" method="GET">
        <input class="boton-mostrar" type="submit" value="Mostrar usuarios"/>
    </form>
</div>
</body>
</html>