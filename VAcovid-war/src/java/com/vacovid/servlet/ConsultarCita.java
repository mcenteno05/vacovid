/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Cita;
import com.vacovid.entity.Municipio;
import com.vacovid.entity.Usuario;
import com.vacovid.session.CitaFacadeLocal;
import com.vacovid.session.UsuarioFacadeLocal;
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
 * @author JEFRY
 */
@WebServlet(name = "ConsultarCita", urlPatterns = {"/ConsultarCita"})
public class ConsultarCita extends HttpServlet {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private CitaFacadeLocal citaFacade;

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
            
            int id=Integer.parseInt(request.getParameter("identificacion"));
            Municipio municipio=null;
            Usuario usuario=null;
            Cita cita=null;
            for (Cita object : citaFacade.findAll()) 
            {
                if (object.getIdentificacionUsuario().getIdentificacion()==id) 
                {
                    cita=object;
                    usuario=object.getIdentificacionUsuario();
                    municipio=usuario.getCodigoDaneMunicipio();
                }
            }
            
            if (request.getParameter("action").equals("Consultar")) {
                cita=citaFacade.find(cita.getCitaid());
            }
            
            request.setAttribute("cita", cita);
            request.setAttribute("usuario", usuario);
            request.setAttribute("municipio", municipio);
            request.getRequestDispatcher("consultarCita.jsp").forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarCita</title>");            
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
