/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Municipio;
import com.vacovid.entity.Usuario;
import com.vacovid.session.MunicipioFacadeLocal;
import com.vacovid.session.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEFRY
 */
@WebServlet(name = "RegistroUsuario", urlPatterns = {"/RegistroUsuario"})
public class RegistroUsuario extends HttpServlet {

    @EJB
    private MunicipioFacadeLocal municipioFacade;

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

            String nombres = request.getParameter("nombre");
            String apellidos = request.getParameter("apellido");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String contraseña = request.getParameter("contra");
            String tipo = request.getParameter("tipo");
            Integer identificacion = Integer.parseInt(request.getParameter("identificacion"));
            String fecha = request.getParameter("fecha de nacimiento");
            Integer municipio = Integer.parseInt(request.getParameter("municipio"));
            String direccion = request.getParameter("direccion");
            
            DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date date= df.parse(fecha);
            if (!contraseña.equals(request.getParameter("contraConfirmada"))) 
            {
                out.println("<script type=\"text/javascript\">\n" + "  alert(\"Contraseñas no coincidentes\");\n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/registroUsuario.jsp\" />");
            } 
            else 
            {
                Usuario usuario = new Usuario(identificacion, nombres, apellidos,date, telefono, email, contraseña, tipo, direccion, municipioFacade.find(municipio));
                if (request.getParameter("action").equals("Registrarse")) 
                {
                    usuarioFacade.create(usuario);
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
