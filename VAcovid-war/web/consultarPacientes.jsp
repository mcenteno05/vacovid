<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : consultarPacientes
    Created on : 18/04/2021, 03:33:59 PM
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
        <form action="./ConsultarPacientes" method="POST">
            
            <h1>Consultar pacientes</h1>
                <table border="1">
                    <th>Apellido</th>
                    <th>Nombre</th>
                    <th>Tipo de documento</th>
                    <th>Identificación</th>
                    <th>Dosis</th>
                    <th>Fecha</th>
                    <th>Entidad</th>
                    <th>Nombre Sitio</th>
                    <c:forEach var = "row" items = "${allCitas}">
                        <tr>
                            <td>${row.identificacionUsuario.apellido}</td>
                            <td>${row.identificacionUsuario.nombre}</td>
                            <td>${row.identificacionUsuario.tipoDocumento}</td>
                            <td>${row.identificacionUsuario.identificacion}</td>
                            <td>${row.fase}</td>
                            <td>${row.fecha}</td>
                            <td>${row.entidadSalud}</td>
                            <td>${row.idSitio.nombre}</td>
                        </tr>
                    </c:forEach> 
                </table>
                    <input type="submit" name="action" value="Consultar Pacientes sin vacunar" />
                    <input type="submit" name="action" value="Consultar Pacientes vacunados" />
                
        </form>
    </body>
</html>
