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
            <a href="menu_distribuidor.jsp">
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
                           SELECT substr(u.nombre,1,1)AS nombre FROM DISTRIBUIDOR u WHERE identificacion =<%=usuario%>
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
                <a href="cerrarSesion.jsp"><h2>Logout</h2></a>
        </div>
    </div>
    <main class="menu_representante">
        <div class="menu_representante_aside">
            <div class="menu_representante_aside_titulo">
                <h2>Menu Distribuidor de vacunas</h2>
            </div>
            <div class="menu_representante_aside_opciones">
                <div class="menu_representante_aside_opciones">
                   <a href="#" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_reporte.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Asignar vacunas</h3>
                        </div>
                    </a>
                    <a href="actualizarInventarioNacional.jsp" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_actualizar.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Actualizar inventario nacional</h3>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="menu_representante_mainAsignar">
            <div class="menu_representante_main_asignar">
                <div class="menu_representante_main_asignar_form">
                    <form action="./AsignarVacunas" method="POST">
                        <div class="menu_representante_main_asignar_form_title">
                            <h2>Registro inventario de vacunas</h2>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <sql:query var="sitiosVacunacion" dataSource="${bd}">
                            SELECT s.sitioid, s.nombre
                            FROM SITIO_VACUNACION s
                            </sql:query>
                            <h3>Sitio de vacunacion:</h3>
                            <select id="sitios" name="sitios de vacunacion">
                                <option value="0">Elija un sitio de vacunacion</option>
                                <c:forEach var = "row" items = "${sitiosVacunacion.rows}">
                                    <option value="${row.sitioid}">${row.nombre}</option>
                                </c:forEach>    
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <h3>Seleccione la vacuna:</h3>
                            <sql:query var="resultadosVacuna" dataSource="${bd}">
                            SELECT v.vacunaid, v.nombre
                            FROM VACUNA v
                            WHERE ID_INVENTARIO_NACIONAL = (
                                SELECT i.inventarioid
                                FROM INVENTARIO_NACIONAL i
                                WHERE IDENTIFICACION_DISTRIBUIDOR = <%=usuario%>)
                            </sql:query>
                            <select id="vacuna" name="vacuna">
                                <option value="0">Elija una vacuna</option>
                                <c:forEach var = "row" items = "${resultadosVacuna.rows}">
                                <option value="${row.vacunaid}">${row.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <h3>Cantidad:</h3>
                            <input type="number" name="cantidad">
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <input type="submit" name="action" value="Asignar vacunas">
                        </div>
                    </form>
                </div>
                <div class="menu_representante_main_asignar_image">
                    <img src="./img/menu_distribuidor_actualizar.svg" alt="">
                </div>
            </div>
        </div>

        
    
    </main>

    <script src="js/opciones_admin.js"></script>
</body>