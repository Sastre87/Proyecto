

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO DE SESIÓN</title>
    </head>
    <body>
        <h1>CONECTAR</h1>
        <form action="IniciarSesion" method="POST">
            <p>Introduzca su DNI: <input type="text" name="dni"></p>
            <p>Introduzca su password: <input type="password" name="password"></p>
            <input type="submit" value="modificar">
        </form>
    </body>
</html>
