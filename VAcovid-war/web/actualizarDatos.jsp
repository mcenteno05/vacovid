
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

<sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user="admin123" password="admin123" />

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

    <main class="main__plan__ai">
        <div class="container__usuario plan_logiado">
            <div class="usuario__opcion">
                <a href="cambioContraseña.jsp"> <h2>Cambiar contraseña</h2></a>
            </div>
            <div class="usuario__opcion">
                <a href=""><h2>Actualizar información</h2></a>
            </div>
            <div class="usuario__opcion">
                <h2>Logout</h2>
            </div>
        </div>
        <div class="main__plan__content">
            <h1>ACTUALIZAR INFORMACIÓN</h1>
        </div>
    </main>

    <div class="form_actualizar">
        <form class="form_act" action="./ActualizarDatos" method="POST" id="data">
            <fieldset>
                <div class="titulo_form">
                    <h2>Actualizar Datos</h2>
                </div>
                <div class="form__contentAct">
                    <div class="form__contentAct__campo">
                        <h3>Telefono:</h3>
                        <input type="text" name="telefono" value="${usuario.telefono}" required />
                    </div>
                    <div class="form__contentAct__campo">
                        <h3>Correo:</h3>
                        <input type="text" name="correo" value="${usuario.correo}" required />
                    </div>
                    <div class="form__contentAct__campo">
                        <h3>Departamento:</h3>
                        <sql:query var="resultadoDepartamento" dataSource="${bd}">
                            SELECT DISTINCT(codigo_dane_departamento), departamento
                            FROM MUNICIPIO
                            ORDER BY departamento
                        </sql:query>
                        <select id="departamento" name="departamento" value="${usuario.departamento}" onchange="combo_municipio()" required>
                            <option value="0">Elija un departamento</option>
                            <c:forEach var = "row" items = "${resultadoDepartamento.rows}">
                                <option value="${row.codigo_dane_departamento}">${row.departamento}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form__contentAct__campo">
                        <h3>Ciudad/Municipio:</h3>
                        <select name="municipio" value="${usuario.municipio}" id="municipio" required>
                            <option value="">Elija un municipio</option>
                        </select>
                    </div>
                    <div class="form__contentAct__campo">
                        <h3>Direccion:</h3>
                        <input type="text" name="direccion" value="${usuario.direccion}" required />
                    </div>
                    <div class="form__contentAct__campo">
                        <input id="button_act" type="submit" name="action" value="Actualizar"  required />
                    </div>
                </div>
            </fieldset>
        </form>

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
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script type="text/javascript">
        function combo_municipio(){
            $.post("comboM.jsp",$("#data").serialize(),function(data){$("#municipio").html(data);});
        }
        </script>
</body>