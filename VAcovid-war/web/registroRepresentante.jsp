<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
        <form action="./RegistroRepresentante" method="POST">
            <table>
                <td><h2>Información de contacto</h2></td>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombre" value="${representante.nombre}" required /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellido" value="${representante.apellido}" required /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${representante.email}" required/></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${representante.telefono}" required/></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contra" value="${representante.contra}" required /></td>
                </tr>
                <tr>
                    <td>Confirmar contraseña</td>
                    <td><input type="password" name="contraConfirmada" value="${representante.contraConfirmada}" required /></td>
                </tr>

                <td><h2>Información personal</h2></td>
                <tr>
                    <td>Número de documento</td>
                    <td><input type="text" name="identificacion" value="${representante.identificacion}" required /></td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento</td>
                    <td><input type="date" name="fecha de nacimiento" value="${representante.fecha}" required/></td>
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