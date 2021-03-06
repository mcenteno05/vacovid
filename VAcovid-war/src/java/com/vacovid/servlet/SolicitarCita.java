/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.Cita;
import com.vacovid.entity.SitioVacunacion;
import com.vacovid.session.CitaFacadeLocal;
import com.vacovid.session.SitioVacunacionFacadeLocal;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFRY
 */
@WebServlet(name = "SolicitarCita", urlPatterns = {"/SolicitarCita"})
public class SolicitarCita extends HttpServlet {

    @EJB
    private SitioVacunacionFacadeLocal sitioVacunacionFacade;

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession objsession = request.getSession(false);
            String usuario = (String)objsession.getAttribute("usuario1");
            
            Integer dosis = Integer.parseInt(request.getParameter("dosis"));
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String entidad = request.getParameter("entidad");
            int sitio = Integer.parseInt(request.getParameter("sitio"));
            DateFormat df= new SimpleDateFormat("yyyy-MM-ddHH:mm");
            Date date= df.parse(fecha+hora);
            int count=0,c=0,compPD=0;
            
            for (Cita cita : citaFacade.findAll()) 
            {
                if (cita.getIdentificacionUsuario().getIdentificacion()==Integer.parseInt(usuario)) 
                {
                    if (cita.getDosis()==dosis) 
                    {
                        out.println("<script type=\"text/javascript\">\n" + "  alert(\"Cita ya asignada\");\n" + "</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/solicitarCita.jsp\" />");
                        c=1;
                        break;
                    }
                    compPD=1;
                }
            }
            
            //Comprueba si antes tuvo una primera dosis
            if (compPD==0 && dosis==2) 
            {
                out.println("<script type=\"text/javascript\">\n" + "  "
                                + "alert(\"Tiene que solicitar primera dosis\");\n"
                                + "window.location.href =" + "\"http://localhost:8080/VAcovid-war/solicitarCita.jsp\"" +
                                "</script>");
            }
            else {
                if (c == 0) {
                    //verifica si existe el sitio de vacunacion
                    for (SitioVacunacion sitio1 : sitioVacunacionFacade.findAll()) {
                        if (sitio == sitio1.getSitioid()) {
                            count = 1;
                        }
                    }
                    //si el sitio existe crea la cita
                    if (count == 1) {
                        Cita cita = new Cita(dosis, hora, date, entidad, sitioVacunacionFacade.find(sitio), usuarioFacade.find(Integer.parseInt(usuario)));
                        citaFacade.create(cita);
                        out.println("<script type=\"text/javascript\">\n" + "  "
                                + "alert(\"Cita Agendada Exitosamente\");\n"
                                + "window.location.href =" + "\"http://localhost:8080/VAcovid-war/menu.jsp\""
                                + "</script>");
                    } //si el sitio no existe lo redirige a la pagina nuevamente
                    else {
                        out.println("<script type=\"text/javascript\">\n" + "  alert(\"El sitio de vacunacion no existe, por favor digite uno v??lido\");\n" + "</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/solicitarCita.jsp\" />");
                    }
                }

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SolicitarCita</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCita.class.getName()).log(Level.SEVERE, null, ex);
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
