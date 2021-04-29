<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar cita</title>
    </head>
    <body>
        <h1>Solicitar cita</h1>
        <form action="./SolicitarCita" method="POST">
            <h2>Solicitud de cita</h2>
            <table>
                <tr>
                    <td>Tipo de solicitud</td>
                    <td><select name="dosis" value="${cita.dosis}" required >
                        <option value="1">Primera dosis</option>
                        <option value="2">Segunda dosis</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${cita.fecha}" required /></td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type="time" name="hora" value="${cita.hora}" required /></td>
                </tr>
                <tr>
                    <td>Entidad de salud</td>
                    <td><input type="text" name="entidad" value="${cita.entidad}" required /></td>
                </tr>
                <tr>
                    <td>Sitio de vacunación</td>
                    <td><input type="text" name="sitio" value="${cita.sitio}" required /></td>
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