/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ConexionEJB;
import entidades_POJO.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
@WebServlet(name = "Formulario", urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {

    @EJB
    ConexionEJB conEJB;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Empleado empl = ConexionEJB.em;
            switch(empl.getTipoTramite()){
                case 1:
                    out.println("<h1>Rellenar formulario de Altas</h1>");
                    out.println("<form action=\"Formulario_1.html\" method=\"POST\">"
                            + "Ir al formulario de alta."
                            + "<input type=\"submit\" name=\"ir\" value=\"Ir\" />"
                            + "</form>");
                    break;
                case 2:
                    out.println("<h1>Rellenar formulario de Bajas</h1>");
                    out.println("<form action=\"Formulario_2.html\" method=\"POST\">"
                            + "Ir al formulario de baja."
                            + "<input type=\"submit\" name=\"ir\" value=\"Ir\" />"
                            + "</form>");
                    break;
                case 3:
                    out.println("<h1>Rellenar formulario de Suspensiones</h1>");
                    out.println("<form action=\"Formulario_3.html\" method=\"POST\">"
                            + "Ir al formulario de suspensión."
                            + "<input type=\"submit\" name=\"ir\" value=\"Ir\" />"
                            + "</form>");
                    break;
            }
            
            out.println("<h1>Rellenar formulario de </h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
