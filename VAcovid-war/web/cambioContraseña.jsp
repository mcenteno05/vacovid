<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body>
        <h1>Cambiar Contraseña</h1>
        <form action="./CambioContraseña" method="POST">
            <table>
                <tr>
                    <td>Contraseña actual</td>
                    <td><input type="password" name="contraseñaActual" value="${usuario.contraseñaActual}" /></td>
                </tr>
                <tr>
                    <td>Nueva contraseña</td>
                    <td><input type="password" name="contraseñaNueva" value="${usuario.contraseñaNueva}" /></td>
                <tr>
                <tr>
                    <td>Confirmar contraseña</td>
                    <td><input type="password" name="contraseñaConfirmar" value="${usuario.contraseñaConfirmar}" /></td>
                <tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${usuario.email}" /></td>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Enviar" />
                    </td>
                </tr>
            </table>
        </form>

        
    </body>
</html>