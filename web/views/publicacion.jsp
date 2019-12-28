<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<% ArrayList<Hashtable<String, String>> publicaciones
            = (ArrayList<Hashtable<String, String>>) request.getAttribute("publicaciones");
    ArrayList<Hashtable<String, String>> comentarios
            = (ArrayList<Hashtable<String, String>>) request.getAttribute("comentarios");%>
<html>
	<link rel="icon" type="image/png" href="../img/logo.png" />
	<head>
		<title>NiusFIK</title>
		<link rel="stylesheet" href="../css/footer_header.css">
		<link rel="stylesheet" href="../css/publicacion.css">
		<link rel="stylesheet" href="../assets/quill/quill.snow.css" />
	</head>

	<body class="fondo">
		<header>
			<div class="logo">
				<a href="javascript:history.back()"><h1><img src="../assets/img/logo.png">NiusFIK</h1></a>
			</div>
			<div class="barra-busqueda-principal">
				<input type="search" id="miBusqueda" name="q"
			     placeholder="Buscar en el sitio...">
			    <button>Buscar</button>	
			</div>
			<div class="botones-principal">
			    <INPUT type="button" onclick="location='./perfil.jsp'" name="Mi Perfil" value="Mi Perfil" />
			</div>
		</header>	
		<div class="clear"></div>
		<div>
			<center>
						<!-- Publicación -->
						<div class="publicacion-comentario" name="Publicacion" style=" height : 400px">
                                                    <% if (publicaciones.size() == 0) {
                                                        } else { 
                                                        for (Hashtable<String, String> publicacion : publicaciones) {
                                                            if (publicacion.get("id") == "1"){ // AQU� VA COMO IDENTIFICAR LA PUBLICACION EN CONCRETO
								out.print(publicacion.get("cuerpo"));
                                                                }
                                                            }
                                                        } %>
                                                </div>
						<!-- Fin Publicación -->
					<br/>
						<!-- Comentarios -->
						<div class="publicacion-comentario" name="Comentarios" style=" height: 200px">Comentarios</div>
						<br/>
						<!-- Fin Comentarios -->
						<!-- Escribir comentarios -->
						<div class="publicacion-comentario" name="EscribeComentarios" style=" height: auto">
							<div class="borde" style=" position: relative; margin-bottom: 10px; " width="708">
				  				<div id="snow-container"></div>
				  				<input type="button" value="Publicar comentario" class="publbut" /> <!-- AQUÍ IMPLEMENTAR LA PUBLICACION DEL COMENTARIO-->
							</div>
							<script src="../assets/quill/quill.min.js"></script>
							<script>
				  				var quill = new Quill("#snow-container", {
				    			placeholder: "Introduzca un comentario...",
				    			theme: "snow"
				  				});
							</script>	
							<!-- Fin Escribir comentarios -->
						</div>
					<br/>		
			</center>	
		</div>
		<footer>
		  	<ul style="list-style-type:disc;">
		  	 	<li><a href="./aviso_legal.jsp">Sobre nosotros</a></li>
		  	 	<li><a href="./aviso_legal.jsp">Terminos y Condiciones</a></li>
		  	 	<li><a href="./aviso_legal.jsp">Privacidad</a></li>
		  	 	<li><a href="./aviso_legal.jsp">Centro de Ayuda</a></li>
		  	</ul>
		</footer>

	</body>
</html>