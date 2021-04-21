/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;


import com.vacovid.entity.Representante;
import com.vacovid.entity.Usuario;
import com.vacovid.session.MunicipioFacadeLocal;
import com.vacovid.session.RepresentanteFacadeLocal;
import com.vacovid.session.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "RegistroRepresentante", urlPatterns = {"/RegistroRepresentante"})
public class RegistroRepresentante extends HttpServlet {

    @EJB
    private RepresentanteFacadeLocal representanteFacade;


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
            int identificacion = Integer.parseInt(request.getParameter("identificacion"));
            String fecha = request.getParameter("fecha de nacimiento");
            
            DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date date= df.parse(fecha);
            int count=0;
           
            for (Representante representante : representanteFacade.findAll()) {
                if (representante.getIdentificacion()== identificacion) {
                    count=1;
                    break;
                }
            }
            if (count == 0) {
                if (!contraseña.equals(request.getParameter("contraConfirmada"))) {
                    out.println("<script type=\"text/javascript\">\n" + "  alert(\"Contraseñas no coincidentes\");\n" + "</script>");
                    out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/registroRepresentante.jsp\" />");
                } else {
                    Representante representante= new Representante(identificacion, nombres, apellidos, date, telefono, email, contraseña);
                    if (request.getParameter("action").equals("Registrarse")) {
                        representanteFacade.create(representante);
                        out.println("Representante registrado correctamente");
                    }
                }
            }else{
                    out.println("<script type=\"text/javascript\">\n" + "  alert(\"El usuario ya se encuentra registrado\");\n" + "</script>");
                    out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/registroRepresentante.jsp\" />");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroRepresentante</title>");
            out.println("</head>");
            out.println("<body>");
           
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(RegistroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
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
