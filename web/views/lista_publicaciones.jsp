<%@page import="java.util.HashMap"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    ArrayList<Hashtable<String, String>> amigosList;
    amigosList = (ArrayList<Hashtable<String, String>>) request.getAttribute("listaAmigos");
    ArrayList<HashMap<String, String>> recomendaciones =
        (ArrayList<HashMap<String, String>>) request.getAttribute("recomendaciones");
    ArrayList<Hashtable<String, String>> allPublications =
        (ArrayList<Hashtable<String, String>>) request.getAttribute("allPublication");
%>
<html>
    <link rel="icon" type="image/png" href="assets/img/logo.png" />
    <head>
        <title>NiusFIK</title>
        <link rel="stylesheet" href="css/publicacion.css">
        <link rel="stylesheet" href="css/footer_header.css">
        <link rel="stylesheet" href="css/lista_publicaciones.css">
        <link rel="stylesheet" href="assets/quill/quill.snow.css" />
    </head>
    <body>
        <script src="js/publicacion.js"></script>
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
                <INPUT type="button" onclick="location = 'perfil?id=<%=request.getSession().getAttribute("uID")%>'" name="Mi Perfil" value="Mi Perfil" />
                <input type="button" 
                       onclick="location='logout'"
                       name="cerrar_sesion" 
                       value="Cerrar Sesión" />
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
                        <% for(HashMap<String, String> publicacion: recomendaciones) { %>
                        <div class="titPublicacion" id="titPublicacion<%= publicacion.get("id") %>" onclick="location='publicacion?idP=<%=publicacion.get("id")%>'">
                            <p class="left">
                                <%= publicacion.get("nombre")%>
                            </p>
                            <p class="right">
                                <%= publicacion.get("autor")%>
                            </p>
                        </div>
                        <% } %>
                    </div>

                </div>

            </div>
            <!-- Fin lista de recomendaciones -->
            <div class="columna_publicaciones">
                <!-- CreaciÃ³n de las publicaciones -->
                <div class="texto-publicacion" style="position: relative; margin: auto;">

                    <%@ page import="es.uco.pw.niusFIK.servlets.lista_publicaciones" %>
                    <script src="assets/quill/quill.min.js"></script>
                    <form name="myForm" id="myForm" method="post">
                    <div class="row form-group">
                    <textarea id="Titulo" name="Titulo" style="resize: none; -webkit-border-radius: 5px;
                        -moz-border-radius: 5px; border-radius: 5px;"rows="1" cols="82" placeholder="Titulo"></textarea>
                    <input name="Publicacion" type="hidden">
                    <div id="snow-container"></div>
                    </div>
                    <input name="botonPublicar" type="submit" value="Publicar publicación" style="margin-left: 15px"/> 
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
                        placeholder: 'Escribe tu publicación...',
                        theme: 'snow'
                    });

                    var form = document.querySelector('form[name=myForm]');
                    form.onsubmit = function() {
                    // Populate hidden form on submit
                    var about = document.querySelector('input[name=Publicacion]');
                    about.value = JSON.stringify(quill.root.innerHTML);
                    };
                    </script>

                </div>
                <!-- Fin creaciÃ³n de las publicaciones -->

                <!-- Lista de publicaciones -->
                <div class="lista_publicaciones" style="position: relative; margin: auto;">
                    <div>
                        <div class="borde">
                            <p class="titulo">Lista publicaciones</p>
                            <hr />
                            <% for(Hashtable<String, String> publicacion: allPublications) { %>
                            <div class="titPublicacion" id="titPublicacion<%= publicacion.get("id") %>" onclick="location='publicacion?idP=<%=publicacion.get("id")%>'">
                            <p class="left">
                                <%= publicacion.get("titulo")%> 
                            </p>
                            <p class="right">
                                Fecha: <%= publicacion.get("fecha")%> / Autor: <%= publicacion.get("nombre")%> <%= publicacion.get("apellidos")%>.
                            </p>
                            </div>    
                            <% } %>
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
                            <% if (amigosList.isEmpty()) {
                                } else {
                                    for (Hashtable<String, String> amigoAux : amigosList) {
                                        if (!amigoAux.isEmpty()) {
                            %>
                            <div class="titPublicacion" id="titPublicacion<%= publicacion.get("id") %>" onclick="location='publicacion?idP=<%=publicacion.get("id")%>'">
                                <p><%=amigoAux.get("nombreAmigo")%></p>
                            </div>
                            <%
                                        }
                                    }
                                }
                            %>

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