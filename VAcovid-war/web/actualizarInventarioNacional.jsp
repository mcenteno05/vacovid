<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : actualizarInventarioNacional
    Created on : 4/05/2021, 02:51:57 PM
    Author     : Cristian Duarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario1");
    if (usuario.equals("")) {
        response.sendRedirect("loginUsuario.jsp");
    }
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h1>Actualizar inventario nacional de vacunas </h1>
        <form action="./ActualizarInventarioNacional" method="POST">
            <table>
                
                <sql:setDataSource var = "bd" driver = "org.apache.derby.jdbc.ClientDriver"
                                   url = "jdbc:derby://localhost:1527/VAcovid"
                                   user = "root"  password = "admin"/>
                
                <td>Seleccione una funcion </td>
                <td>
                    <select name="tipo" value="${distribuidor.funcion}">
                        <option value="0">Elija una opcion</option>
                        <option value="Agregar vacunas">Agregar vacunas</option>
                        <option value="Quitar vacunas">Quitar vacunas</option>
                    </select>   
                </td>

                <tr>
                    <td>Seleccione la vacuna</td>
                    <td>
                        <sql:query var="resultadosVacuna" dataSource="${bd}">
                            SELECT v.vacunaid, v.nombre
                            FROM VACUNA v
                            WHERE ID_INVENTARIO_NACIONAL = (
                                SELECT i.inventarioid
                                FROM INVENTARIO_NACIONAL i
                                WHERE IDENTIFICACION_DISTRIBUIDOR = <%=usuario%>)
                        </sql:query>

                        <select id="vacuna" name="vacuna">
                            <option value="0">Elija una vacuna</option>
                            <c:forEach var = "row" items = "${resultadosVacuna.rows}">
                                <option value="${row.vacunaid}">${row.nombre}</option>
                            </c:forEach>
                        </select>    
                    </td>
                </tr>
                
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="${vacuna.cantidad}" required/></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Actualizar" />
                    </td>
                </tr>
            </table> 
        </form> 
    </body>
</html>

















