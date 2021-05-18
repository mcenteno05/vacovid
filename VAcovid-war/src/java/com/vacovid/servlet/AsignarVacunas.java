/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.servlet;

import com.vacovid.entity.InventarioDeVacunacion;
import com.vacovid.entity.SitioVacunacion;
import com.vacovid.entity.Vacuna;
import com.vacovid.entity.VacunaRecibida;
import com.vacovid.session.InventarioDeVacunacionFacadeLocal;
import com.vacovid.session.InventarioNacionalFacadeLocal;
import com.vacovid.session.SitioVacunacionFacadeLocal;
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
    private InventarioNacionalFacadeLocal inventarioNacionalFacade;

    @EJB
    private SitioVacunacionFacadeLocal sitioVacunacionFacade;

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
            int idvacuna = Integer.parseInt(request.getParameter("vacuna"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            if (cantidad > 0) {
                if (request.getParameter("action").equals("Asignar vacunas")) {

                    int count = 0, c = 0;
                    VacunaRecibida vacunarecibida = null;
                    Vacuna vacuna = vacunaFacade.find(idvacuna);
                    InventarioDeVacunacion inventario;
                    SitioVacunacion sitio = sitioVacunacionFacade.find(idSitio);
                    boolean cantidadIncorrecta=true;
                    
                    //busca los inventarios existentes
                    for (InventarioDeVacunacion ob : sitio.getInventarioDeVacunacionCollection()) {
                        
                        //Compara los id de sitio con el seleccionado
                        if (ob.getIdSitio().getSitioid() == idSitio) {
                            inventario = inventarioDeVacunacionFacade.find(ob.getInventarioid());
                        
                            //Verifica que las cantidades sean menores o iguales a las existentes en el inventario nacional
                            if (vacuna.getCantidad() >= cantidad) {
                                //Busca las vacunas actuales
                                for (VacunaRecibida v : ob.getVacunaRecibidaCollection()) {
                                    //Si las vacuna tiene el mismo nombre, fecha y lote se sobreescribe la cantidad actual    
                                    if (v.getNombre().equals(vacuna.getNombre()) && v.getFechaDeVencimiento().equals(vacuna.getFechaDeVencimiento()) && v.getLote() == vacuna.getLote()) {
                                        v.setCantidad(v.getCantidad() + cantidad);
                                        vacunaRecibidaFacade.edit(v);
                                        c = 1;
                                        break;
                                    }
                                }
                                vacunarecibida = new VacunaRecibida(vacuna.getNombre(), vacuna.getFechaDeVencimiento(), cantidad, vacuna.getLote(), inventario);
                                vacuna.setCantidad(vacuna.getCantidad() - cantidad);
                                count = 1;
                                break;
                            } else {
                                out.println("<script type=\"text/javascript\">\n" + "  alert(\"La cantidad de vacunas asignadas son mayores a las ya existentes en el inventario nacional,"
                                        + " por favor digite una nueva cantidad valida\" ); \n" + "</script>");
                                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/asignarVacunas.jsp\" />");
                                cantidadIncorrecta=false;
                                break;
                            }
                        }
                    }
                    //Esto sucede cuando no encuentra un inventario asociado al sitio de vacunacion seleccionado por tanto se le crea uno
                    if (count == 0) {
                       
                        if (vacuna.getCantidad() >= cantidad) {
                            inventario = new InventarioDeVacunacion(inventarioNacionalFacade.find(1), sitio);
                            inventarioDeVacunacionFacade.create(inventario);
                            vacunarecibida = new VacunaRecibida(vacuna.getNombre(), vacuna.getFechaDeVencimiento(), cantidad, vacuna.getLote(), inventario);
                            vacuna.setCantidad(vacuna.getCantidad() - cantidad);
                        } else {
                            if (cantidadIncorrecta) 
                            {
                                out.println("<script type=\"text/javascript\">\n" + "  alert(\"La cantidad de vacunas asignadas son mayores a las ya existentes en el inventario nacional,"
                                    + " por favor digite una nueva cantidad valida\" ); \n" + "</script>");
                                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/asignarVacunas.jsp\" />");
                            }
                            
                        }
                    }
                    //
                    if (c == 0) {
                        vacunaRecibidaFacade.create(vacunarecibida);
                    }
                    vacunaFacade.edit(vacuna);
                }
            } else {
                out.println("<script type=\"text/javascript\">\n" + "  alert(\"La Cantidad de vacunas debe ser mayor a 0, por favor digite una cantidad valida\" ); \n" + "</script>");
                out.println("<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/VAcovid-war/asignarVacunas.jsp\" />");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">\n" + "  alert(\" Vacunas asignadas correctamente\" ); \n" + "</script>");
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
