<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario1");
    if(usuario.equals("")){
        response.sendRedirect("loginUsuario.jsp");
    }
 %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./AsignarPersonal" method="POST">
            <table>
                <h2>Datos</h2>
                        <sql:setDataSource var = "bd" driver = "org.apache.derby.jdbc.ClientDriver"
                                   url = "jdbc:derby://localhost:1527/VAcovid"
                                   user = "admin123"  password = "admin123"/>
                <tr>
                    <td>Seleccione el paciente</td>
                    <td>
                        <sql:query var="resultadoPacientes" dataSource="${bd}">
                            SELECT c.citaid, u.nombre || ' ' || u.apellido AS nombres
                            FROM CITA c
                            INNER JOIN USUARIO u ON (c.identificacion_usuario=u.identificacion)
                            WHERE id_sitio =(
                                SELECT sitioid
                                FROM SITIO_VACUNACION
                                WHERE IDENTIFICACION_REPRESENTANTE=<%=usuario%>
                            ) AND c.fecha < CURRENT_DATE
                        </sql:query>
                            
                        <select id="paciente" name="paciente">
                        <option value="0">Elija un paciente</option>
                        <c:forEach var = "row" items = "${resultadoPacientes.rows}">
                                <option value="${row.citaid}">${row.nombres}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Seleccione el personal</td>
                    <td>
                        <sql:query var="resultadoPersonal" dataSource="${bd}">
                            SELECT p.identificacion, p.nombre || ' ' || p.apellido AS nombres
                            FROM PERSONAL p
                            INNER JOIN SITIO_VACUNACION s ON (p.id_sitio=s.sitioid)
                            WHERE id_sitio =(
                                SELECT SITIOID
                                FROM SITIO_VACUNACION
                                WHERE IDENTIFICACION_REPRESENTANTE=<%=usuario%>
                            )
                        </sql:query>
                            
                        <select id="personal" name="personal">
                        <option value="0">Elija un personal</option>
                        <c:forEach var = "row" items = "${resultadoPersonal.rows}">
                                <option value="${row.identificacion}">${row.nombres}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Asignar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
