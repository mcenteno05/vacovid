<%-- 
    Document   : menu
    Created on : 9/04/2021, 03:45:10 PM
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
        
        
        <form action="http://localhost:8080/VAcovid-war/ingresarVacunasRecibidas.jsp">
            <input type="submit" value="Ir a ingresar vacunas" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/consultarPacientes.jsp">
            <input type="submit" value="Ir a consultar pacientes" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/asignarPersonal.jsp">
            <input type="submit" value="Ir a asignar personal de vacunación" />
        </form>

        
    </body>
</html>
