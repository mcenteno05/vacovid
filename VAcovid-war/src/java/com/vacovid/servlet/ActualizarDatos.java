/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Usuario;
import com.vacovid.session.MunicipioFacadeLocal;
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
@WebServlet(name = "ActualizarDatos", urlPatterns = {"/ActualizarDatos"})
public class ActualizarDatos extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            //Se obtiene el usuario a 
            Usuario user = usuarioFacade.find(1000048305);
            
            //Se obtienen los nuevos datos
            String telefono= request.getParameter("telefono");
            Integer municipio = Integer.parseInt(request.getParameter("municipio"));
            String direccion = request.getParameter("direccion");
            String correo = request.getParameter("correo");
                    
            //Se ajustan los nuevos datos
            user.setTelefono(telefono);
            user.setCodigoDaneMunicipio(municipioFacade.find(municipio));
            user.setDireccion(direccion);
            user.setCorreo(correo);
            
            //se edita el usuario
            usuarioFacade.edit(user);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Se han actualizado los datos correctamente");
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
