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
    if(usuario.equals(null)){
        response.sendRedirect("loginUsuario.jsp");
    }  
 %>

<sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123"  />
<!DOCTYPE html>
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
                <a class="header__nav__item__text" href="#">Inicio</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="covid-19_logiado.jsp">Covid-19</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="plan_vacunacion_logiado.jsp">Plan de vacunación</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Contacto</a>
            </li>
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
    <main class="main__principal">
        <div class="container__usuario">
            <div class="usuario__opcion">
                <a href="cambioContraseña.jsp"> <h2>Cambiar contraseña</h2></a>
            </div>
            <div class="usuario__opcion">
                <a href="actualizarDatos.jsp"><h2>Actualizar información</h2></a>
            </div>
            <div class="usuario__opcion">
                <a href="cerrarSesion.jsp"><h2>Logout</h2></a>
            </div>
        </div>
        <div class="main__square">


            <div class="main__square__content contenedor">
                <h1>Nos preocupamos por ti</h1>
                <p>El plan de vacunación ya empezó, por eso te pedimos que te quedes en casa, te avisaremos cuando ya sea tu turno para vacunarte contra el COVID-19 </p>
                
            </div>

        </div>
    </main>
    <div class="menu">
        <div class="menu__option">
            <a href="solicitarCita.jsp">
                <img class="menu__option__image" src="img/calendario.png" alt="imagen calendario">
                <h2>Solicitar Cita de Vacunación</h2>
            </a>
        </div>
        <div class="menu__option">
            <a href="consultarCita.jsp">
                <img class="menu__option__image" src="img/contenido.png" alt="imagen contenido">
                <h2>Consultar Estado de la Cita</h2>
            </a>
        </div>
        <div class="menu__option">
            <a href="reportar_sintomas.jsp">
                <img class="menu__option__image" src="img/corazon.png" alt="imagen corazon">
                <h2>Reportar Efectos Secundarios</h2>
            </a>
        </div>
    </div>
    <div class="vacunas">
        <div class="vacunas__square">
            <div class="vacunas__square__content contenedor">
                <h1>Conoce las diferentes vacunas</h1>
                <p>En Colombia ya se están distribuyendo diferentes tipos de vacunas contra el COVID-19, descubre mas sobre ellas </p>
                <a href="vacunas_logiado.jsp"><button>Conocer más</button></a>
            </div>

        </div>
    </div>
    <div class="ls_vacunas">
        <div class="ls_vacunas__text">
            <h2>Vacunas</h2>
        </div>
        <div class="ls_vacunas__images">
            <a href="astrazeneca_logiado.jsp">
                <img src="img/astrazeneca.png" alt="Logo Astrazeneca">
            </a>
            <a href="jannsen_logiado.jsp">
                <img src="img/jannsen.png" alt="Logo Jannsen">
            </a>
            <a href="moderna_logiado.jsp">
                <img src="img/moderna.png" alt="Logo Moderna">
            </a>
            <a href="pfizer_logiado.jsp">
                <img src="img/pfizer.png" alt="Logo Pfizer">
            </a>
            <a href="sinovac_logiado.jsp">
                <img src="img/sinovac.png" alt="Logo sinovac">
            </a>
        </div>
    </div>
    <footer>
        <div class="footer__logo contenedor">
            <img src="img/VAcovid_logo.png" alt="Logo VAcovid">
        </div>
        <div class="footer__text">
            <h4>Copyright @ 2021 VAcovid</h4>
        </div>
    </footer>



    <script src="js/opciones_usuario"></script>
</body>

</html>
