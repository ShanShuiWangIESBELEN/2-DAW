
<!DOCTYPE html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <style>
        #contenedor {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        a{
            text-decoration: none;
        }

    </style>
</head>


<body>

<div  id="contenedor" style="margin: 100px;">
    <a  href="<%=application.getContextPath()%>/sitio/departamento/">DEPARTAMENTO</a>&emsp;
    <a  href="<%=application.getContextPath()%>/sitio/empleado/">EMPLEADO</a>
</div>

</body>


</html>