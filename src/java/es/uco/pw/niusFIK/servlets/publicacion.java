/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.publicacionesDAO;
import es.uco.pw.niusFIK.dao.comentariosDAO;
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

/**
 *
 * @author skrotex
 */
public class publicacion extends HttpServlet {

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
        resultPb = publicacionesDAO.queryByUserID(1);
        ArrayList<Hashtable<String, String>> resultCom;
        resultCom = comentariosDAO.queryByPublicationID(1);
        request.setAttribute("comentarios", resultCom);
        Hashtable<String, String> user;
        user = comentariosDAO.userByID(1);
        request.setAttribute("usuarioActual", user);
        
        request.getRequestDispatcher("/views/publicacion.jsp").forward(request, response);
    }
     protected void processResponse(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         Hashtable<String, String> coment;
         coment = (Hashtable<String, String>) request.getAttribute("comentario");
         int idP = parseInt(coment.get("idPublicacion"));
         int idC =  parseInt(coment.get("idComment"));
         comentariosDAO.publicarComentario(idP, idC, coment.get("nombre"), coment.get("apellidos"), 
                 coment.get("cuerpo"), coment.get("fecha"));
         request.getRequestDispatcher("/views/publicacion.jsp").forward(request, response);
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
        processRequest(request, response);
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
