/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.InventarioDeVacunacion;
import com.vacovid.entity.SitioVacunacion;
import com.vacovid.entity.Vacuna;
import com.vacovid.session.DistribuidorFacadeLocal;
import com.vacovid.session.InventarioDeVacunacionFacadeLocal;
import com.vacovid.session.RepresentanteFacadeLocal;
import com.vacovid.session.SitioVacunacionFacadeLocal;
import com.vacovid.session.VacunaFacadeLocal;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFRY
 */
@WebServlet(name = "IngresarVacunasRecibidas", urlPatterns = {"/IngresarVacunasRecibidas"})
public class IngresarVacunasRecibidas extends HttpServlet {

    @EJB
    private DistribuidorFacadeLocal distribuidorFacade;

    @EJB
    private RepresentanteFacadeLocal representanteFacade;

    @EJB
    private VacunaFacadeLocal vacunaFacade;

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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession objsession = request.getSession(false);
            String usuario1 = (String) objsession.getAttribute("usuario1");
            int representante = Integer.parseInt(usuario1);
            
            int idinventario= Integer.parseInt(request.getParameter("idinventario"));
            int idvacuna= Integer.parseInt(request.getParameter("idvacuna"));
            String nombre= request.getParameter("nombre");
            int identificacionDistribuidor=Integer.parseInt(request.getParameter("identificacionDistribuidor"));
            
            String fecha = request.getParameter("fecha");
            DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date date= df.parse(fecha);
            
            int cantidad= Integer.parseInt(request.getParameter("cantidad"));
            int lote= Integer.parseInt(request.getParameter("lote"));
            
            if (inventarioDeVacunacionFacade.find(idinventario)!=null) 
            {
                out.println("<script type=\"text/javascript\">\n" + "  alert(\"El ID de inventario ya está en uso\");\n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/ingresarVacunasRecibidas.jsp\" />");
            }
            if (vacunaFacade.find(idvacuna)!=null) 
            {
                out.println("<script type=\"text/javascript\">\n" + "  alert(\"El ID de vacuna ya está en uso\");\n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/ingresarVacunasRecibidas.jsp\" />");
            }
            
            SitioVacunacion sv=null;
            for (SitioVacunacion sitio : representanteFacade.find(representante).getSitioVacunacionCollection()) 
            {
                sv=sitio;
            }
            
            if (request.getParameter("action").equals("Registrar")) 
            {
                InventarioDeVacunacion inventario = new InventarioDeVacunacion(distribuidorFacade.find(identificacionDistribuidor),idinventario, cantidad, lote, sv);
                inventarioDeVacunacionFacade.create(inventario);

                Vacuna vacuna = new Vacuna(idvacuna, nombre, date, inventario);
                vacunaFacade.create(vacuna);
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IngresarVacunasRecibidas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IngresarVacunasRecibidas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(IngresarVacunasRecibidas.class.getName()).log(Level.SEVERE, null, ex);
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
