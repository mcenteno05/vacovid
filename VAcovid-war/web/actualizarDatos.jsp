<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Datos</title>
    </head>
    <body>
        <h1>Actualizar Datos</h1>
        <form action="./ActualizarDatos" method="POST">
            <table>
                <h2>Datos</h2>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${usuario.telefono}" /></td>
                </tr>
                <tr>
                    <td>Departamento</td>
                    <td><input type="text" name="departamento" value="${usuario.departamento}" /></td>
                </tr>
                <tr>
                    <td>Ciudad</td>
                    <td><input type="text" name="ciudad" value="${usuario.ciudad}" /></td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td><input type="text" name="direccion" value="${usuario.direccion}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Actualizar" />
                    </td>
                </tr>
            </table>
        </form>

        
    </body>
</html>