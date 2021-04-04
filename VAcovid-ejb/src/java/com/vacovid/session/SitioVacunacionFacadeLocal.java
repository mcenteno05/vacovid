/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.session;

import com.vacovid.entity.SitioVacunacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JEFRY
 */
@Local
public interface SitioVacunacionFacadeLocal {

    void create(SitioVacunacion sitioVacunacion);

    void edit(SitioVacunacion sitioVacunacion);

    void remove(SitioVacunacion sitioVacunacion);

    SitioVacunacion find(Object id);

    List<SitioVacunacion> findAll();

    List<SitioVacunacion> findRange(int[] range);

    int count();
    
}
