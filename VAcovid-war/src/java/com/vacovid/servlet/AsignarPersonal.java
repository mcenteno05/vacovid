/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.ReporteDeVacunacion;
import com.vacovid.session.CitaFacadeLocal;
import com.vacovid.session.PersonalFacadeLocal;
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
@WebServlet(name = "AsignarPersonal", urlPatterns = {"/AsignarPersonal"})
public class AsignarPersonal extends HttpServlet {

    @EJB
    private PersonalFacadeLocal personalFacade;

    @EJB
    private CitaFacadeLocal citaFacade;

    @EJB
    private ReporteDeVacunacionFacadeLocal reporteDeVacunacionFacade;

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
            String usuario = (String)objsession.getAttribute("usuario1");
            
            Integer paciente = Integer.parseInt(request.getParameter("paciente"));
            Integer personal = Integer.parseInt(request.getParameter("personal"));
            
            if (request.getParameter("action").equals("Asignar")) 
            {
                ReporteDeVacunacion rp= new ReporteDeVacunacion(citaFacade.find(paciente), personalFacade.find(personal));
                int c=0;
                
                for (ReporteDeVacunacion r : reporteDeVacunacionFacade.findAll()) 
                {
                    if (r.getIdCita().getCitaid()==paciente) 
                    {
                        c=1;
                        out.println("<script type=\"text/javascript\">\n" + "  alert(\"El paciente ya tiene un personal asignado\");\n" + "</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/asignarPersonal.jsp\" />");
                        break;
                    }
                    if (Integer.parseInt(r.getIdCita().getHora().split(":")[0])==Integer.parseInt(citaFacade.find(paciente).getHora().split(":")[0])
                       && Math.abs(Integer.parseInt(r.getIdCita().getHora().split(":")[1]))-Integer.parseInt(citaFacade.find(paciente).getHora().split(":")[1])>=30) 
                    {
                        c=1;
                        out.println("<script type=\"text/javascript\">\n" + "  alert(\"Hora no válida\");\n" + "</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/asignarPersonal.jsp\" />");
                        break;
                    }
                }
                if(c==0)
                {
                    reporteDeVacunacionFacade.create(rp);
                    out.print("Personal asignado correctamente");
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsignarPersonal</title>");            
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
