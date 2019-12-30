/* global request */
//import es.uco.pw.niusFIK.dao.comentariosDAO;
//import es.uco.pw.niusFIK.dao.publicacionesDAO;

function comentar() {
    Hashtable<String, String> res;
    var cuerpo = document.getElementById("Coment").value ;
    var f = new Date();
    var fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
    var idPublicacion = document.getElementById("idP").value ;
    var nombre = request.getAttribute("usuarioActual").get("nombre");
    var apellidos = request.getAttribute("usuarioActual").get("apellido");
    publicarComentario(idPublicacion, 1, nombre, apellidos, cuerpo, fecha);
    res.put("idPublicacion", idPublicacion);
    res.put("idComment", 1);
    res.put("nombre", nombre);
    res.put("apellidos", apellidos);
    res.put("cuerpo", cuerpo);
    res.put("fecha", fecha);
    //int idPublicacion, int idComment, String nombre, String apellidos, String cuerpo, String fecha
    request.setAttribute("comentario", res);
}

function publicar(){
    Hashtable<String, String> res;
    var nombre = document.getElementById("Titulo").value ;
    var cuerpo = document.getElementById("Publicacion").value ;
    var f = new Date();
    var fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
    var visitas = 1;
    var id = 1;
    publicarPublicacion(id, nombre, cuerpo, fecha, visitas);
    request.setAttribute("publicacion", res);
    
    //insert into publicaciones(id, nombre,"
    //            + "cuerpo, fecha_publicacion, visitas)
    //window.location = "../views/publicacion.jsp?idP="+???+"&idUsuario="+???;
}