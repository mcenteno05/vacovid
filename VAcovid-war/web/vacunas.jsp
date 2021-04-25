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
            <a href="index.html">
                <img href="#" src="img/VAcovid_logo.png" alt="Logo VAcovid">
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
                <a class="header__nav__item__button" href="registroUsuario.jsp">Regístrate</a>
            </li>
            <li class="header__nav__item">
                <a class="header__nav__item__button" href="loginUsuario.jsp">Ingresar</a>
            </li>
        </nav>
    </header>

    <main class="main__vacunas">
        <div class="main__vacunas__content">
            <h1>VACUNAS COVID-19</h1>
        </div>
    </main>

    <div class="info_vacunas">
    </div>
    <div class="ls_vacunas">
        <div class="ls_vacunas__text">
            <h2>Vacunas</h2>
        </div>
        <div class="ls_vacunas__images">
            <a href="astrazeneca.jsp">
                <img src="img/astrazeneca.png" alt="Logo Astrazeneca">
            </a>
            <a href="jannsen.jsp">
                <img src="img/jannsen.png" alt="Logo Jannsen">
            </a>
            <a href="moderna.jsp">
                <img src="img/moderna.png" alt="Logo Moderna">
            </a>
            <a href="pfizer.jsp">
                <img src="img/pfizer.png" alt="Logo Pfizer">
            </a>
            <a href="sinovac.jsp">
                <img src="img/sinovac.png" alt="Logo sinovac">
            </a>
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

</body>