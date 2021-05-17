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
            <a href="menu_representante.jsp">
                <img href="#" src="img/VAcovid_logo.png" alt="Logo VAcovid">
            </a>
        </div>
        <nav class="header__nav contenedor">
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#"></a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#"></a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#"></a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#"></a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text profile_boton" href="#">
                    <div class="profile">
                        <sql:query var="inicial" dataSource="${bd}">
                           SELECT substr(u.nombre,1,1)AS nombre FROM REPRESENTANTE u WHERE identificacion =<%=usuario%>
                        </sql:query>  
                        <c:forEach var = "row" items = "${inicial.rows}">
                            <h3>${row.nombre}</h3>
                        </c:forEach>
                    </div>
                </a>
            </li>
        </nav>
    </header>

    <div class="container__usuario_ad astra_logiado">
        <div class="usuario__opcion">
                <h2>Logout</h2>
        </div>
    </div>
    <main class="menu_representante">
        <div class="menu_representante_aside">
            <div class="menu_representante_aside_titulo">
                <h2>Menu Representante del Sitio</h2>
            </div>
            <div class="menu_representante_aside_opciones">
                <div class="menu_representante_aside_opciones">
                    <a href="consultarPacientes.jsp" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_buscar.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Consultar pacientes</h3>
                        </div>
                    </a>
                    <a href="#" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_personal.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Asignar personal</h3>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="menu_representante_mainAsignar">
            <div class="menu_representante_main_asignar">
                <div class="menu_representante_main_asignar_form">
                    <form action="./AsignarPersonal" method="POST">
                        <div class="menu_representante_main_asignar_form_title">
                            <h2>Datos</h2>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <sql:query var="resultadoPacientes" dataSource="${bd}">
                            SELECT c.citaid, u.nombre || ' ' || u.apellido AS nombres
                            FROM CITA c
                            INNER JOIN USUARIO u ON (c.identificacion_usuario=u.identificacion)
                            WHERE c.fecha >= CURRENT_DATE
                            AND id_sitio =(
                                SELECT sitioid
                                FROM SITIO_VACUNACION
                                WHERE IDENTIFICACION_REPRESENTANTE=<%=usuario%>
                            ) 
                            </sql:query>
                            <h3>Seleccione el paciente:</h3>
                            <select id="paciente" name="paciente" >
                                <option value="0">Elija un paciente</option>
                                <c:forEach var = "row" items = "${resultadoPacientes.rows}">
                                    <option value="${row.citaid}">${row.nombres}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <sql:query var="resultadoPersonal" dataSource="${bd}">
                            SELECT p.identificacion, p.nombre || ' ' || p.apellido AS nombres
                            FROM PERSONAL p
                            INNER JOIN SITIO_VACUNACION s ON (p.id_sitio=s.sitioid)
                            WHERE id_sitio =(
                                SELECT SITIOID
                                FROM SITIO_VACUNACION
                                WHERE IDENTIFICACION_REPRESENTANTE=<%=usuario%>
                            )
                            </sql:query>
                            <h3>Seleccione el personal:</h3>
                            <select id="personal" name="personal">
                                <option value="0">Elija el personal</option>
                                <c:forEach var = "row" items = "${resultadoPersonal.rows}">
                                    <option value="${row.identificacion}">${row.nombres}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <input type="submit" name="action" value="Asignar">
                        </div>
                    </form>
                </div>
                <div class="menu_representante_main_asignar_image">
                    <img src="./img/menu_representante_asignar.svg" alt="">
                </div>
            </div>
        </div>

        
    
    </main>

    <script src="js/opciones_admin.js"></script>
</body>