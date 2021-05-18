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
    
    String faseActual = "1";
   
 %>
 <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />
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

    <main class="main__plan__sc">
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
            <a href="">
                <div class="usuario__opcion">
                    <h2>Logout</h2>
                </div>
            </a>
        </div>
        <div class="main__plan__content">
            <h1>SOLICITAR CITA</h1>
        </div>
    </main>
    
    <sql:query var="fases" dataSource="${bd}">
    SELECT u.fase FROM USUARIO u WHERE identificacion =<%=usuario%>
    </sql:query>  
    <c:forEach var = "row" items = "${fases.rows}">
        <h3 id="faseActual" style="display: none"><%=faseActual%></h3>
        <h3 id="faseUsuario" style="display: none">${row.fase}</h3>
   </c:forEach>
    
   

       <div class="form_solicitar" id="formularioSolicitar">
        
        <form class="form_sol" action="./SolicitarCita" method="POST">
            <fieldset>
                <div class="titulo_form">
                    <h2>Solicitar Cita</h2>
                </div>
                <div class="form__contentSol">
                    <div class="form__contentSol__campo">
                        <h3>Tipo de solicitud:</h3>
                        <select name="dosis" value="${cita.dosis}" required>
                            <option value="1">Primera dosis</option>
                            <option value="2">Segunda dosis</option>
                        </select>
                    </div>
                    <div class="form__contentSol__campo">
                        <h3>Fecha:</h3>
                        <%Date date= new Date();
                        int year=(date.getYear()+1900);
                        int month=date.getMonth()+1;
                        int day=date.getDate();
                        String dateString=year+"-";
                    
                        if(month>=1 && month<=9) dateString+="0"+month+"-";
                        else dateString+=month+"-";
                    
                        if(day>=1 && day<=9) dateString+="0"+day;
                        else dateString+=day;%>
                        <input type="date" name="fecha" value="${cita.fecha}" min="<%=dateString%>" required />
                    </div>
                    <div class="form__contentSol__campo">
                        <h3>Hora:</h3>
                        <select name="hora" value="${cita.hora}" required>
                            <option value="0">Seleccione una hora</option>
                            <option value="6:00">6:00</option>
                            <option value="6:30">6:30</option>
                            <option value="7:00">7:00</option>
                            <option value="7:30">7:30</option>
                            <option value="8:00">8:00</option>
                            <option value="8:30">8:30</option>
                            <option value="9:00">9:00</option>
                            <option value="9:30">9:30</option>
                            <option value="10:00">10:00</option>
                            <option value="10:30">10:30</option>
                            <option value="11:00">11:00</option>
                            <option value="11:30">11:30</option>
                            <option value="12:00">12:00</option>
                            <option value="12:30">12:30</option>
                            <option value="14:00">14:00</option>
                            <option value="14:30">14:30</option>
                            <option value="15:00">15:00</option>
                            <option value="15:30">15:30</option>
                            <option value="16:00">16:00</option>
                            <option value="16:30">16:30</option>
                            <option value="17:00">17:00</option>
                            <option value="17:30">17:30</option>
                        </select>
                    </div>
                    <div class="form__contentSol__campo">
                        <h3>Entidad de salud:</h3>
                        <input type="text" name="entidad" value="${cita.entidad}" required />
                    </div>
                    <div class="form__contentSol__campo">
                        <h3>Sitio de vacunación:</h3>
                            <sql:query var="sitios" dataSource="${bd}">
                            SELECT s.sitioid,s.nombre 
                            FROM SITIO_VACUNACION s 
                            WHERE codigo_dane_municipio =
                            (SELECT u.codigo_dane_municipio
                            FROM USUARIO u
                            WHERE identificacion = <%=usuario%>
                            )
                            </sql:query>  
                        <select type="text" name="sitio" value="${cita.sitio}" required>
                            <c:forEach var = "row" items = "${sitios.rows}">
                                <option value="${row.sitioid}">${row.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form__contentSol__campo">
                        <input id="button_sol" type="submit" name="action" value="Solicitar" required />
                    </div>
                </div>
            </fieldset>
        </form>

    </div> 
    
    <div class="fase" id="aviso">
        <div class="fase_info">
            <h2>Estimado usuario, en este momento nos encontramos</h2>
            <h2> en la etapa <span><%=faseActual%></span> de vacunacion</h2>
        </div>
        <div class="fase_info">
            <h2>Su etapa correspondiente es la <span id="span_etapa"></span></h2>
            <p>Para mas informacion consulte el plan de vacunacion
                emitido por el gobierno nacional
            </p>
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
    <script src="js/opciones_usuario.js"></script>
    <script src="js/solicitar_cita.js"></script>
</body>