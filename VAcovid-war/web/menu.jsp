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
        
        </form>
        <form action="http://localhost:8080/VAcovid-war/actualizarDatos.jsp">
            <input type="submit" value="Ir a actualizar datos" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/solicitarCita.jsp">
            <input type="submit" value="Ir a solicitar cita" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/consultarCita.jsp">
            <input type="submit" value="Ir a consular cita" />
        </form>
        <form action="http://localhost:8080/VAcovid-war/cambioContraseña.jsp">
            <input type="submit" value="Ir a cambiar contraseña" />
        </form>
        
        
    </body>
</html>
