<!DOCTYPE html>
<html>
	<head>
		<title>Inicia sesión en NiusFIK</title>
		<link rel="icon" type="image/png" href="../img/logo.png" />
		<link rel="stylesheet" href="login.css">
		<link rel="stylesheet" href="../footer_header.css">
	</head>
	<body class="fondo-registro">
		<script src="login.js"></script>
		<header>
				<div class="logo">
					<a href="javascript:history.back()"><h1><img src="../img/logo.png">NiusFIK</h1></a>
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
			<h1 align="center"> Iniciar sesión </h1>
			<div class="formulario">
				<form id="infoLogin">
					<br> Nombre de usuario: <br>
					<input 
						type="text" 
						name="user"> 
					<br><br> Contraseña: <br>
					<input 
						type="password" 
						name="pass">
					<br><br>

				</form>
				<input 
					type="submit" 
					value="Iniciar sesión" 
					id="envio-inicio"
					onclick="accederListaPubli()">
			</div>

			<!--<div class="vertical_line"></div>-->
			
			<div class="link_register">
				<p>¿No tienes cuenta?</p>

				<a href="..registro/registro.jsp">Regístrate</a>
			</div>

			<div class="clear"></div>
		</div>

		<div class="clear"></div>

		<footer>
		  	<ul style="list-style-type:disc;">
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Sobre nosotros</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Términos y Condiciones</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Privacidad</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Centro de Ayuda</a></li>
		  	</ul>
		</footer>
	</body>

</html>