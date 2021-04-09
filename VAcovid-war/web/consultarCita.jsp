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
        <form action="./ConsultarCita" method="POST">
            <table>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Consultar" />
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellido" value="${usuario.apellido}" readonly onmousedown="return false;" /></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="apellido" value="${usuario.nombre}" readonly onmousedown="return false;" /></td>
                </tr>
                <tr>
                    <td>Tipo de documento</td>
                    <td><input type="text" name="tipo" value="${usuario.tipoDocumento}" readonly onmousedown="return false;" /></td>
                </tr>
                <tr>
                    <td>No. de documento</td>
                    <td><input type="text" name="identificacion_usuario" value="${usuario.identificacion}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Tipo de solicitud</td>
                    <td><input type="text" name="fase" value="${cita.fase}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="${cita.fecha}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type="text" name="hora" value="${cita.hora}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Departamento</td>
                    <td><input type="text" name="departamento" value="${municipio.departamento}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Ciudad/Municipio</td>
                    <td><input type="text" name="ciudad" value="${municipio.municipio}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td>Entidad de salud</td>
                    <td><input type="text" name="entidad" value="${cita.entidadSalud}" readonly onmousedown="return false;"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Cancelar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>