/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.comentariosDAO;
import es.uco.pw.niusFIK.dao.loginDAO;
import es.uco.pw.niusFIK.dao.publicacionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Date;
import static java.util.Objects.isNull;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

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
        /*PrintWriter out = response.getWriter();
        out.print(request.getParameter("idP"));*/
        int idPu = Integer.parseInt((String)request.getParameter("idP"));
        
        publicacionesDAO.ActualizarVisita(idPu);
        
        ArrayList<Hashtable<String, String>> resultPb;
        resultPb = publicacionesDAO.queryByUserID(Integer.parseInt((String) request.getSession().getAttribute("uID")));
        
        ArrayList<Hashtable<String, String>> resultOnePublication;
        resultOnePublication = publicacionesDAO.loadPublication(idPu);
        
        ArrayList<Hashtable<String, String>> resultCom;
        resultCom = comentariosDAO.loadComments(idPu);
        
        request.setAttribute("comentariosP", resultCom);
        request.setAttribute("publicacion", resultOnePublication);
        request.setAttribute("publicaciones", resultPb);
        
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
        
        if(!isNull(request.getParameter("delCom"))){
            request.setAttribute("delCom", null);
            comentariosDAO.EliminarComentarioByID(Integer.parseInt(request.getParameter("idComentario")));
            processRequest(request, response);
        }
        
        if(!isNull(request.getParameter("deletPublic"))){
            publicacionesDAO.EliminarPublicacionByID(Integer.parseInt(request.getParameter("idP")));
            request.setAttribute("deletPublic", null);
            response.sendRedirect(request.getContextPath()+"/perfil");
        }
        
        if(!isNull(request.getParameter("botonComentar"))){
            request.setAttribute("botonComentar", null);
            String cuerpo = (String)request.getParameter("Coment2");
            int idUsuario = Integer.parseInt((String)request.getSession().getAttribute("uID"));
            int idPublicacion = Integer.parseInt(request.getParameter("idP"));
            Hashtable<String, String> user = comentariosDAO.DatosUser(idUsuario);
            String nombre = user.get("nombre");
            String apellidos = user.get("apellidos");
            Date f = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fecha = formatter.format(f);        
            comentariosDAO.publicarComentario(idUsuario, idPublicacion, nombre, apellidos, cuerpo, fecha);
            processRequest(request, response);
        }
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
