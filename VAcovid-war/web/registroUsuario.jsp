<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuario</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="./RegistroUsuario" method="POST">
            <h2>Información de contacto</h2>
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombre" value="${usuario.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellido" value="${usuario.apellido}" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${usuario.email}" /></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${usuario.telefono}" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contra" value="${usuario.contra}" /></td>
                </tr>
                <tr>
                    <td>Confirmar contraseña</td>
                    <td><input type="password" name="contraConfirmada" value="${usuario.contraConfirmada}" /></td>
                </tr>

                <h2>Información personal</h2>
                <tr>
                    <td>Tipo de documento</td>
                <select name="tipo" value="${usuario.tipo}">
                    <option>Cédula de ciudadania</option>
                    <option>Tarjeta de identidad</option>
                    <option>Cédula de extrangería</option>
                </select>
                </tr>
                <tr>
                    <td>Número de documento</td>
                    <td><input type="text" name="identificacion" value="${usuario.identificacion}" /></td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento</td>
                    <td><input type="text" name="fecha de nacimiento" value="${usuario.email}" /></td>
                </tr>
                <tr>
                    <td>Departamento</td>
                    <td><input type="text" name="departamento" value="${usuario.departamento}" /></td>
                </tr>
                <tr>
                    <td>Ciudad/Municipio</td>
                    <td><input type="text" name="ciudad" value="${usuario.ciudad}" /></td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td><input type="text" name="direccion" value="${usuario.direccion}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Registrarse" />
                    </td>
                </tr>
            </table>
        </form>


    </body>
</html>