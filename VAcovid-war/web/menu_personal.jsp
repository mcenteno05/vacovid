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
        
        
        <form action="http://localhost:8080/VAcovid-war/generarReporteDeVacunacion.jsp">
            <input type="submit" value="Ir a generar reporte de vacunación" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/consultarSitio.jsp">
            <input type="submit" value="Ir a consultar sitio" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/consultarAgenda.jsp">
            <input type="submit" value="Ir a consultar agenda diaria" />
        </form>
               
    </body>
</html>
