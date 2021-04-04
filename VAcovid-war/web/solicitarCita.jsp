<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar cita</title>
    </head>
    <body>
        <h1>Socilicitar cita</h1>
        <form action="./SolicitarCita" method="POST">
            <h2>Solicitud de cita</h2>
            <table>
                <tr>
                    <td>Tipo de solicitud</td>
                    <td><input type="text" name="tipo" value="${cita.tipo}" /></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="${cita.fecha}" /></td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type="text" name="hora" value="${cita.hora}" /></td>
                </tr>
                <tr>
                    <td>Departamento</td>
                    <td><input type="text" name="departamento" value="${cita.departamento}" /></td>
                </tr>
                <tr>
                    <td>Ciudad</td>
                    <td><input type="text" name="ciudad" value="${cita.ciudad}" /></td>
                </tr>
                <tr>
                    <td>Entidad de salud</td>
                    <td><input type="text" name="entidad" value="${usuario.entidad}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Solicitar" />
                    </td>
                </tr>
            </table>
        </form>

        
    </body>
</html>