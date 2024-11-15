<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        #contenedor {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        body{
            background-image:url("imgFondo/fondo1.jpg");
            background-repeat: no-repeat;
            background-position: center center;
            background-size: cover;
        }

        a{
            border: 1px solid orange;
            background-color: orange;
            border-radius: 10px;
            padding: 15px;
        }

        a:hover{
            transition: 0.5s;
            background-color: darkslategray;
            color: orange;
            border: 1px solid darkslategray;
        }

        h1{
            margin-left: 50px;
            margin-top: 30px;
        }

    </style>
</head>

<%@ include file="/WEB-INF/jsp/formato/header.jspf" %>

<body>

    <h1>Bienvenido a Padel Nuestro, tu tienda de confianza de padel</h1>

    <div class="d-flex justify-content-around" id="contenedor" style="margin: 100px;">
        <a class="" href="<%=application.getContextPath()%>/tienda/pala/">PALAS</a>
    </div>


</body>

<%@ include file="/WEB-INF/jsp/formato/footer.jspf" %>

</html>