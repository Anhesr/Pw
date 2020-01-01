/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import es.uco.pw.niusFIK.dao.publicacionesDAO;
import es.uco.pw.niusFIK.dao.comentariosDAO;
import es.uco.pw.niusFIK.javabean.userBean;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import static java.sql.Types.NULL;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author skrotex
 */
public class publicacion extends HttpServlet {
    
/* ERROR
void comentar() {
    //Hashtable<String, String> res;
    String cuerpo = document.getElementById("Coment").value ;
    Date f = new Date();
    String fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getYear();
    int idPublicacion = document.getElementById("idP").value ;
    String nombre = request.getAttribute("usuarioActual").get("nombre");
    String apellidos = request.getAttribute("usuarioActual").get("apellido");
    comentariosDAO.publicarComentario(idPublicacion, 1, nombre, apellidos, cuerpo, fecha);
    res.put("idPublicacion", idPublicacion);
    res.put("idComment", 1);
    res.put("nombre", nombre);
    res.put("apellidos", apellidos);
    res.put("cuerpo", cuerpo);
    res.put("fecha", fecha);
    //int idPublicacion, int idComment, String nombre, String apellidos, String cuerpo, String fecha
    request.setAttribute("comentario", res);
}

void publicar(){
    Hashtable<String, String> res;
    String nombre = document.getElementById("Titulo").value ;
    String cuerpo = document.getElementById("Publicacion").value ;
    Date f = new Date();
    String fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getYear();
    int visitas = 1;
    int id = 1;
    publicacionesDAO.publicarPublicacion(id, nombre, cuerpo, fecha, visitas);
    request.setAttribute("publicacion", res);
    
    //insert into publicaciones(id, nombre,"
    //            + "cuerpo, fecha_publicacion, visitas)
    //window.location = "../views/publicacion.jsp?idP="+???+"&idUsuario="+???;
}
*/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Hashtable<String, String>> resultPb;
        resultPb = publicacionesDAO.queryByUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        ArrayList<Hashtable<String, String>> resultCom;
        resultCom = comentariosDAO.queryByPublicationID(Integer.parseInt(request.getParameter("idP")));
        request.setAttribute("publicaciones", resultPb);
        request.setAttribute("comentarios", resultCom);
        RequestDispatcher rd = request.getRequestDispatcher("/views/publicacion.jsp?idP="+request.getParameter("idP"));
        rd.include(request,response);
    }  
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        response.setContentType("text/html;charset=UTF-8");
        String cuerpo = request.getParameter("Coment");
        String idP = request.getParameter("idP");
        String idUsuario = (String) request.getSession().getAttribute("uID");
        int idPublicacion = Integer.parseInt(idP);
        Hashtable<String, String> user = comentariosDAO.userByID(Integer.parseInt(idUsuario));
        String nombre = user.get("nombre");
        String apellidos = user.get("apellido");
        Date f = new Date();
        String fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getYear();
        comentariosDAO.publicarComentario(idPublicacion, NULL, nombre, apellidos, cuerpo, fecha);
        processRequest(request, response);
        /*
        
        
        Hashtable<String, String> coment;
         coment = (Hashtable<String, String>) request.getAttribute("comentario");
         if(coment != null){
            int idP = parseInt(coment.get("idPublicacion"));
            int idC =  parseInt(coment.get("idComment"));
            comentariosDAO.publicarComentario(idP, idC, coment.get("nombre"), coment.get("apellidos"), 
            coment.get("cuerpo"), coment.get("fecha"));
            request.getRequestDispatcher("/views/publicacion.jsp").forward(request, response);
            processRequest(request, response);
         }
         Hashtable<String, String> publicacion;
         publicacion = (Hashtable<String, String>) request.getAttribute("publicacion");
         if(publicacion != null){
             int id = parseInt(publicacion.get("id"));
             publicacionesDAO.publicarPublicacion(id, publicacion.get("nombre"), publicacion.get("cuerpo"), 
                     publicacion.get("fecha"), 1);
             request.getRequestDispatcher("/views/publicacion.jsp").forward(request, response);
            processRequest(request, response);
         }
        
        request.getRequestDispatcher("/views/publicacion.jsp").forward(request, response);*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
