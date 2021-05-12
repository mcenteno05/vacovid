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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />
        <sql:query var="pacientesDiarios" dataSource="${bd}">
            SELECT u.identificacion, u.nombre, u.apellido, c.hora, c.dosis
            FROM REPORTE_DE_VACUNACION r
            INNER JOIN CITA c ON (r.id_cita=c.citaid)
            INNER JOIN USUARIO u ON (c.identificacion_usuario=u.identificacion)
            WHERE r.identificacion_personal=<%=usuario%> AND c.fecha = CURRENT_DATE
            ORDER BY c.hora
        </sql:query>
            <c:forEach var = "row" items = "${sitioAsignado.rows}">
                            <h3>${row.nombre}</h3>
                            <h3>${row.direccion}</h3>
            </c:forEach>
                            
        <h1>Consultar agenda diaria</h1>
                <table border="1">
                    <th>Identificación</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Hora</th>
                    <th>Dosis</th>
                    <c:forEach var = "row" items = "${pacientesDiarios.rows}">
                        <tr>
                            <td>${row.identificacion}</td>
                            <td>${row.nombre}</td>
                            <td>${row.apellido}</td>
                            <td>${row.hora}</td>
                            <td>${row.dosis}</td>
                        </tr>
                    </c:forEach> 
                </table>
    </body>
</html>

