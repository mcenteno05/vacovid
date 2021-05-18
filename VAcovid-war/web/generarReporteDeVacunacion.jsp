<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario1");
    if(usuario.equals(null)){
        response.sendRedirect("loginUsuario.jsp");
    }
%>
<sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />
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
            <a href="menu_personal.jsp">
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
                           SELECT substr(u.nombre,1,1)AS nombre
                           FROM PERSONAL u 
                           WHERE identificacion =<%=usuario%>
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
                <h2>Menu Personal de vacunación</h2>
            </div>
            <div class="menu_representante_aside_opciones">
                <div class="menu_representante_aside_opciones">
                    <a href="#" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_reporte.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Generar Reporte de vacunación</h3>
                        </div>
                    </a>
                    <a href="consultarSitio.jsp" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_buscar.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Consultar Sitio</h3>
                        </div>
                    </a>
                    <a href="consultarAgenda.jsp" class="menu_representante_aside_opcion">
                        <div class="menu_representante_aside_opcion_icon">
                            <img src="img/menu_icon_buscar.svg" alt="">
                        </div>
                        <div class="menu_representante_aside_opcion_text">
                            <h3>Consultar agenda diaria</h3>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="menu_representante_mainAsignar">
            <div class="menu_representante_main_asignar">
                <div class="menu_representante_main_asignar_form">
                    <form action="./GenerarReporteDeVacunacion" method="POST">
                        <div class="menu_representante_main_asignar_form_title">
                            <h2>Datos</h2>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <sql:query var="resultadoPacientes" dataSource="${bd}">
                                SELECT c.citaid, u.nombre || ' ' || u.apellido AS nombres
                                FROM REPORTE_DE_VACUNACION r
                                INNER JOIN CITA c ON (r.id_cita=c.citaid)
                                INNER JOIN USUARIO u ON (c.identificacion_usuario = u.identificacion)
                                WHERE r.identificacion_personal =<%=usuario%> AND c.fecha = CURRENT_DATE AND r.brazo=''
                            </sql:query>
                            <h3>Seleccione el paciente vacunado:</h3>
                            <select id="cita" name="cita">
                                <option value="0">Elija un paciente</option>
                                <c:forEach var = "row" items = "${resultadoPacientes.rows}">
                                    <option value="${row.citaid}">${row.nombres}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <sql:query var="resultadoVacunas" dataSource="${bd}">
                                SELECT v.vacunaid, v.nombre
                                FROM PERSONAL p
                                INNER JOIN SITIO_VACUNACION S ON (p.id_sitio=s.sitioid)
                                INNER JOIN INVENTARIO_DE_VACUNACION i ON (s.sitioid=i.id_sitio)
                                INNER JOIN VACUNA_RECIBIDA v ON (i.inventarioid=v.id_inventario_vacunacion)
                                WHERE p.identificacion =<%=usuario%>
                            </sql:query>
                            <h3>Seleccione la vacuna usada:</h3>
                            <select id="nombreVacuna" name="nombreVacuna">
                                <option value="0">Elija una vacuna</option>
                                <c:forEach var = "row" items = "${resultadoVacunas.rows}">
                                    <option value="${row.vacunaid}">${row.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <h3>Seleccione el brazo:</h3>
                            <select id="brazo" name="brazo">
                                <option value="Izquierdo">Izquierdo</option>
                                <option value="Derecho">Derecho</option>
                            </select>
                        </div>
                        <div class="menu_representante_main_asignar_form_campo">
                            <input type="submit" name="action" value="Generar">
                        </div>
                    </form>
                </div>
                <div class="menu_representante_main_asignar_image">
                    <img src="./img/menu_personal_reporte.svg" alt="">
                </div>
            </div>
        </div>

        
    
    </main>

    <script src="js/opciones_admin.js"></script>
</body>