<!DOCTYPE html>
<html>
	<link rel="icon" type="image/png" href="../img/logo.png" />
	<head>
		<title>NiusFIK</title>
		<link rel="stylesheet" href="../footer_header.css">
		<link rel="stylesheet" href="lista_publicaciones.css">
		<link rel="stylesheet" href="../quill/quill.snow.css" />
	</head>
	<body>
		<header>
				<div class="logo">
					<a href="javascript:history.back()"><h1><img src="../img/logo.png">NiusFIK</h1></a>
				</div>

				<div class="barra-busqueda-principal">
					<input type="search" id="miBusqueda" name="q"
				     placeholder="Buscar en el sitio...">
				    <button>Buscar</button>
				</div>
				<div class="botones-principal">
			    <INPUT type="button" onclick="location='../perfil/perfil.jsp'" name="Mi Perfil" value="Mi Perfil" />
				</div>
		</header>

		<div class="clear"></div>

		<div class="columnas">
			<div class="columna_recomendaciones">
			<!-- Lista de recomendaciones -->
				<div>
					<div class="borde">
					  <p class="titulo">Lista recomendaciones</p>
					  <hr />
					  <!-- Mostrar lista de amigos -->

					</div>

				</div>

			</div>
			<!-- Fin lista de recomendaciones -->
			<div class="columna_publicaciones">
				<!-- Creación de las publicaciones -->
				<div class="texto-publicacion" style="position: relative; margin: auto;">

					<div class="borde" style="position: relative; margin: auto;">
					  <div id="snow-container"></div>
					  <input type="button" value="Publicar" class="publbut buttonsPerfil" /> <!-- AQUÍ IMPLEMENTAR LA CREACION DE LA PUBLICACIÓN // FELIPE -->

					</div>
					<script src="../quill/quill.min.js"></script>
					<script>
					  var quill = new Quill("#snow-container", {
					    placeholder: "Introduzca el texto...",
					    theme: "snow"
					  });
					</script>

				</div>
				<!-- Fin creación de las publicaciones -->

				<!-- Lista de publicaciones -->
				<div class="lista_publicaciones" style="position: relative; margin: auto;">
					<div>
						<div class="borde">
						  <p class="titulo">Lista publicaciones</p>
						  <hr />
						  	<!-- Mostrar lista de publicaciones -->
						</div>

					</div>
				</div>
				<!-- Fin lista de recomendaciones -->

			</div>

			<!-- Lista de amigos -->
			<div class="columna_amigos">
				<div>
					<div class="borde">
					  <p class="titulo">Lista amigos</p>
					  <hr />
					  <!-- Mostrar lista de amigos -->

					</div>

				</div>

			</div>
			<!-- Fin lista de amigos -->
		</div>

		<div class="clear"></div>


		<footer>
		  	<ul style="list-style-type:disc;">
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Sobre nosotros</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Terminos y Condiciones</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Privacidad</a></li>
		  	 	<li><a href="../aviso_legal/aviso_legal.jsp">Centro de Ayuda</a></li>
		  	</ul>
		</footer>

	</body>
</html>