<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="./LoginUsuario" method="POST">
            <table>
                <tr>
                    <td>Identificación</td>
                    <td><input type="text" name="identificacion" value="${usuario.identificacion}" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contra" value="${usuario.contra}" /></td>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Iniciar Sesión" />
                    </td>
                </tr>
            </table>
        </form>
        <a href="http://localhost:8080/VAcovid-war/cambioContraseña.jsp">¿Olvidó su contraseña?</a>
        <a href="http://localhost:8080/VAcovid-war/registroUsuario.jsp">¿No tiene una cuenta?</a>        
        
    </body>
</html>