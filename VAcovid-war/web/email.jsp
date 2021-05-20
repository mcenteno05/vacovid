<%-- 
    Document   : email
    Created on : 16/05/2021, 09:36:49 AM
    Author     : Cristian Duarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email </title>
    </head>
    <body>
        <h1>Gestor de recuperación de contraseña</h1>
        <form method="POST" action="./Email">
            <table>
                <tr>
                    <td>
                        <h3>Ingrese su usuario: </h3>
                        <input type="text" name="usuario" size="20">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input type="submit" value="Siguiente">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
