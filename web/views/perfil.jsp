<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    ArrayList<Hashtable<String, String>> publicaciones = null;
    HashMap<String, Object> curriculum = null;
    boolean friend=false;
    try {
        publicaciones
                = (ArrayList<Hashtable<String, String>>) request.getAttribute("publicaciones");
        curriculum
                = (HashMap<String, Object>) request.getAttribute("curriculum");
        friends
                = (boolean) request.getAttribute("friends");
    } catch (Exception e) {
        System.out.println(e);
    }%>
<html lang="es">
    <link rel="icon" type="image/png" href="assets/img/logo.png" />
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/perfil.css" />
        <link rel="stylesheet" href="assets/quill/quill.snow.css" />
        <link rel="stylesheet" href="css/publicacion.css">
        <link rel="stylesheet" href="css/footer_header.css" />

        <title>Perfil - NiusFIK</title>
    </head>
    <body onresize="hideSearchBar()">
        <script src="js/perfil.js"></script>
        <script src="js/general_functions.js"></script>

        <header class="header">
            <div class="logo">
                <a href="inicio"
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
                <%  String photo64 = null;
                    try {
                        Blob blob = (Blob) curriculum.get("imagen");
                        byte[] ba = blob.getBytes(1, (int) blob.length());
                        byte[] img64 = Base64.encodeBase64(ba);
                        photo64 = new String(img64);
                        photo64 = "data:image;base64," + photo64;
                    } catch (Exception e) {
                        System.out.println(e);
                        photo64 = "assets/img/perfil.jpg";
                    }

                %>
                <img
                    style="grid-column: 1;"
                    class="bordeImg"
                    src="<%= photo64%>"
                    alt="Imagen de perfil"
                    width="125"
                    />
                <% try {
                        if (request.getParameter("id").equals(request.getSession().getAttribute("uID"))) {%>
                <input
                    style="grid-column: 2; grid-row: 1; margin-top: 3em;"
                    class="buttonsPerfil"
                    type="button"
                    value="Modificar perfil"
                    onclick="modificarPerfil()"
                    />
                <%      } else { %>
                <% if(!friends){%>
                    <form name="FormAnadir" id="FormAnadir" method="post">
                        <input name="id" id="id" type="hidden" value="<%= request.getParameter("id")%>" />
                        <input
                        style="grid-column: 2; grid-row: 1; margin-top: 2em;"
                        class="buttonsPerfil"
                        name="botonAnadir"
                        type="submit"
                        value="Añadir amigo"
                        />
                    </form>
                <%      } else { %>
                    <form name="FormBorrar" id="FormBorrar" method="post">
                        <input name="id" id="id" type="hidden" value="<%= request.getParameter("id")%>" />
                        <input
                        style="grid-column: 2; grid-row: 1; margin-top: 2em;"
                        class="buttonsPerfil"
                        name="botonEliminar"
                        type="submit"
                        value="Borrar amigo"
                        />
                    </form>
                <%  }
                  }
                  } catch (Exception e) {
                  }%>
            </div>

            <div class="newPublis">
                <div class="borde" style=" height: 225px; position: relative; margin-bottom: 10px; ">

                    
                    <%@ page import="es.uco.pw.niusFIK.servlets.perfil" %>
                    <script src="assets/quill/quill.min.js"></script>
                    <form name="myForm" id="myForm" method="post">
                        <div class="row form-group">
                            <textarea id="Titulo" name="Titulo" style="resize: none; -webkit-border-radius: 5px;
                                      -moz-border-radius: 5px; border-radius: 5px;"rows="1" cols="125" placeholder="Titulo"></textarea>
                            <input name="Publicacion" type="hidden">
                            <div id="snow-container"></div>
                        </div>
                        <% if (request.getParameter("id").equals(request.getSession().getAttribute("uID"))){%>
                        <input name="botonPublicar" type="submit" value="Publicar publicación" />
                        <% } %>
                    </form>
                    <script>
                        var quill = new Quill('#snow-container', {
                            modules: {
                                toolbar: [
                                    ['bold', 'italic'],
                                    ['link'],
                                    [{list: 'ordered'}, {list: 'bullet'}]
                                ]
                            },
                            placeholder: 'Escribe tu publicación...',
                            theme: 'snow'
                        });

                        var form = document.querySelector('form[name=myForm]');
                        form.onsubmit = function () {
                            // Populate hidden form on submit
                            var about = document.querySelector('input[name=Publicacion]');
                            about.value = JSON.stringify(quill.root.innerHTML);
                        };
                    </script>
                    
                </div>
            </div>
        </div>
        <div class="nonPublis" id="noPublis">
            <p class="borde publicacion" style="padding-top: 0.5em;
               padding-bottom: 0.5em;">No hay publicaciones.</p>
        </div>
        <div class="gridPag2" id="gridForCVPubls" style="height: 30em;">
            <div id="miCV" class="borde">
                <p class="titulo">Mi Currí­culum Vitae</p>
                <hr />
                <div id="privCVper" class="publicacion borde2 back">
                    <div class="CVfields">
                        <p><strong>Nombre:</strong> <%= curriculum.get("nombre")%></p>
                        <p><strong>Apellidos:</strong> <%= curriculum.get("apellidos")%></p>
                        <p><strong>Correo electrónico:</strong> <%= curriculum.get("correo_electronico")%></p>
                        <p><strong>Fecha de nacimiento:</strong> <%= curriculum.get("fecha_nacimiento")%></p>
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
                <div style="overflow: auto; height: 27em;">
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
                        onmouseout="outHoverOnPublication(<% out.print(publicacion.get("id"));%>)"
                        onclick="location = 'publicacion?idP=<%=publicacion.get("id")%>'"
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
