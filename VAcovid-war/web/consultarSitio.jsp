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
        <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user="root" password="admin" />
        <h1>Sitio de vacunación asignado</h1><br>
        <sql:query var="sitioAsignado" dataSource="${bd}">
            SELECT s.nombre, s.direccion
            FROM PERSONAL p
            INNER JOIN SITIO_VACUNACION s ON (p.id_sitio=s.sitioid)
            WHERE p.identificacion=<%=usuario%>
        </sql:query>
            <c:forEach var = "row" items = "${sitioAsignado.rows}">
                            <h3>${row.nombre}</h3>
                            <h3>${row.direccion}</h3>
            </c:forEach>
    </body>
</html>
