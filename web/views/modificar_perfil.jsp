<!DOCTYPE html>
<html lang="es">
    <%@page import="java.util.HashMap"%>
    <%@page pageEncoding="UTF-8"%>
    <!-- Retomamos los datos y comprobamos si existe el parámetro "justRegistered", que indica si viene del registro. -->
    <% HashMap<String, Object> cv = null;
        try {
            if (request.getSession().getAttribute("justRegistered") == null) {
                cv = (HashMap<String, Object>) request.getAttribute("curriculum");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    %>
    <link rel="icon" type="image/png" href="../assets/img/logo.png" />
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="../css/modificar_perfil.css" />
        <link rel="stylesheet" href="../css/footer_header.css" />

        <title>Currí­culum - NiusFIK</title>
    </head>
    <body>
        
        <script src="../js/modificar_perfil.js"></script>
        <!-- Si está recién registrado, solo debe rellenar los campos del currículum público, por lo que deshabilitamos
        el botón de cambiar de CV y el CV privado. -->
        <div class="formulario" id="formCV">
            <% if (request.getSession().getAttribute("justRegistered") == null) { %>
            <div style="text-align: right;">
                <p class="pubCV" id="pubCVBut" onclick="changeCVType('lab')">
                    Perfil laboral
                </p>
                <p class="privCV" id="privCVBut" onclick="changeCVType('priv')">
                    Datos privados
                </p>
            </div>
            <% } %>
            <% if (request.getSession().getAttribute("justRegistered") == null) {%>
            <!-- Los form le mandan la acción al mismo servlet de origen, pero en POST, por lo que podemos mandar la
            información de una manera más segura. -->
            <form id="pubCV" action="../perfil/mod" enctype="multipart/form-data" method="POST">
                <p class="encabezados">Situación laboral</p>
                <input id="sitlab" name="situacion_laboral" type="text" class="forms" value="<%= cv.get("situacion_laboral")%>" />
                <p class="encabezados">Formación académica</p>
                <input id="formac" name="formacion_academica" type="text" class="forms" value="<%= cv.get("formacion_academica")%>" onchange="allFilled()" />
                <p class="encabezados">Universidad / centro de origen</p>
                <input id="univ" name="universidad" type="text" class="forms" value="<%= cv.get("universidad")%>" onchange="allFilled()" />
                <p class="encabezados">Intereses profesionales</p>
                <input id="intprof" name="intereses_profesionales" type="text" class="forms" value="<%= cv.get("intereses_profesionales")%>" onchange="allFilled()" />
                <p class="encabezados">Experiencia cientí­fica</p>
                <input id="expC" name="experiencia_cientifica" type="text" class="forms" value="<%= cv.get("experiencia_cientifica")%>" onchange="allFilled()" />
                <p class="encabezados">Producción cientí­fica</p>
                <input id="prodC" name="produccion_cientifica" type="text" class="forms" value="<%= cv.get("produccion_cientifica")%>" onchange="allFilled()" /> <br/>
                <input
                    type="submit"
                    id="submitButtonPublic"
                    value="Guardar cambios"
                    class="submitbutton"
                    />
            </form>
            <% } else {%>
            <form id="pubCV" action="../perfil/mod" enctype="multipart/form-data" method="POST">
                <p class="encabezados">Situación laboral</p>
                <select id="sitlab" name="situacion_laboral" class="forms" onchange="allFilled()">
                    <option value="Activo">Activo</option>
                    <option value="En paro">En paro</option>
                    <option value="Estudiante">Estudiante</option>
                </select>
                <p class="encabezados">Formación académica</p>
                <input id="formac" name="formacion_academica" type="text" class="forms" onchange="allFilled()" />
                <p class="encabezados">Universidad / centro de origen</p>
                <input id="univ" name="universidad" type="text" class="forms" onchange="allFilled()" />
                <p class="encabezados">Intereses profesionales</p>
                <input id="intprof" name="intereses_profesionales" type="text" class="forms" onchange="allFilled()" />
                <p class="encabezados">Experiencia cientí­fica</p>
                <input id="expC" name="experiencia_cientifica" type="text" class="forms" onchange="allFilled()" />
                <p class="encabezados">Producción cientí­fica</p>
                <input id="prodC" name="produccion_cientifica" type="text" class="forms" onchange="allFilled()" /> <br/>
                <input
                    type="submit"
                    id="submitButtonPublic"
                    value="Guardar cambios"
                    class="submitbutton"
                    />
            </form>
            <% }
                if (request.getSession().getAttribute("justRegistered") == null) {%>
            <form id="privCV" style="display: none;" enctype="multipart/form-data" action="../perfil/mod" method="POST">
                <p class="encabezados">Nombre</p>
                <input name="nombre" type="text" class="forms" value="<%= cv.get("nombre")%>" />
                <p class="encabezados">Apellidos</p>
                <input name="apellidos" type="text" class="forms" value="<%= cv.get("apellidos")%>" />
                <p class="encabezados">Correo electrónico</p>
                <input name="correo_electronico" type="email" class="forms" value="<%= cv.get("correo_electronico")%>" />
                <p class="encabezados">Fecha de nacimiento</p>
                <input name="fecha_nacimiento" type="date" class="forms" style="height: 10px;" value="<%= cv.get("fecha_nacimiento")%>" />
                <p class="encabezados">Imagen de CV</p>
                <input type="checkbox" id="imgselecting" onchange="activateImg()" />
                <input id="imagen" name="imagen" type="file" class="forms" disabled />
                <p class="encabezados">Contraseña anterior
                    <% if (request.getAttribute("passChanged") != null) {
                            if ((boolean) request.getAttribute("passChanged")) {%>
                    <%= "<span style='color:green'>Contraseña cambiada</span>"%>
                    <%} else {%>
                    <%= "<span style='color:red'>Contraseña errónea</span>"%>
                    <%}
                        }%></p>
                <input id="lastPass" name="lastPass" type="password" class="forms" oninput="isEmpty()" />
                <p class="encabezados">Nueva contraseña</p>
                <input id="password" name="password" type="password" class="forms" disabled />
                <p class="encabezados">Valida la contraseña</p>
                <input id="valPass" name="valPass" type="password" class="forms" oninput="samePass()" disabled /> <br />
                <input
                    id="submitButton"
                    type="submit"
                    value="Guardar cambios"
                    class="submitbutton"
                    />
            </form>
            <%}%>
            <% if (request.getSession().getAttribute("justRegistered") == null) {%>
            <input
                type="button"
                value="Ir al perfil"
                class="submitbutton"
                onclick="irPerfil()"
                />
            <% }%>
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
