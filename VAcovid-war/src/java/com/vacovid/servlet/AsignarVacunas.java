/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.InventarioDeVacunacion;
import com.vacovid.entity.Vacuna;
import com.vacovid.entity.VacunaRecibida;
import com.vacovid.session.InventarioDeVacunacionFacadeLocal;
import com.vacovid.session.VacunaFacadeLocal;
import com.vacovid.session.VacunaRecibidaFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AsignarVacunas", urlPatterns = {"/AsignarVacunas"})
public class AsignarVacunas extends HttpServlet {

    @EJB
    private VacunaFacadeLocal vacunaFacade;

    @EJB
    private VacunaRecibidaFacadeLocal vacunaRecibidaFacade;

    @EJB
    private InventarioDeVacunacionFacadeLocal inventarioDeVacunacionFacade;


   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            HttpSession objsession = request.getSession(false);
            String usuario1 = (String) objsession.getAttribute("usuario1");
            int distribuidor = Integer.parseInt(usuario1);

            int idSitio = Integer.parseInt(request.getParameter("sitios de vacunacion"));
            int idinventarioNacional= Integer.parseInt(request.getParameter("idinventarionacional"));
            int idvacuna= Integer.parseInt(request.getParameter("vacuna"));
            int cantidad= Integer.parseInt(request.getParameter("cantidad"));
            int idinventario = Integer.parseInt(request.getParameter("idinventario"));
          
            
            if (request.getParameter("action").equals("Asignar vacunas")) 
            {
                InventarioDeVacunacion inventario = inventarioDeVacunacionFacade.find(idinventario);
                
                Vacuna vacuna = vacunaFacade.find(idvacuna);
                
                VacunaRecibida vacunarecibida = new VacunaRecibida(vacuna.getNombre(), vacuna.getFechaDeVencimiento(), cantidad, vacuna.getLote(), inventario);
                vacunaRecibidaFacade.create(vacunarecibida);
                
                vacuna.setCantidad(vacuna.getCantidad()-cantidad);
                vacunaFacade.edit(vacuna);
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsignarVacunas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsignarVacunas at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AsignarVacunas.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AsignarVacunas.class.getName()).log(Level.SEVERE, null, ex);
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
