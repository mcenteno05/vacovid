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
                <a href="cerrarSesion.jsp"><h2>Logout</h2></a>
        </div>
    </div>
    <main class="menu_representante">
        <div class="menu_representante_aside">
            <div class="menu_representante_aside_titulo">
                <h2>Menu Representante del Sitio</h2>
            </div>
            <div class="menu_representante_aside_opciones">
                <div class="menu_representante_aside_opciones">
                    <a href="#" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_buscar.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Consultar pacientes</h3>
                        </div>
                    </a>
                    <a href="asignarPersonal.jsp" class="menu_representante_aside_opcion">
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
        <div class="menu_representante_mainConsultar">
            <form action="./ConsultarPacientes" method="POST" class="menu_representante_main_consultar">
                <div class="menu_representante_main_consultar_title">
                    <h2>Consultar Pacientes</h2>
                </div>
                
                <div class="menu_representante_main_consultar_buttons">
                    <button type="submit" name="action" value="Consultar Pacientes sin vacunar por fase">Pacientes sin vacunar por fase</button>
                    <button type="submit" name="action" value="Consultar Pacientes por vacunar segunda dosis">Pacientes por aplicar segunda dosis</button>
                    <button type="submit" name="action" value="Consultar Pacientes vacunados">Pacientes vacunados</button>
                </div>

                <div class="menu_representante_main_consultar_table">
                    <table border="1" bordercolor="white"  cellspacing="0">
                        <tr height=50px>
                            <th>Fase</th>
                            <th>Apellido</th>
                            <th>Nombre</th>
                            <th>Tipo de documento</th>
                            <th>Identificación</th>
                            <th>Dosis</th>
                            <th>Fecha</th>
                            <th>Entidad</th>
                            <th>Sition de vacunación</th>
                        </tr>
                        <c:forEach var = "row" items = "${allCitas}">
                        <tr height=40px>
                            <td>${row.identificacionUsuario.fase}</td>
                            <td>${row.identificacionUsuario.apellido}</td>
                            <td>${row.identificacionUsuario.nombre}</td>
                            <td>${row.identificacionUsuario.tipoDocumento}</td>
                            <td>${row.identificacionUsuario.identificacion}</td>
                            <td>${row.dosis}</td>
                            <td>${row.fecha}</td>
                            <td>${row.entidadSalud}</td>
                            <td>${row.idSitio.nombre}</td>
                        </tr>
                        </c:forEach> 
                        
                          
                    </table>
                </div>


            </form>

        </div>
    
    </main>

    <script src="js/opciones_admin.js"></script>
</body>