<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource var="bd2" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user="root" password="admin" />

<% String dep= request.getParameter("departamento"); 
String sentencia="SELECT codigo_dane_municipio,municipio\nFROM MUNICIPIO\nWHERE codigo_dane_departamento="+dep+"\nORDER BY municipio"; %>

<sql:query var="resultadoMunicipio" dataSource="${bd2}">
    <%=sentencia %>
</sql:query>
    <select name="municipio">
        <option value="">Elija un municipio</option>
        <c:forEach var = "row" items = "${resultadoMunicipio.rows}">
            <option value="${row.codigo_dane_municipio}">${row.municipio}</option>
        </c:forEach>
    </select>
