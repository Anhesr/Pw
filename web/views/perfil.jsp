<!DOCTYPE html>
<%@page import="java.util.ArrayList, java.util.Hashtable"%>
<%%>
<html lang="es">
  <link rel="icon" type="image/png" href="img/logo.png" />
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="perfil/perfil.css" />
    <link rel="stylesheet" href="quill/quill.snow.css" />
    <link rel="stylesheet" href="footer_header.css" />

    <title>Perfil - NiusFIK</title>
  </head>
  <body onresize="hideSearchBar()">
    <script src="perfil/perfil.js"></script>
    <script src="general_functions.js"></script>

    <header class="header">
      <div class="logo">
        <a href="lista_publicaciones/lista_publicaciones.jsp"
          ><h1><img src="img/logo.png" />NiusFIK</h1></a
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
          src="img/perfil.jpg"
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
    <div class="gridPag2">
      <div id="miCV" class="borde">
        <p class="titulo">Mi Currículum Vitae</p>
        <hr />
        <div class="flip-container">
          <div class="flipper">
              <div id="privCVper" class="publicacion borde2 back">
                  <div class="CVfields">
                    <p><strong>Nombre:</strong> Juan</p>
                    <p><strong>Apellidos:</strong> Mariscal Muñoz</p>
                    <p><strong>Correo electrónico:</strong> prueba@prueba.com</p>
                  </div>
                </div>
                <div id="pubCVper" class="publicacion borde2 front">
                  <div class="CVfields">
                    <p><strong>Situación laboral:</strong> Activo</p>
                    <p>
                      <strong>Formación académica:</strong> Grado en Ingeniería
                      Informática
                    </p>
                    <p>
                      <strong>Intereses profesionales:</strong> Diseño de aplicaciones
                      Web
                    </p>
                    <p><strong>Experiencia científica:</strong> Ninguna</p>
                    <p><strong>Producción científica:</strong> Ninguna</p>
                  </div>
                </div>
          </div>
        </div>
      </div>
      <div id="misPublis" class="borde">
        <p class="titulo">Mis publicaciones</p>
        <hr />
        <!-- Creación de las publicaciones -->
        <div>
            <!-- Inicio de publicacion -->
          <div
            class="borde publicacion"
            id="publicacion"
            onmouseover="hoverOnPublication(1)"
            onmouseout="outHoverOnPublication(1)"
            onclick="goToPubli(1)"
          >
            <div class="titPublicacion" id="titPublicacion1">
              <p class="left">
              </p>
              <p class="right">
              </p>
            </div>
            <hr id="hrPublicacion1" />

            <div style="position: relative; margin: auto;">
              <p class="bodyPublicacion" id="bodyPublicacion1">
              </p>
              <p class="publiTransition" id="goToPubli1">
                Ir a la publicaci�n
              </p>
            </div>
          </div>
            <!-- Fin de publicacion -->
        </div>
        <!-- Fin de creación de publicaciones -->
      </div>
    </div>
    <script src="quill/quill.min.js"></script>
    <script>
      var quill = new Quill("#snow-container", {
        placeholder: "Introduzca el texto...",
        theme: "snow"
      });
    </script>
    <footer class="footer">
      <ul style="list-style-type:disc;">
        <li><a href="aviso_legal/aviso_legal.jsp">Sobre nosotros</a></li>
        <li><a href="aviso_legal/aviso_legal.jsp">Terminos y Condiciones</a></li>
        <li><a href="aviso_legal/aviso_legal.jsp">Privacidad</a></li>
        <li><a href="aviso_legal/aviso_legal.jsp">Centro de Ayuda</a></li>
      </ul>
    </footer>
  </body>
</html>
