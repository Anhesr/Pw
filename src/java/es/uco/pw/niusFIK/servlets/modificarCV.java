/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.servlets;

import es.uco.pw.niusFIK.dao.curriculumDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author skrotex
 */
public class modificarCV extends HttpServlet {

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
            response.setContentType("text/html;charset=UTF-8");
            Hashtable<String, String> result = curriculumDAO.queryByUserID(1);
            request.setAttribute("curriculum", result);
            request.getRequestDispatcher("/views/modificar_perfil.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.print(e);
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
        try {
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<body>");
            out.print("El tipo es " + session.getAttribute("cv_type"));
            Hashtable<String, String> updateMap = new Hashtable<String, String>();
            out.print("<p>");
            out.print("name: " + request.getParameter("name"));
            out.print("</p>");
            out.print("<p>");
            out.print("surname: " + request.getParameter("surname"));
            out.print("</p>");
            out.print("<p>");
            out.print("email: " + request.getParameter("email"));
            out.print("</p>");
            out.print("<p>");
            out.print("date: " + request.getParameter("date"));
            out.print("</p>");
            out.print("<p>");
            out.print("formac: " + request.getParameter("formac"));
            out.print("</p>");
            out.print("<p>");
            out.print("intprof: " + request.getParameter("intprof"));
            out.print("</p>");
            out.print("<p>");
            out.print("expC: " + request.getParameter("expC"));
            out.print("</p>");
            out.print("<p>");
            out.print("prodC: " + request.getParameter("prodC"));
            out.print("</p>");

            out.print("</body>");
            out.print("</html>");
            //request.getRequestDispatcher("/views/modificar_perfil.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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
