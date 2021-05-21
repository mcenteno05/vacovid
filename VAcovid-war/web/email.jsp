

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/styles.css">
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
            <a href="">
                <img href="#" src="img/VAcovid_logo.png" alt="Logo VAcovid">
            </a>
        </div>
        <nav class="header__nav contenedor">
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="">Inicio</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="covid-19.jsp">Covid-19</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="plan_vacunacion.jsp">Plan de vacunación</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__text" href="#">Contacto</a>
            </li class="header__nav__item">
            <li class="header__nav__item">
                <a class="header__nav__item__button" href="registroUsuario.jsp">Regístrate</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__button" href="loginUsuario.jsp">Ingresar</a>
            </li>
        </nav>
    </header>

    <main class="main__plan__cc">
        <div class="main__plan__content">
            <h1>RECUPERAR CONTRASEÑA</h1>
        </div>
    </main>

    <div class="form_contrasena_Rec">
        <form class="form_RecCon" method="POST" action="./Email">
            <fieldset>
                <div class="titulo_form">
                    <h2>Recuperar Contraseña</h2>
                </div>
                <div class="form__contentCon">
                    <div class="form__contentCon__campo">
                        <h3>Usuario:</h3>
                        <input type="text" name="usuario" />
                    </div>
                    <div class="form__contentCon__campo">
                        <input id="button_cam" type="submit" value="Siguiente" required />
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
</body>