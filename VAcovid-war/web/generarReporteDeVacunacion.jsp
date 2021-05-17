<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario1");
    if(usuario.equals("")){
        response.sendRedirect("loginUsuario.jsp");
    }
%>
<sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de vacunación</title>
    </head>
    <body>
        <form action="./GenerarReporteDeVacunacion" method="POST">
            <table>
                <h2>Datos</h2>
                <tr>
                    <td>Seleccione el paciente vacunado</td>
                    <td>
                        <sql:query var="resultadoPacientes" dataSource="${bd}">
                            SELECT c.citaid, u.nombre || ' ' || u.apellido AS nombres
                            FROM REPORTE_DE_VACUNACION r
                            INNER JOIN CITA c ON (r.id_cita=c.citaid)
                            INNER JOIN USUARIO u ON (c.identificacion_usuario = u.identificacion)
                            WHERE r.identificacion_personal =<%=usuario%> AND c.fecha = CURRENT_DATE AND r.brazo=''
                        </sql:query>
                            
                        <select id="cita" name="cita">
                        <option value="0">Elija un paciente</option>
                        <c:forEach var = "row" items = "${resultadoPacientes.rows}">
                                <option value="${row.citaid}">${row.nombres}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Seleccione la vacuna usada</td>
                    <td>
                        <sql:query var="resultadoVacunas" dataSource="${bd}">
                            SELECT v.vacunaid, v.nombre
                            FROM PERSONAL p
                            INNER JOIN SITIO_VACUNACION S ON (p.id_sitio=s.sitioid)
                            INNER JOIN INVENTARIO_DE_VACUNACION i ON (s.sitioid=i.id_sitio)
                            INNER JOIN VACUNA_RECIBIDA v ON (i.inventarioid=v.id_inventario_vacunacion)
                            WHERE p.identificacion =<%=usuario%>
                        </sql:query>
                            
                        <select id="nombreVacuna" name="nombreVacuna">
                        <option value="0">Elija una vacuna</option>
                        <c:forEach var = "row" items = "${resultadoVacunas.rows}">
                                <option value="${row.vacunaid}">${row.nombre}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Seleccione el brazo</td>
                    <td>
                        <select id="brazo" name="brazo">
                            <option value="Izquierdo">Izquierdo</option>
                            <option value="Derecho">Derecho</option>
                        </select>
                    </td>
                </tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Generar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
