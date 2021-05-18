<%-- 
    Document   : cerrarSesion
    Created on : 17/05/2021, 07:23:51 PM
    Author     : JEFRY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario1");
    if(usuario.equals(null)){
        response.sendRedirect("loginUsuario.jsp");
    }
    
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
    </head>
    <body>
        <script type="text/javascript">
                <% objsession.invalidate(); %>
                alert("Se ha cerrado sesión correctamente")
                window.location.href ="http://localhost:8080/VAcovid-war/index.html"
        </script>
    </body>
</html>
