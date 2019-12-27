<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<% ArrayList<Hashtable<String, String>> publicaciones
            = (ArrayList<Hashtable<String, String>>) request.getAttribute("publicaciones");
    Hashtable<String, String> curriculum
            = (Hashtable<String, String>) request.getAttribute("curriculum");%>
<html lang="es">
    <link rel="icon" type="image/png" href="assets/img/logo.png" />
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/perfil.css" />
        <link rel="stylesheet" href="assets/quill/quill.snow.css" />
        <link rel="stylesheet" href="css/footer_header.css" />

        <title>Perfil - NiusFIK</title>
    </head>
    <body onresize="hideSearchBar()">
        <script src="js/perfil.js"></script>
        <script src="js/general_functions.js"></script>

        <header class="header">
            <div class="logo">
                <a href=""
                   ><h1><img src="assets/img/logo.png" />NiusFIK</h1></a
                >
            </div>
            <div class="barra-busqueda" id="searchBar">
                <input
                    type="search"
                    id="miBusqueda"
                    name="q"
                    placeholder="Buscar en el sitio..."
                    />
                <button>Buscar</button>
            </div>
        </header>

        <div class="gridPag1">
            <div class="imgPerfil">
                <img
                    class="bordeImg"
                    src="<%= curriculum.get("imagen")%>"
                    alt="Imagen de perfil"
                    width="125"
                    />
                <input
                    class="buttonsPerfil"
                    type="button"
                    value="Modificar perfil"
                    onclick="modificarPerfil()"
                    />
            </div>

            <div class="newPublis">
                <div class="borde" style=" position: relative; margin-bottom: 10px; ">
                    <div id="snow-container"></div>
                    <input type="button" value="Publicar" onclick="goToPubli(/*newPubli()*/)" class="publbut buttonsPerfil" />
                </div>
            </div>
        </div>
        <div class="nonPublis" id="noPublis">
            <p class="borde publicacion" style="padding-top: 0.5em;
               padding-bottom: 0.5em;">No hay publicaciones.</p>
        </div>
        <div class="gridPag2" id="gridForCVPubls" style="height: 25em;">
            <div id="miCV" class="borde">
                <p class="titulo">Mi Currí­culum Vitae</p>
                <hr />
                <div id="privCVper" class="publicacion borde2 back">
                    <div class="CVfields">
                        <p><strong>Nombre:</strong> <%= curriculum.get("nombre")%></p>
                        <p><strong>Apellidos:</strong> <%= curriculum.get("apellidos")%></p>
                        <p><strong>Correo electrónico:</strong> <%= curriculum.get("correo_electronico")%></p>
                    </div>
                </div>
                <div id="pubCVper" class="publicacion borde2 front">
                    <div class="CVfields">
                        <p><strong>Situación laboral:</strong> <%= curriculum.get("situacion_laboral")%></p>
                        <p>
                            <strong>Formación académica:</strong> <%= curriculum.get("formacion_academica")%> en <%= curriculum.get("universidad")%>
                        </p>
                        <p>
                            <strong>Intereses profesionales:</strong> <%= curriculum.get("intereses_profesionales")%>
                        </p>
                        <p><strong>Experiencia cientí­fica:</strong> <%= curriculum.get("experiencia_cientifica")%></p>
                        <p><strong>Producción cientí­fica:</strong> <%= curriculum.get("produccion_cientifica")%></p>
                    </div>
                </div>
            </div>
            <div id="misPublis" class="borde">
                <p class="titulo">Mis publicaciones</p>
                <hr />
                <!-- CreaciÃ³n de las publicaciones -->
                <div style="overflow: auto; height: 21em;">
                    <% if (publicaciones.size() == 0) { %>
                    <script>
                        noPublis();
                    </script>
                    <% } else { %>
                    <!-- Inicio de publicacion -->
                    <% for (Hashtable<String, String> publicacion : publicaciones) {%>
                    <div
                        class="borde publicacion"
                        id="publicacion"
                        onmouseover="hoverOnPublication(<% out.print(publicacion.get("id")); %>)"
                        onmouseout="outHoverOnPublication(<% out.print(publicacion.get("id")); %>)"
                        onclick="goToPubli(<% out.print(publicacion.get("id")); %>)"
                        >
                        <div class="titPublicacion" id="titPublicacion<% out.print(publicacion.get("id"));%>">
                            <p class="left">
                                <%= publicacion.get("nombre")%>
                            </p>
                            <p class="right">
                                <%= publicacion.get("autor")%>
                            </p>
                        </div>
                        <hr id="hrPublicacion<% out.print(publicacion.get("id")); %>" />

                        <div style="position: relative; margin: auto;">
                            <p class="bodyPublicacion" id="bodyPublicacion<% out.print(publicacion.get("id"));%>">
                                <%= publicacion.get("cuerpo")%> <br />
                            <p style="text-align: right; padding-right: 0.6em;">
                                <% String fecha = publicacion.get("fecha");%>
                                <%= fecha.substring(0, fecha.length() - 5)%>
                            </p>
                            <p class="publiTransition" id="goToPubli<% out.print(publicacion.get("id")); %>">
                                Ir a la publicación
                            </p>
                        </div>
                    </div>
                    <%  }
                        }%>
                    <!-- Fin de publicacion -->
                </div>
                <!-- Fin de creación de publicaciones -->
            </div>
        </div>
        <script src="assets/quill/quill.min.js"></script>
        <script>
                            var quill = new Quill("#snow-container", {
                                placeholder: "Introduzca el texto...",
                                theme: "snow"
                            });
        </script>
        <footer class="footer" style="clear: both;">
            <ul style="list-style-type:disc;">
                <li><a href="">Sobre nosotros</a></li>
                <li><a href="">Terminos y Condiciones</a></li>
                <li><a href="">Privacidad</a></li>
                <li><a href="">Centro de Ayuda</a></li>
            </ul>
        </footer>
    </body>
</html>
