<!DOCTYPE html>
<html>
	<link rel="icon" type="image/png" href="assets/img/logo.png" />
	<head>
		<title>NiusFIK</title>
		<link rel="stylesheet" href="css/footer_header.css">
		<link rel="stylesheet" href="css/inicio.css">
	</head>

	<body>
		<header>
			<div class="logo">
				<a href="javascript:history.back()"><h1><img src="assets/img/logo.png">NiusFIK</h1></a>
			</div>
			<div class="barra-busqueda-principal">
				<input type="search" id="miBusqueda" name="q"
			     placeholder="Buscar en el sitio...">
			    <button>Buscar</button>	
			</div>
			<div class="botones-principal">
			    <INPUT type="button" onclick="location='login.jsp'" name="Login" value="Login" />
				<INPUT type="button" onclick="location='registro.jsp'" name="Sign Up" value="Sign Up"/>
			</div>
		</header>	

		<div class="contenedor">
			<img class="img" src="assets/img/portada.png" >
  			<div class="centrado">
  				<h1 class="title" style="background-color: orange">Unete a nuestra comunidad de investigadores</h1> 
  			</div>
		</div>

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