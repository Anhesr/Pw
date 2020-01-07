/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.loginDAO;
import es.uco.pw.niusFIK.javabean.userBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author janthonyo
 */

public class login extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
        rd.include(request,response); 
    }
    
    
    /**
     * Handles the HTTP <code>GET</code> method.
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
        PrintWriter out = response.getWriter();
        
        // Se obtienen el nombre de usuario y la contraseña introducidos durante
        // el login
        String user = request.getParameter("user");
        String passwd = request.getParameter("password");
        
        // Comprueba que los datos introducidos corresponden con los datos de un 
        // usuario registrado en la base de datos mediante la funcion checkLogin()
        if(loginDAO.checkLogin(user, passwd))
        {
            // Si el login es correcto, se obtienen los datos del usuario en 
            // cuestion y se almacenan aquellos necesarios en la sesion del 
            // usuario para un posterior uso.
            Hashtable<String, String> data = loginDAO.queryByUser(user);
            
            request.getSession().setAttribute("uID", data.get("id"));
            request.getSession().setAttribute("uName", data.get("nombre"));
            request.getSession().setAttribute("uLogin", data.get("user"));
            
            // Se redirige la respuesta a la pagina con las publicaciones
            response.sendRedirect("inicio");
        }
        
        else{
            // Si el login es incorrecto, se envia el control a la pagina de error
            // del login y el usuario tendra que reinsertar los datos
            request.getRequestDispatcher("/views/loginError.jsp").include(request,response);
        }
        
        out.close();
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
