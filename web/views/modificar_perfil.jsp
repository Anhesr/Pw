<!DOCTYPE html>
<html lang="en">
  <link rel="icon" type="image/png" href="../img/logo.png" />
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="modificar_perfil.css" />
    <link rel="stylesheet" href="../footer_header.css" />

    <title>Currículum - NiusFIK</title>
  </head>
  <body>
    <script src="modificar_perfil.js"></script>
    <div class="formulario" id="formCV">
      <div style="text-align: right;">
        <p class="pubCV" id="pubCVBut" onclick="changeCVType('lab')">
          Perfil laboral
        </p>
        <p class="privCV" id="privCVBut" onclick="changeCVType('priv')">
          Datos privados
        </p>
      </div>
      <form id="pubCV">
        <p class="encabezados">Situación laboral</p>
        <input name="sitpro" type="text" class="forms" />
        <p class="encabezados">Formación académica</p>
        <input name="formac" type="text" class="forms" />
        <p class="encabezados">Intereses profesionales</p>
        <select name="intpro" class="forms">
          <option value="ej1">Ejemplo1</option>
          <option value="ej2">Ejemplo2</option>
          <option value="ej3">Ejemplo3</option>
        </select>
        <p class="encabezados">Experiencia científica</p>
        <input name="expC" type="text" class="forms" />
        <p class="encabezados">Producción científica</p>
        <input name="prodC" type="text" class="forms" />
        <p class="encabezados">Imagen de CV</p>
        <input name="imgP" type="file" class="forms" /> <br />
      </form>
      <form id="privCV" style="display: none;">
        <p class="encabezados">Nombre</p>
        <input name="name" type="text" class="forms" />
        <p class="encabezados">Apellidos</p>
        <input name="surname" type="text" class="forms" />
        <p class="encabezados">Correo electrónico</p>
        <input name="email" type="email" class="forms" />
        <p class="encabezados">Fecha de nacimiento</p>
        <input name="date" type="date" class="forms" style="height: 10px;" />
        <p class="encabezados">Teléfono móvil</p>
        <input name="mobP" type="text" class="forms" /> <br />
      </form>
      <input
        type="button"
        value="Guardar cambios"
        class="submitbutton"
        onclick="irPerfil()"
      />
    </div>
    <div id="CVMod">
      <p id="CVModMsg">
        Currículum modificado
      </p>
    </div>
    <footer class="footer" id="footer">
      <ul style="list-style-type:disc;">
        <li><a href="../aviso_legal/aviso_legal.jsp">Sobre nosotros</a></li>
        <li><a href="../aviso_legal/aviso_legal.jsp">Terminos y Condiciones</a></li>
        <li><a href="../aviso_legal/aviso_legal.jsp">Privacidad</a></li>
        <li><a href="../aviso_legal/aviso_legal.jsp">Centro de Ayuda</a></li>
      </ul>
    </footer>
  </body>
</html>
