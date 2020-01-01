<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%
    Hashtable<String, String> publicacion
            = (Hashtable<String, String>) request.getAttribute("publicacion");

    ArrayList<Hashtable<String, String>> comentarios
            = (ArrayList<Hashtable<String, String>>) request.getAttribute("comentarios");
    String id = request.getParameter("idP");
%>
<html>
	<link rel="icon" type="image/png" href="assets/img/logo.png" />
	<head>
		<title>NiusFIK</title>
		<link rel="stylesheet" href="css/footer_header.css">
		<link rel="stylesheet" href="css/publicacion.css">
		<link rel="stylesheet" href="assets/quill/quill.snow.css" />
	</head>
	<body class="fondo">
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
			    <INPUT type="button" onclick="location='perfil'" name="Mi Perfil" value="Mi Perfil" />
			</div>
		</header>	
		<div class="clear"></div>
		<div>
			<center>
						<!-- Publicación -->
						<div class="publicacion-comentario" name="Publicacion" style=" height : 400px">
                                                    <% 
                                                        /*if(!publicacion.isEmpty()){
                                                            out.print(publicacion.get("nombre"));
                                                            out.print(publicacion.get("cuerpo"));
                                                        }*/
                                                    %>
                                                </div>
						<!-- Fin Publicación -->
					<br/>
						<!-- Comentarios -->
						<div class="publicacion-comentario" name="Comentarios" style=" height: 200px">Comentarios<br/>
                                                      <%
                                                        /*  if (comentarios.isEmpty()) {
                                                        } else { 
                                                            for (Hashtable<String, String> comentario : comentarios) {
                                                                if(!comentario.isEmpty()){*/
                                                            
                                                      %>
                                                      <div class="comentario"> 
                                                          <p><strong>Usuario: <% //comentario.get("autor")%> . Fecha: <% //comentario.get("fecha")%></strong></p>
                                                          <p><% //comentario.get("cuerpo")%></p>
                                                          <br/>
                                                      </div>
                                                      
                                                      <%
                                                         /*       }
                                                            }
                                                        }*/
                                                      %>
                                                </div>
						<br/>
						<!-- Fin Comentarios -->
						<!-- Escribir comentarios -->
						<div class="publicacion-comentario" name="EscribeComentarios" style=" height: auto">
                                                        <%@ page import="es.uco.pw.niusFIK.servlets.publicacion" %>
                                                        <form action="publicacion?idP=<%=id%>" method="post">
                                                        <br/>
                                                        <textarea id="Coment2" name="Coment2" rows="3" cols="80" placeholder="Escribe tu comentario..."></textarea>
                                                        <input id="Coment" name="Coment" required="" type="text">
                                                        <div id="snow-container"></div>
                                                        <input type="submit" value="Publicar comentario" /> 
                                                        </form>
                                                        <script src="assets/quill/quill.min.js"></script>
                                                        <script>
                                                            var quill = new Quill("#snow-container", {
                                                            placeholder: "Introduzca el texto...",
                                                            theme: "snow"
                                                            }).on('text-change', function(){
                                                                $('#Coment').val($('#snow-container').html());
                                                            });
                                                        </script>
							<!-- Fin Escribir comentarios -->
						</div>
					<br/>		
			</center>	
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