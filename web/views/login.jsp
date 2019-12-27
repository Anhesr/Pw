<!DOCTYPE html>
<html>
	<head>
            <title>Inicia sesion en NiusFIK</title>
            <link rel="icon" type="image/png" href="assets/img/logo.png" />
            <link rel="stylesheet" href="css/login.css">
            <link rel="stylesheet" href="css/footer_header.css">
	</head>
	<body class="fondo-registro">
            <script src="login.js"></script>
            <header>
                <div class="logo">
                    <a href="javascript:history.back()"><h1><img src="assets/img/logo.png">NiusFIK</h1></a>
                    <!--<p1> Conecta tu proyecto </p1>-->
                </div>
                <div class="barra-busqueda">
                    <input type="search" id="miBusqueda" name="q"
                    placeholder="Buscar en el sitio...">
                    <button>Buscar</button>
                </div>
            </header>
		
            <div class="clear"></div>

            <div class="caja_inicio">
                <h1 align="center"> Iniciar sesion </h1>
                <div class="formulario">
                    <form id="infoLogin" method="POST">
                        <br> E-mail: <br>
                        <input 
                            type="text" 
                            name="email">
                        <br><br> ContraseÃ±a: <br>
                        <input 
                            type="password" 
                            name="password">
                        <br><br>
                        <input 
                            type="submit" 
                            value="Iniciar sesion" 
                            id="envio-inicio"/>
                    </form>
                </div>

                <div class="link_register">
                    <p>¿No tienes cuenta?</p>

                    <a href="..registro/registro.jsp">Regi­strate</a>
                </div>

                <div class="clear"></div>
            </div>

            <div class="clear"></div>

            <footer>
                <ul style="list-style-type:disc;">
                    <li><a href="views/aviso_legal.jsp">Sobre nosotros</a></li>
                    <li><a href="views/aviso_legal.jsp">Terminos y Condiciones</a></li>
                    <li><a href="views/aviso_legal.jsp">Privacidad</a></li>
                    <li><a href="views/aviso_legal.jsp">Centro de Ayuda</a></li>
                </ul>
            </footer>
	</body>
</html>