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
                <a href="javascript:history.back()"><h1><img src="assets/img/logo.png">NiusFIK</h1></a>
            </div>

            <div class="barra-busqueda-principal">
                <input type="search" id="miBusqueda" name="q"
                       placeholder="Buscar en el sitio...">
                <button>Buscar</button>
            </div>
            <div class="botones-principal">
                <INPUT type="button" onclick="location = 'perfil'" name="Mi Perfil" value="Mi Perfil" />
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
                        <div class="titPublicacion" id="titPublicacion<%= publicacion.get("id") %>">
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
                <!-- Creación de las publicaciones -->
                <div class="texto-publicacion" style="position: relative; margin: auto;">

                    <%@ page import="es.uco.pw.niusFIK.servlets.lista_publicaciones" %>
                    <form action="perfil" method="post">
                        <!-- <script src="assets/quill/quill.min.js"></script>
                        <script>
                         var quill = new Quill("#snow-container", {
                        placeholder: "Introduzca el texto...",
                        theme: "snow"
                        });
                         </script>-->
                        <br/>
                        <textarea id="Titulo" name="Titulo" rows="3" cols="80" placeholder="Titulo"></textarea>
                        <textarea id="Publicacion" name="Publicacion" rows="3" cols="80" placeholder="Escribe tu publicacion"></textarea>
                        <input type="submit" value="Publicar" /> 
                    </form>

                </div>
                <!-- Fin creación de las publicaciones -->

                <!-- Lista de publicaciones -->
                <div class="lista_publicaciones" style="position: relative; margin: auto;">
                    <div>
                        <div class="borde">
                            <p class="titulo">Lista publicaciones</p>
                            <hr />
                            <% if (amigosList.isEmpty()) {
                                } else {
                                    for (Hashtable<String, String> amigoAux : amigosList) {
                                        if (!amigoAux.isEmpty()) {
                            %>
                            <p><%=amigoAux.get("nombreAmigo")%></p>
                            <%
                                        }
                                    }
                                }
                            %>
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