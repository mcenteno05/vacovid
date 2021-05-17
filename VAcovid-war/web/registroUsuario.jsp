<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/styles.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="static/normalize.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="img/flavicon.png">
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
    <script type="text/javascript">
        function combo_municipio(){
            $.post("comboM.jsp",$("#data").serialize(),function(data){$("#municipio").html(data);});
        }
    </script>
    <title>VAcovid</title>
</head>

<body>
    <header>
        <div class="header__logo contenedor">
            <a href="index.html">
                <img src="img/VAcovid_logo.png" alt="Logo VAcovid">
            </a>
        </div>
        <nav class="header__nav contenedor">
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="index.html">Inicio</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="covid-19.jsp">Covid-19</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="plan_vacunacion.jsp">Plan de vacunación</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="">Contacto</a>
            </li class="header__nav__item">
            <li class="header__nav__item">
                <a class="header__nav__item__button" href="">Regístrate</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__button" href="loginUsuario.jsp">Ingresar</a>
            </li>
        </nav>
    </header>
    <main class="main__register">
        <div class="main__register__content">
            <h1>Registro</h1>
        </div>
    </main>
    
    <div class="forms">
        <form action="./RegistroUsuario" method="POST" class="form" id="data">
            <fieldset>
                <div class="form__content1">
                    <legend>Información de contacto</legend>
                    <div class="form__content1__campo">
                        <h3>Nombres:</h3>
                        <input type="text" name="nombre" value="${usuario.nombre}" required />
                    </div>
                    <div class="form__content1__campo">
                        <h3>Apellidos:</h3>
                        <input type="text" name="apellido" value="${usuario.apellido}" required />
                    </div>
                    <div class="form__content1__campo">
                        <h3>Email:</h3>
                        <input type="email" name="email" value="${usuario.email}" required/>
                    </div>

                    <div class="form__content1__campo">
                        <h3>Teléfono:</h3>
                        <input type="number" name="telefono" value="${usuario.telefono}" required/>
                    </div>
                    <div class="form__content1__campo">
                        <h3>Clave:</h3>
                        <input type="password" name="contra" value="${usuario.contra}" required />
                    </div>
                    <div class="form__content1__campo">
                        <h3>Confirmar Clave:</h3>
                        <input type="password" name="contraConfirmada" value="${usuario.contraConfirmada}" required />
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <div class="form__content2">
                    <legend>Información personal</legend>
                    <div class="form__content2__campo">
                        <h3>Tipo de documento:</h3>
                        <select name="tipo" value="${usuario.tipo}">
                            <option value="Cedula de Ciudadania">Cedula de Ciudadania</option>
                            <option value="Cedula Extranjera">Cedula Extranjera</option>
                            <option value="Pasaporte">Pasaporte</option>
                            <option value="Registro Civil">Registro Civil</option>
                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                        </select>
                    </div>
                    <div class="form__content2__campo">
                        <h3>Fecha de nacimiento:</h3>
                        <%Date date= new Date();
                        int year=(date.getYear()+1900);
                        int month=date.getMonth()+1;
                        int day=date.getDate();
                        String dateString=year+"-";
                    
                        if(month>=1 && month<=9) dateString+="0"+month+"-";
                        else dateString+=month+"-";
                    
                        if(day>=1 && day<=9) dateString+="0"+day;
                        else dateString+=day;%>
                        <input type="date" max="<%=dateString%>" name="fecha de nacimiento" value="${usuario.fechaDeNacimiento}" required>
                    </div>

                    <sql:setDataSource var="bd" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/vacovid" user = "admin123"  password = "admin123" />

                    <div class="form__content2__campo">
                        <h3>Ciudad/Municipio:</h3>
                        <select id="municipio" name="municipio" value="${usuario.municipio}">
                            <option value="">Elija un municipio</option>
                        </select>
                    </div>

                    <div class="form__content2__campo">
                        <h3>No. Documento:</h3>
                        <input type="number" name="identificacion" value="${usuario.identificacion}" required>
                    </div>


                    <div class="form__content2__campo">
                        <sql:query var="resultadoDepartamento" dataSource="${bd}">
                            SELECT DISTINCT(codigo_dane_departamento), departamento FROM MUNICIPIO ORDER BY departamento
                        </sql:query>
                            
                        <h3>Departamento:</h3>
                        <select id="departamento" name="departamento" value='${usuario.departamento}' onchange="combo_municipio()">
                            <option value="">Elija un departamento</option>
                            <c:forEach var = "row" items = "${resultadoDepartamento.rows}">
                                <option value="${row.codigo_dane_departamento}">${row.departamento}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form__content2__campo">
                        <h3>Direccion:</h3>
                        <input type="text" name="direccion" value="${usuario.direccion}" required>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <div class="form__content3">
                    <legend>Información importante</legend>
                    <div class="form__content3__campo">
                        <h3>¿Presenta alguna enfermedad?</h3>
                        <input class="select" type="radio" value="Si" name="check_enfermedad" required> Si
                        <input class="select" type="radio" value="No" name="check_enfermedad" required> No

                    </div>
                    <div class="form__content3__campo">
                        <h3>¿Pertenece al personal de la salud?</h3>
                        <input class="select" type="radio" value="Si" name="check_personal" required> Si
                        <input class="select" type="radio" value="No" name="check_personal" required> No
                    </div>
                    <div class="form__content3__campo">
                        <h3>Enfermedad:</h3>
                        <select>
                            <option value="">Seleccione una opcion</option>
                            <option value"">Cáncer de pulmón</option>
                            <option value"">Fibrosis quística</option>
                            <option value"">Fibrosis pulmonar</option>
                            <option value"">Asma moderada a grave</option>
                            <option value"">Miocardiopatía</option>
                            <option value"">Hipertensión pulmonar</option>
                            <option value"">Enfermedad cardíaca congénita</option>
                            <option value"">Insuficiencia cardíaca</option>
                            <option value"">diabetes</option>
                            <option value"">Otra enfermedad pulmonar</option>
                            <option value"">Otra enfermedad cardiaca</option>
                            <option value"">Otra enfermedad</option>
                            
                        </select>
                    </div>
                    <div class="form__content3__campo">
                        <h3>EPS:</h3>
                        <select>
                            <option value="">Seleccione una opcion</option>
                            <option value"">Nueva EPS</option>
                            <option value"">Sura</option>
                            <option value"">Medimas</option>
                            <option value"">Sanitas</option>
                            <option value"">Salud Total</option>
                            <option value"">Compensar</option>
                            <option value"">Otra</option>
                        </select>
                    </div>
                    <div class="form__content3__campo">
                        <h3>Categoria de profesion:</h3>
                        <select>
                            <option value="">Seleccione una opcion</option>
                            <option value"">Servidor publico</option>
                            <option value"">Personal educativo</option>
                        </select>
                    </div>
                </div>
                
            </fieldset>
            <fieldset class="">
                <input class="form__submit" type="submit" name="action" value="Registrarse">
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
</body>

</html>