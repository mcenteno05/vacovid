<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
 <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123"  />


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/style2.css">
    <link rel="stylesheet" href="static/normalize.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="img/flavicon.png">
    <title>VAcovid</title>
</head>

<body>
    <header>
        <div class="header__logo contenedor">
            <a href="menu.jsp">
                <img href="#" src="img/VAcovid_logo.png" alt="Logo VAcovid">
            </a>
        </div>
        <nav class="header__nav contenedor">
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="menu.jsp">Inicio</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="covid-19_logiado.jsp">Covid-19</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="plan_vacunacion_logiado.jsp">Plan de vacunación</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Contacto</a>
            </li class="header__nav__item">
            <li class="header__nav__item">
                <a class="header__nav__item__text profile_boton" href="#">
                    <div class="profile">
                        <sql:query var="inicial" dataSource="${bd}">
                           SELECT substr(u.nombre,1,1)AS nombre FROM USUARIO u WHERE identificacion =<%=usuario%>
                        </sql:query>  
                        <c:forEach var = "row" items = "${inicial.rows}">
                            <h3>${row.nombre}</h3>
                        </c:forEach>
                    </div>
                </a>
            </li>
        </nav>
    </header>

    <main class="main__plan__rs">
        <div class="container__usuario plan_logiado">
            <a href="cambioContraseña.jsp">
                <div class="usuario__opcion">
                    <h2>Cambiar contraseña</h2>
                </div>
            </a>
            <a href="actualizarDatos.jsp">
                <div class="usuario__opcion">
                    <h2>Actualizar información</h2>
                </div>
            </a>
                <div class="usuario__opcion">
                    <a href="cerrarSesion.jsp"><h2>Logout</h2></a>
                </div>
        </div>
        <div class="main__plan__content">
            <h1>REPORTAR SINTOMAS</h1>
        </div>
    </main>
 
    <div class="form_reportar">
        
        <form class="form_rep">
            <fieldset>
                <div class="titulo_form">
                    <h2>Reportar efectos secundarios</h2>
                </div>
                <div class="form__contentRep">
                    <div class="form__contentRep__campo">
                        <h3>Fecha de detección:</h3>
                        <input type="date" name="apellido" value="" required />
                    </div>
                    <div class="form__contentRep__area">
                        <h3>Describa los sintomas</h3>
                        <div class="form__contentRep__text_area">
                            <textarea name="" id=""></textarea>
                        </div>
                    </div>
                    
                    <div class="form__contentRep__campo">
                        <input id="button_rep" type="submit" name="apellido" value="Enviar" required />
                    </div>
                </div>
            </fieldset>
        </form>

    </div>
    
    <!-- 
    <div class="sintomas">
        <div class="sintomas_info">
            <h2>Estimado usuario, no puede reportar efectos secundarios</h2>
            <h2> ya que aun no ha recibido ninguna dosis de alguna vacuna</h2>
        </div>
        <div class="sintomas_info">
            <h2>Le invitamos a que consulte su fase de vacunación</h2>
            
        </div>
    </div>
    -->
    <footer>
        <div class="footer__logo contenedor">
            <img src="img/VAcovid_logo.png" alt="Logo VAcovid">
        </div>
        <div class="footer__text">
            <h4>Copyright @ 2021 VAcovid</h4>
        </div>
    </footer>
    <script src="js/opciones_usuario.js"></script>
</body>