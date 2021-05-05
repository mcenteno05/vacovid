<%-- 
    Document   : menu_distribuidor
    Created on : 4/05/2021, 02:47:17 PM
    Author     : Cristian Duarte
--%>


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
        <h1> Hola usuario <% out.println(usuario);  %>  acceso correcto </h1>
        
        
        <form action="http://localhost:8080/VAcovid-war/asignarVacunas.jsp">
            <input type="submit" value="Ir a asignar vacunas" />
        </form>
        
        <form action="http://localhost:8080/VAcovid-war/actualizarInventarioNacional.jsp">
            <input type="submit" value="Ir a actualizar inventario nacional de vacunas" />
        </form>
               
    </body>
</html>
