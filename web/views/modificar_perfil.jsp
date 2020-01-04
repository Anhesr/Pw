<!DOCTYPE html>
<html lang="es">
    <%@page import="java.util.HashMap"%>
    <%@page pageEncoding="UTF-8"%>
    <% HashMap<String, Object> cv
                = (HashMap<String, Object>) request.getAttribute("curriculum");
        request.setCharacterEncoding("UTF-8");%>
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
            <form id="pubCV" action="/niusFIK/perfil/mod" enctype="multipart/form-data" method="POST">
                <p class="encabezados">Situación laboral</p>
                <select name="situacion_laboral" class="forms" value="<%= cv.get("situacion_laboral")%>">
                    <option value="Activo">Activo</option>
                    <option value="En paro">En paro</option>
                    <option value="Estudiante">Estudiante</option>
                </select>
                <p class="encabezados">Formación académica</p>
                <input name="formacion_academica" type="text" class="forms" value="<%= cv.get("formacion_academica")%>" />
                <p class="encabezados">Universidad / centro de origen</p>
                <input name="universidad" type="text" class="forms" value="<%= cv.get("universidad")%>" />
                <p class="encabezados">Intereses profesionales</p>
                <input name="intereses_profesionales" type="text" class="forms" value="<%= cv.get("intereses_profesionales")%>" />
                <p class="encabezados">Experiencia cientí­fica</p>
                <input name="experiencia_cientifica" type="text" class="forms" value="<%= cv.get("experiencia_cientifica")%>" />
                <p class="encabezados">Producción cientí­fica</p>
                <input name="produccion_cientifica" type="text" class="forms" value="<%= cv.get("produccion_cientifica")%>" /> <br/>
                <input
                    type="submit"
                    value="Guardar cambios"
                    class="submitbutton"
                    />
            </form>
            <form id="privCV" style="display: none;" enctype="multipart/form-data" action="/niusFIK/perfil/mod" method="POST">
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
            <input
                type="button"
                value="Ir al perfil"
                class="submitbutton"
                onclick="irPerfil()"
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
