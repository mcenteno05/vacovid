<%-- 
    Document   : recuperaContrasena
    Created on : 19/05/2021, 03:08:53 PM
    Author     : Cristian Duarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestor de recuperación de contraseña</h1>
        
        <div class="form_contraseña">
        <form class="form_con" action="./RecuperarContrase_a" method="POST">
            <fieldset>
                <div class="titulo_form">
                    <h2>Cambio de contraseña</h2>
                </div>
                <div class="form__contentCon">
                    <div class="form__contentCon__campo">
                        <h3>Ingrese nuevamente el usuario</h3>
                        <input type="text" name="id" required />
                    </div>
                    <div class="form__contentCon__campo">
                        <h3>Código</h3>
                        <input type="number" name="codigo" required />
                    </div>
                    <div class="form__contentCon__campo">
                        <h3>Nueva contraseña</h3>
                        <input type="password" name="contraNueva"  required />
                    </div>
                    <div class="form__contentCon__campo">
                        <h3>Confirmar nueva contraseña:</h3>
                        <input type="password" name="contraConfirmar"  required />
                    </div>
                    <div class="form__contentCon__campo">
                        <input id="button_cam" type="submit" name="action" value="Enviar" required />
                    </div>
                </div>
            </fieldset>
        </form>

    </div>
        
        
        
    </body>
</html>
