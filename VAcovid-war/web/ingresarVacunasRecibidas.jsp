<%-- 
    Document   : ingresarVacunasRecibidas
    Created on : 10/04/2021, 05:48:35 PM
    Author     : JEFRY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro inventario de vacunas</h1>
        <form action="./IngresarVacunasRecibidas" method="POST">
            <table>
                <tr>
                    <td>ID Inventario</td>
                    <td><input type="text" name="idinventario" value="${inventario_de_vacunacion.inventarioid}" required /></td>
                </tr>
                <tr>
                    <td>ID Vacuna</td>
                    <td><input type="text" name="idvacuna" value="${vacuna.vacunaid}" required /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${vacuna.nombre}" required /></td>
                </tr>
                <tr>
                    <td>Fecha de vencimiento</td>
                    <td><input type="date" name="fecha" value="${vacuna.fecha}" required/></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="${inventario_de_vacunacion.cantidad}" required/></td>
                </tr>
                <tr>
                    <td>Lote</td>
                    <td><input type="text" name="lote" value="${inventario_de_vacunacion.lote}" required /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Registrar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
