<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%
    ArrayList<Hashtable<String, String>> comentariosT;
    comentariosT = (ArrayList<Hashtable<String, String>>) request.getAttribute("comentariosP");
    
    ArrayList<Hashtable<String, String>> publicacionT;
    publicacionT = (ArrayList<Hashtable<String, String>>) request.getAttribute("publicacion");
 
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
				<a href="inicio"><h1><img src="assets/img/logo.png">NiusFIK</h1></a>
			</div>
			<div class="barra-busqueda-principal">
				<input type="search" id="miBusqueda" name="q"
			     placeholder="Buscar en el sitio...">
			    <button>Buscar</button>	
			</div>
			<div class="botones-principal">
			    <input type="button" onclick="location = 'perfil?id=<%=request.getSession().getAttribute("uID")%>'" name="Mi Perfil" value="Mi Perfil" />
                            <input type="button" onclick="location='logout'" name="cerrar_sesion" value="Cerrar Sesión" />
                        </div>
		</header>	
		<div class="clear"></div>
		<div>
			<center>
						<!-- PublicaciÃ³n -->
						<div class="publicacion-comentario" name="Publicacion" style=" height : 400px">
                                                    <% if (publicacionT.isEmpty()) { %>
                                                          <p>ERROR 404. La publicacion que buscas no existe</p>
                                                          </div>
                                                       <%
                                                        } else { 
                                                            for (Hashtable<String, String> publicacionAux : publicacionT) {
                                                                if(!publicacionAux.isEmpty()){
                                                    %>
                                                            <p><%=publicacionAux.get("nombre")%></p>
                                                            <p><%=publicacionAux.get("cuerpo")%></p>
                                                            <%
                                                                if(Integer.parseInt(publicacionAux.get("autor_id")) == Integer.parseInt((String)request.getSession().getAttribute("uID"))){
                                                            %>
                                                            <form method="post">
                                                            <input name="deletPublic" type="submit" value="Eliminar publicacion">
                                                            </form>
                                                    <%              }
                                                                }
                                                            }
                                                            
                                                      %>
                                                </div>
						<!-- Fin PublicaciÃ³n -->
					<br/>
						<!-- Comentarios -->
						<div class="publicacion-comentario" name="Comentarios" style=" height: 200px">Comentarios<br/>
                                                      <%
                                                          if (comentariosT.isEmpty()) { %>
                                                          <p>No hay comentarios aún. Sé el primero en comentar</p>
                                                       <% } else { 
                                                            for (Hashtable<String, String> comentarioAux : comentariosT) {
                                                                if(!comentarioAux.isEmpty()){
                                                            
                                                      %>
                                                      <div class="comentario"> 
                                                          <p><strong>Usuario: <%=comentarioAux.get("nombre")%> <%=comentarioAux.get("apellidos")%> . Fecha: <%=comentarioAux.get("fecha_publicacion")%></strong></p>
                                                          <p><%=comentarioAux.get("cuerpo")%></p>
                                                          <% if(Integer.parseInt((String)request.getSession().getAttribute("uID")) == Integer.parseInt(comentarioAux.get("idusuario"))){ %>
                                                          <form method="post">
                                                          <input name="delCom" type="submit" value="Eliminar comentario">
                                                          <textarea style="display:none" name="idComentario"><%=comentarioAux.get("id")%></textarea>
                                                          </form>
                                                          <% } %>
                                                          <br/>
                                                      </div>
                                                      
                                                      <%            
                                                                }
                                                            }
                                                        }
                                                      %>
                                                </div>
						<br/>
						<!-- Fin Comentarios -->
						<!-- Escribir comentarios -->
						<div class="publicacion-comentario" name="EscribeComentarios" style=" height: auto">
                                                        <script src="assets/quill/quill.min.js"></script>
                                                        <form name="myForm" id="myForm" method="post">
                                                        <div class="row form-group">
                                                       
                                                       <input name="Coment2" type="hidden" rows="3" cols="80">
                                                       <div id="snow-container"></div>
                                                       </div>
                                                        <input name="botonComentar" type="submit" value="Publicar comentario"> 
                                                        </form>
                                                        <script>
                                                        var quill = new Quill('#snow-container', {
                                                        modules: {
                                                            toolbar: [
                                                              ['bold', 'italic'],
                                                              ['link'],
                                                              [{ list: 'ordered' }, { list: 'bullet' }]
                                                            ]
                                                          },
                                                          placeholder: 'Escribe tu comentario...',
                                                          theme: 'snow'
                                                        });

                                                        var form = document.querySelector('form[name=myForm]');
                                                        form.onsubmit = function() {
                                                          // Populate hidden form on submit
                                                          var about = document.querySelector('input[name=Coment2]');
                                                          about.value = JSON.stringify(quill.root.innerHTML);
                                                        };
                                                        </script>
							<!-- Fin Escribir comentarios -->
						</div>
					<br/>
                                        <% } %>
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