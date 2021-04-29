/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.session;

import com.vacovid.entity.ReporteDeVacunacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JEFRY
 */
@Local
public interface ReporteDeVacunacionFacadeLocal {

    void create(ReporteDeVacunacion reporteDeVacunacion);

    void edit(ReporteDeVacunacion reporteDeVacunacion);

    void remove(ReporteDeVacunacion reporteDeVacunacion);

    ReporteDeVacunacion find(Object id);

    List<ReporteDeVacunacion> findAll();

    List<ReporteDeVacunacion> findRange(int[] range);

    int count();
    
}
