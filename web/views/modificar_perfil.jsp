<!DOCTYPE html>
<html lang="es">
    <%@page import="java.util.Hashtable"%>
    <% Hashtable<String, String> cv 
            = (Hashtable<String, String>) request.getAttribute("curriculum"); %>
  <link rel="icon" type="image/png" href="/niusFIK/assets/img/logo.png" />
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/niusFIK/css/modificar_perfil.css" />
    <link rel="stylesheet" href="/niusFIK/css/footer_header.css" />

    <title>Currí­culum - NiusFIK</title>
  </head>
  <body>
    <script src="/niusFIK/js/modificar_perfil.js"></script>
    <div class="formulario" id="formCV">
      <div style="text-align: right;">
        <p class="pubCV" id="pubCVBut" onclick="changeCVType('lab')">
          Perfil laboral
        </p>
        <p class="privCV" id="privCVBut" onclick="changeCVType('priv')">
          Datos privados
        </p>
      </div>
        <form id="pubCV" action="/niusFIK/perfil/mod" method="POST">
        <p class="encabezados">Situación laboral</p>
        <select name="sitlab" class="forms">
          <option value="ej1">Ejemplo1</option>
          <option value="ej2">Ejemplo2</option>
          <option value="ej3">Ejemplo3</option>
        </select>
        <p class="encabezados">Formación académica</p>
        <input name="formac" type="text" class="forms" value="<%= cv.get("formacion_academica") %>" />
        <p class="encabezados">Intereses profesionales</p>
        <input name="intprof" type="text" class="forms" value="<%= cv.get("intereses_profesionales") %>" />
        <p class="encabezados">Experiencia cientÃ­fica</p>
        <input name="expC" type="text" class="forms" value="<%= cv.get("experiencia_cientifica") %>" />
        <p class="encabezados">ProducciÃ³n cientÃ­fica</p>
        <input name="prodC" type="text" class="forms" value="<%= cv.get("produccion_cientifica") %>" />
        <p class="encabezados">Imagen de CV</p>
        <input name="imgP" type="file" class="forms" value="<%= cv.get("imagen") %>" /> <br />
        <input
        type="submit"
        value="Guardar cambios"
        class="submitbutton"
      />
      </form>
        <form id="privCV" style="display: none;" action="/niusFIK/perfil/mod" method="POST">
        <p class="encabezados">Nombre</p>
        <input name="name" type="text" class="forms" value="<%= cv.get("nombre") %>" />
        <p class="encabezados">Apellidos</p>
        <input name="surname" type="text" class="forms" value="<%= cv.get("apellidos") %>" />
        <p class="encabezados">Correo electrónico</p>
        <input name="email" type="email" class="forms" value="<%= cv.get("correo_electronico") %>" />
        <p class="encabezados">Fecha de nacimiento</p>
        <input name="date" type="date" class="forms" style="height: 10px;" /> <br />
        <input
        type="submit"
        value="Guardar cambios"
        class="submitbutton"
      />
      </form>
      <input
          type="button"
          value="Ir al perfil"
          class="submitbutton"
          onclick="irPerfil()"
    </div>
    <div id="CVMod">
      <p id="CVModMsg">
        CurrÃ­culum modificado
      </p>
    </div>
    <footer class="footer" id="footer">
      <ul style="list-style-type:disc;">
        <li><a href="">Sobre nosotros</a></li>
        <li><a href="">Terminos y Condiciones</a></li>
        <li><a href="">Privacidad</a></li>
        <li><a href="">Centro de Ayuda</a></li>
      </ul>
    </footer>
  </body>
</html>
