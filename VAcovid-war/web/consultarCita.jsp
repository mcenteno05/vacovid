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
 <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />

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
    <sql:query var="info_cita" dataSource="${bd}">
        SELECT u.nombre, u.apellido, u.tipo_documento, u.identificacion, c.dosis, c.fecha, c.hora, m.departamento, m.municipio, c.entidad_salud
        FROM CITA c
        INNER JOIN USUARIO u ON(c.identificacion_usuario = u.identificacion)
        INNER JOIN MUNICIPIO m ON(m.codigo_dane_municipio = u.codigo_dane_municipio)
        WHERE u.identificacion = <%=usuario%> AND c.fecha > CURRENT_DATE
    </sql:query>  
    <c:forEach var = "row" items = "${info_cita.rows}">
        <h2 id="con_nombre" style="display: none">${row.nombre}</h2>
        <h2 id="con_apellido" style="display: none">${row.apellido}</h2>
        <h2 id="con_tipo_d" style="display: none">${row.tipo_documento}</h2>
        <h2 id="con_id" style="display: none">${row.identificacion}</h2>
        <h2 id="con_dosis" style="display: none">${row.dosis}</h2>
        <h2 id="con_fecha" style="display: none">${row.fecha}</h2>
        <h2 id="con_hora" style="display: none">${row.hora}</h2>
        <h2 id="con_dep" style="display: none">${row.departamento}</h2>
        <h2 id="con_mun" style="display: none">${row.municipio}</h2>
        <h2 id="con_entidad" style="display: none">${row.entidad_salud}</h2>
    </c:forEach>
    <header>
        <div class="header__logo contenedor">
            <a href="index.html">
                <img href="#" src="img/VAcovid_logo.png" alt="Logo VAcovid">
            </a>
        </div>
        <nav class="header__nav contenedor">
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Inicio</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Covid-19</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Plan de vacunación</a>
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

    <main class="main__plan__cons">
        <div class="container__usuario plan_logiado">
            <div class="usuario__opcion">
                <h2>Cambiar contraseña</h2>
            </div>
            <div class="usuario__opcion">
                <h2>Actualizar información</h2>
            </div>
            <div class="usuario__opcion">
                <h2>Logout</h2>
            </div>
        </div>
        <div class="main__plan__content">
            <h1>CONSULTAR CITA</h1>
        </div>
    </main>

        
        <form id="in_cita" class="info_cita" action="./ConsultarCita" method="POST" style="display: none">
        <div class="info_cita_div">
            <div class="info_cita_usuario">
                <h2>Apellidos:<span id="apellidos"></span></h2>
                <h2>Nombres:<span id="nombres"></span></h2>
                <h2>Tipo de documento:<span id="tipo_d"></span></h2>
                <h2>No. de documento:<span id="n_doc"></span></h2>
                <h2>Tipo de solicitud:<span id="tipo_s"></span></h2>
                <h2>Fecha:<span id="fecha"></span></h2>
                <h2>Hora:<span id="hora"></span></h2>
                <h2>Departamento:<span id="departamento"></span></h2>
                <h2>Ciudad/Municipio:<span id="ciudad"></span></h2>
                <h2>Entidad de salud:<span id="entidad"></span></h2>
                
            </div>
            <div class="info_cita_cancelar">
                <input type="submit" name="action" value ="Cancelar"/>
            </div>

        </div>

    </form>
  
    
 
       <div class="consulta_cita" style="display: none" id="sin_cita">
        <div class="consulta_cita_info">
            <h2>Estimado usuario, usted no ha solicitado</h2>
            <h2>ninguna cita para vacunarse</h2>
        </div>
        <div class="consulta_cita_info">
            <h2>Le invitamos a solicitar la cita en nuestro sistema</h2>
            <p>Recuerde que esto depende de la fase
                en la que fue asignado
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
    <script src="js/consultar_cita.js"></script>
</body>