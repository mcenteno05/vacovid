/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Usuario;
import com.vacovid.session.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFRY
 */
@WebServlet(name = "CambioContraseña", urlPatterns = {"/CambioContrase_a"})
public class CambioContraseña extends HttpServlet {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

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
            
          HttpSession objsession = request.getSession(false);
          String usuario1 = (String) objsession.getAttribute("usuario1");
          int id_usuario = Integer.parseInt(usuario1);
          Usuario user = usuarioFacade.find(id_usuario);
          //se verifica que las contraseña actual sea correcta
         
            System.out.println(request.getParameter("contraActual"));
            if (user.getPassword().equals(request.getParameter("contraActual"))) {
                //se verifica que las contraseñas ingresadas coincidan
                if (request.getParameter("contraNueva").equals(request.getParameter("contraConfirmar"))) {
                    //se ajusta la nueva contraseña
                    user.setPassword(request.getParameter("contraNueva"));
                    usuarioFacade.edit(user);
                    out.println("<script type=\"text/javascript\">\n" + "  "
                                + "alert(\"Contraseña Actualizada\");\n"
                                + "window.location.href =" + "\"http://localhost:8080/VAcovid-war/menu.jsp\"" +
                                "</script>");
                }
                else{
                    out.println("<script type=\"text/javascript\">\n" + "  alert(\"Las contraseñas no coinciden\");\n" + "</script>");
                    out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/cambioContraseña.jsp\" />");
                }
            }
            else{
                out.println("<script type=\"text/javascript\">\n" + "  alert(\"Contraseña incorrecta\");\n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/cambioContraseña.jsp\" />");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CambioContraseña</title>");            
            out.println("</head>");
            out.println("<body>");
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
