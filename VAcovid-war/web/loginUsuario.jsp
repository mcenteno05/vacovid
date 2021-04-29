<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="js/main.js"></script>
    <title>VAcovid</title>
</head>

<body>
    <div class="main__login">
        <div class="main__login__square">
            <div class="main__login__square__logo">
                <a href="index.html">
                    <img src="img/VAcovid_logo_login.png" alt="Logo Login">
                </a>
            </div>
            <form class="main__login__square__content" action="./LoginUsuario" id="forminicio" method="post">
                
                <div>
                    <h1>Login</h1>
                </div>
                <div class="main__login__square__content__campos">
                    <h2>Rol:</h2>
                    <select name="rol">
                        <option value="Usuario de vacunacion">Usuario de vacunación</option>
                        <option value="Representante de sitio">Representante de sitio</option>
                        <option value="Personal de vacunacion">Personal de vacunación</option>
                        <option value="Distribuidor de vacunas">Distribuidor de vacunas</option>
                    </select>
                </div>
                <div class="main__login__square__content__campos">
                    <h2>Identificación:</h2>
                    <input type="text" name="identificacion" value="${usuario.identificacion}" id="txtusuario" required>
                </div>
                <div class="main__login__square__content__campos">
                    <h2>Contraseña: </h2>
                    <input type="password" name="contra" value="${usuario.password}" id="txtpass" required>
                </div>
                <div class="main__login__square__content__button">
                    <input type="submit" value="Iniciar Sesión" id="btniniciar">
                </div>

                <div class="main__login__square__content__options">
                    <a href="#">
                        <h3>¿Olvidó la contraseña?</h3>
                    </a>
                    <a href="registroUsuario.jsp">
                        <h3>¿No tienes una cuenta?</h3>
                    </a>
                </div>
                <div class="main__login__square__content__footer">
                    <h3>Puede revisar nuestras condiciones de uso y nuestra política de privacidad da clic <a class="main__login__square__content__footer__link" href="">aqui</a></h3>
                </div>
            </form>
        </div>

        <div class="main__login__footer">
            <div class="main__login__footer__list">
                <a href="https://covid19.minsalud.gov.co/" target="_blank">
                    <img src="img/Minsalud.png" alt="">
                </a>
                <a href="https://paulavsabogal.wixsite.com/startsoft" target="_blank">
                    <img src="img/Startsoft.png" alt="">
                </a>
                <a href="https://www.gov.co/home/" target="_blank">
                    <img src="img/Colombia.png" alt="">
                </a>
                <a href="https://www.who.int/" target="_blank">
                    <img src="img/Who.png" alt="">
                </a>
            </div>
        </div>


</body>

</html>