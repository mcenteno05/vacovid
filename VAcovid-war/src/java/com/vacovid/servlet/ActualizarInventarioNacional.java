/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.InventarioNacional;
import com.vacovid.entity.Vacuna;
import com.vacovid.session.InventarioNacionalFacadeLocal;
import com.vacovid.session.VacunaFacadeLocal;
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
 * @author Cristian Duarte
 */
@WebServlet(name = "ActualizarInventarioNacional", urlPatterns = {"/ActualizarInventarioNacional"})
public class ActualizarInventarioNacional extends HttpServlet {

    @EJB
    private VacunaFacadeLocal vacunaFacade;

    @EJB
    private InventarioNacionalFacadeLocal inventarioNacionalFacade;

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

            int idvacuna = Integer.parseInt(request.getParameter("vacuna"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            if (request.getParameter("action").equals("Actualizar")) {
                
                Vacuna vacuna = vacunaFacade.find(idvacuna);

                if (request.getParameter("tipo").equals("Agregar vacunas")) {
                    vacuna.setCantidad(vacuna.getCantidad() + cantidad);
                    vacunaFacade.edit(vacuna);
                }
                if (request.getParameter("tipo").equals("Quitar vacunas")) {

                    if (vacuna.getCantidad() >= cantidad) {
                        vacuna.setCantidad(vacuna.getCantidad() - cantidad);
                        vacunaFacade.edit(vacuna);
                    } else {
                        out.println("<script type=\"text/javascript\">\n" + "  alert(\"La cantidad de vacunas retiradas son mayores a las ya existentes,"
                                + " por favor digite una nueva cantidad valida\" ); \n" + "</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/actualizarInventarioNacional.jsp\" />");
                    }
                }
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarInventarioNacional</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">\n" + "  alert(\" Inventario nacional actualizado correctamente\" ); \n" + "</script>");
            out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/menu_distribuidor.jsp\" />");
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
