/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.amigosDAO;
import es.uco.pw.niusFIK.dao.publicacionesDAO;
import es.uco.pw.niusFIK.dao.curriculumDAO;
import es.uco.pw.niusFIK.javabean.userBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import static java.util.Objects.isNull;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author skrotex
 */
public class lista_publicaciones extends HttpServlet {

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
        ArrayList<HashMap<String, String>> recomendaciones = publicacionesDAO.getRecomendations();
        ArrayList<Hashtable<String, String>> resultPb = publicacionesDAO.queryByUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        ArrayList<Hashtable<String, String>> result = amigosDAO.friendsNameByID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        ArrayList<Hashtable<String, String>> publicacionesTotales = publicacionesDAO.AllPublicationExceptYou(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        request.setAttribute("listaAmigos", result);
        request.setAttribute("publicaciones",resultPb);
        request.setAttribute("recomendaciones", recomendaciones);
        request.setAttribute("allPublication", publicacionesTotales);
        request.getRequestDispatcher("/views/lista_publicaciones.jsp").forward(request, response);
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
        
        if(!isNull(request.getParameter("botonPublicar"))){
            request.setAttribute("botonPublicar", null);
            int id = publicacionesDAO.idPublicacionDisponible();
            String cuerpo = request.getParameter("Publicacion");
            String nombre = request.getParameter("Titulo");
            String idUsuario = (String) request.getSession().getAttribute("uID");
            Date f = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fecha = formatter.format(f);
            publicacionesDAO.publicarPublicacion(id, Integer.parseInt(idUsuario), nombre, cuerpo, fecha, 0);
            response.sendRedirect(request.getContextPath()+"/publicacion?idP="+id);
        }
        
        //RequestDispatcher rd = request.getRequestDispatcher("/views/lista_publicaciones.jsp");
        //rd.include(request,response);
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
