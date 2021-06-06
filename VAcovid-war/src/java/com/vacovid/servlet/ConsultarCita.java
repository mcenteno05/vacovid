/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Cita;
import com.vacovid.entity.Municipio;
import com.vacovid.entity.ReporteDeVacunacion;
import com.vacovid.entity.Usuario;
import com.vacovid.session.CitaFacadeLocal;
import com.vacovid.session.ReporteDeVacunacionFacadeLocal;
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
@WebServlet(name = "ConsultarCita", urlPatterns = {"/ConsultarCita"})
public class ConsultarCita extends HttpServlet {

    @EJB
    private ReporteDeVacunacionFacadeLocal reporteDeVacunacionFacade;

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

            HttpSession objsession = request.getSession(false);
            String user1 = (String) objsession.getAttribute("usuario1");
            int user = Integer.parseInt(user1);
            Cita cita = citaFacade.find(Integer.parseInt(request.getParameter("citass")));
            /*for (Cita object : citaFacade.findAll()) {

                if (object.getIdentificacionUsuario().getIdentificacion() == user && object.getDosis()==Integer.parseInt(request.getParameter("dosis"))) {
                    System.out.println("DOSIS"+request.getParameter("dosis"));
                    cita = object;
                }
            }*/

            
            if (request.getParameter("action").equals("Cancelar")) {
                reporteDeVacunacionFacade.findAll().stream().filter((r) -> (r.getIdCita().getCitaid()==cita.getCitaid())).forEach((r) -> {
                    reporteDeVacunacionFacade.remove(r);
                });
                citaFacade.remove(cita);

                out.println("<script type=\"text/javascript\">\n" + "  "
                        + "alert(\"Cita Cancelada Exitosamente\");\n"
                        + "window.location.href =" + "\"http://localhost:8080/VAcovid-war/menu.jsp\""
                        + "</script>");
            }

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
