<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Datos</title>
    </head>
    <body>
        <h1>Actualizar Datos</h1>
        <form action="./ActualizarDatos" method="POST">
            <table>
                <h2>Datos</h2>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${usuario.telefono}" required /></td>
                </tr>
                
                <sql:setDataSource var = "bd" driver = "org.apache.derby.jdbc.ClientDriver"
                                           url = "jdbc:derby://localhost:1527/VAcovid"
                                           user = "admin123"  password = "admin123"/>
                <tr>
                    <td>Departamento</td>
                    <td>
                        <sql:query var="resultadoDepartamento" dataSource="${bd}">
                            SELECT DISTINCT(codigo_dane_departamento), departamento
                            FROM MUNICIPIO
                            ORDER BY departamento
                        </sql:query>
                            
                        <select id="departamento" name="departamento" value='${usuario.departamento}'>
                            <option value="0">Elija un departamento</option>
                        <c:forEach var = "row" items = "${resultadoDepartamento.rows}">
                                <option value="${row.codigo_dane_departamento}">${row.departamento}</option>
                        </c:forEach>
                        </select>
                            
                    </td>
                </tr>
                <tr>
                    <td>Ciudad/Municipio</td>
                    <td>
                        <sql:query var="resultadoMunicipio" dataSource="${bd}">
                            SELECT codigo_dane_municipio,municipio
                            FROM MUNICIPIO
                            ORDER BY municipio
                        </sql:query>
                            
                        <select name="municipio" value="${usuario.municipio}">
                        <c:forEach var = "row" items = "${resultadoMunicipio.rows}">
                                <option value="${row.codigo_dane_municipio}">${row.municipio}</option>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td><input type="text" name="direccion" value="${usuario.direccion}" required /></td>
                </tr>
                <tr>
                    <td>Correo electronico</td>
                    <td><input type="text" name="correo" value="${usuario.correo}" required /></td>
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