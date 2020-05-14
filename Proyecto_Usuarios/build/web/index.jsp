

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO DE SESIÓN</title>
    </head>
    <body>
        <%
          //Valor por defecto
         String dniUsu=" ";
         // Lee la Cookie
         Cookie[] lasCookies=request.getCookies();
         //Buscar Cookie
         if(lasCookies!=null){
             
             for (Cookie cookie_temp: lasCookies){
                 if("usuario.login".equals(cookie_temp.getName()))
                 dniUsu=cookie_temp.getValue();
                 break;
             }
             
         }
        
        %>
        <h1>CONECTAR</h1>
        <form action="IniciarSesion" method="POST">
            <p>Introduzca su DNI: <input type="text" name="dni" value=<%= dniUsu %>></p>
            <p>Introduzca su password: <input type="password" name="password"></p>
            <p>
            <a href='RegistrarUsuario.jsp'>
             Registrate
            </a>
        </p>
            <input type="submit" value="Aceptar">
        </form>
    
        
    </body>
</html>
