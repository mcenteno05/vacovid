<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuario</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="./RegistroUsuario" method="POST">
            <table>
                <td><h2>Información de contacto</h2></td>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombre" value="${usuario.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellido" value="${usuario.apellido}" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${usuario.email}" /></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${usuario.telefono}" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contra" value="${usuario.contra}" /></td>
                </tr>
                <tr>
                    <td>Confirmar contraseña</td>
                    <td><input type="password" name="contraConfirmada" value="${usuario.contraConfirmada}" /></td>
                </tr>

                <td><h2>Información personal</h2></td>
                <tr>
                    <td>Tipo de documento</td>
                    <td>
                    <select name="tipo" value="${usuario.tipo}">
                        <option>Cédula de ciudadania</option>
                        <option>Tarjeta de identidad</option>
                        <option>Cédula de extranjería</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td>Número de documento</td>
                    <td><input type="text" name="identificacion" value="${usuario.identificacion}" /></td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento</td>
                    <td><input type="date" name="fecha de nacimiento" value="${usuario.email}" /></td>
                </tr>
                
                <sql:setDataSource var = "bd" driver = "org.apache.derby.jdbc.ClientDriver"
                                           url = "jdbc:derby://localhost:1527/vacovid"
                                           user = "root"  password = "admin"/>
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
                    <td><input type="text" name="direccion" value="${usuario.direccion}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Registrarse" />
                    </td>
                </tr>
            </table>
        </form>


    </body>
</html>