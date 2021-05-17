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
            <a href="#">
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
                <h2>Logout</h2>
        </div>
    </div>
    <main class="menu_representante">
        <div class="menu_representante_aside">
            <div class="menu_representante_aside_titulo">
                <h2>Menu Distribuidor de vacunas</h2>
            </div>
            <div class="menu_representante_aside_opciones">
                <div class="menu_representante_aside_opciones">
                    <a href="asignarVacunas.jsp" class="menu_representante_aside_opcion">
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
        <div class="menu_representante_main">
            <div class="menu_distribuidor_main_imagen">

            </div>

        </div>
    
    </main>

    <script src="js/opciones_admin.js"></script>
</body>