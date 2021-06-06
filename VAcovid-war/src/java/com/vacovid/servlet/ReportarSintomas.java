/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.CorreoBean;
import com.vacovid.entity.Usuario;
import static com.vacovid.servlet.Email.codigo;
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
 * @author Cristian Duarte
 */
@WebServlet(name = "ReportarSintomas", urlPatterns = {"/ReportarSintomas"})
public class ReportarSintomas extends HttpServlet {

    @EJB
    private CorreoBean correoBean;

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
            String usuario = (String) objsession.getAttribute("usuario1");

            Usuario user = usuarioFacade.find(Integer.parseInt(usuario));

            //Datos del correo que envia los codigos
            String correo = "vacovidunipiloto@gmail.com";
            String username = "vacovidunipiloto";
            String pass = "123@Admin";
            String vaEmail = "vacovidunipiloto@gmail.com";
            String asunto ="En la fecha "+ request.getParameter("fecha") + " El usuario identificado con el número: "+ usuario +" ha presentado los siguientes síntomás luego de recibir su vacuna:  "+request.getParameter("sintomas");
            
            correoBean.reportarSintomas(correo, username, pass, vaEmail, asunto);
         
             out.println("<script type=\"text/javascript\">\n" + "  alert(\"Correo enviado exitosamente\" ); \n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/menu.jsp\" />");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ReportarSintomas</title>");            
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
