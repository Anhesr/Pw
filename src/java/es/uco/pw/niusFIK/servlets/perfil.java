/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.amigosDAO;
import es.uco.pw.niusFIK.dao.comentariosDAO;
import es.uco.pw.niusFIK.dao.publicacionesDAO;
import es.uco.pw.niusFIK.dao.curriculumDAO;
import es.uco.pw.niusFIK.dao.loginDAO;
import es.uco.pw.niusFIK.javabean.userBean;
import java.io.IOException;
import java.io.PrintWriter;
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
public class perfil extends HttpServlet {

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
        ArrayList<Hashtable<String, String>> resultPb = null;
        HashMap<String, Object> resultCV = null;
        boolean friends=false;
        if (request.getParameter("id") == null) {
            resultPb
                    = publicacionesDAO.queryByUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
            resultCV
                    = curriculumDAO.queryByUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        } else {
            resultPb
                    = publicacionesDAO.queryByUserID(Integer.parseInt(request.getParameter("id")));
            resultCV
                    = curriculumDAO.queryByUserID(Integer.parseInt(request.getParameter("id")));
            if (request.getParameter("id").equals(request.getSession().getAttribute("uID"))) {    
            } else {
               friends=amigosDAO.checkIfFriends(Integer.parseInt((String) request.getSession().getAttribute("uID")),Integer.parseInt(request.getParameter("id"))); 
            }
        }
        request.setAttribute("friends",friends);
        request.setAttribute("publicaciones", resultPb);
        request.setAttribute("curriculum", resultCV);
        request.getRequestDispatcher("/views/perfil.jsp").forward(request, response);
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
        try {
            if (loginDAO.existsUserID(Integer.parseInt(request.getParameter("id")))) {
                processRequest(request, response);
            } else if (loginDAO.existsUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")))) {
                processRequest(request, response);
            } else {
                request.getRequestDispatcher("/views/perfilError.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.print(e);
            request.getRequestDispatcher("/views/perfilError.jsp").forward(request, response);
        }

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

        if (!isNull(request.getParameter("botonPublicar"))) {
            request.setAttribute("botonPublicar", null);
            String cuerpo = request.getParameter("Publicacion");
            String nombre = request.getParameter("Titulo");
            String idUsuario = (String) request.getSession().getAttribute("uID");
            Date f = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fecha = formatter.format(f);
            int id = publicacionesDAO.publicarPublicacion(Integer.parseInt(idUsuario), nombre, cuerpo, fecha, 0);
            response.sendRedirect(request.getContextPath() + "/publicacion?idP=" + id);
        }
        
        if (!isNull(request.getParameter("botonAnadir"))) {
            request.setAttribute("botonAnadir", null);
            String idAmigo = request.getParameter("id");
            amigosDAO.insertUserFriend((String) request.getSession().getAttribute("uID"),idAmigo);
            response.sendRedirect(request.getContextPath() + "/perfil?id=" + idAmigo);
        }
        
        if (!isNull(request.getParameter("botonEliminar"))) {
            request.setAttribute("botonEliminar", null);
            String idAmigo = request.getParameter("id");
            amigosDAO.deleteUserFriend((String) request.getSession().getAttribute("uID"),idAmigo);
            response.sendRedirect(request.getContextPath() + "/perfil?id=" + idAmigo);
        }
        
        //RequestDispatcher rd = request.getRequestDispatcher("/views/perfil.jsp");
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
