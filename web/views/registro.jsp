<!DOCTYPE html>
<html>
    <head>
        <title>Registrate en NiusFIK</title>
        <meta charset="UTF-8" />
        <link rel="icon" type="image/png" href="../img/logo.png" />
        <link href="../css/WF3-registro.css" rel="stylesheet">
        <link href="../css/footer_header.css" rel="stylesheet">
    </head>
    <body class="fondo-registro">
        <script src="../js/WF3-registro.js"></script>
        <div class="contenedor">
            <header class="header">
                <div class="logo">
                    <a href="javascript:history.back()"><h1><img src="../img/logo.png">NiusFIK</h1></a>
                    <!--<p1> Conecta tu proyecto </p1>-->
                </div>
                <div class="barra-busqueda" align="right">
                    <input type="search" id="miBusqueda" name="q"
                     placeholder="Buscar en el sitio...">
                    <button>Buscar</button>
                </div>
            </header>

            <div class="clear"></div>

            <div class="caja_registro">
                <h1 align="center">Registro</h1>
                <div class="formulario">
                    <form id="infoRegistro" method="POST">
                        <fieldset>
                            <legend>Informaci�n personal:</legend>
                            <br>
                            Nombre:<br>
                            <input 
                                type="text" 
                                name="name"> 
                            <br><br>Apellidos:<br>
                            <input 
                                type="text" 
                                name="lastname"> 
                            <br><br>Fecha de nacimiento:<br>
                            <input 
                                type="date" 
                                name="birth-date"> 
                            <br><br>Correo electronico:<br>
                            <input 
                                type="email" 
                                name="correo"
                                id="correo">
                            <br><br>Tel�fono:<br>
                            <input 
                                type="text" 
                                name="phone"> 
                            <br><br>
                        </fieldset>
                        <br>
                        <fieldset>
                            <legend>Datos de perfil:</legend>
                            <br> Nombre de usuario: <br>
                            <input 
                                type="text" 
                                name="user"> 
                            <br><br> Contrase�a: <br>
                            <input 
                                type="password" 
                                name="pass"
                                id="pass"
                                pattern=".{7,}"
                                title="La contraseña debe contener al menos 7 carácteres"
                                oninput="validarPass()"
                                required>
                            <br>
                            <p id="msjErrorValidar" style="display: none; color: red"> *Minimo 7 caracteres </p>
                            <br><br>Introduzca de nuevo la contraseña:<br>
                            <input 
                                type="password" 
                                name="passVerified"
                                id="pass2"
                                oninput ="verificarPass()"> 
                            <br>
                            <p id="msjErrorVerificar" style="display: none; color: red">** Las contraseñas no coinciden</p>  
                            <br>
                        </fieldset>
                        <br>
                    <input 
                        type="submit" 
                        value="Registrarme" 
                        id="botonRegistro"  
                        onclick="accederListaPubli()" disabled>
                    <br>
                    </form>
                </div>

                <div class="link_login">
                    <p>¿Tienes ya una cuenta?</p>

                    <a href="../views/login.jsp">Inicia sesión</a>
                </div>

                <div class="clear"></div>

            </div>

            <div class="clear"></div>

        </div>
        <footer class="footer">
            <ul style="list-style-type:disc;">
                <li><a href="aviso_legal/aviso_legal.jsp">Sobre nosotros</a></li>
                <li><a href="aviso_legal/aviso_legal.jsp">Terminos y Condiciones</a></li>
                <li><a href="aviso_legal/aviso_legal.jsp">Privacidad</a></li>
                <li><a href="aviso_legal/aviso_legal.jsp">Centro de Ayuda</a></li>
            </ul>
        </footer>
    </body>
</html>