/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.session;

import com.vacovid.entity.InventarioDeVacunacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JEFRY
 */
@Local
public interface InventarioDeVacunacionFacadeLocal {

    void create(InventarioDeVacunacion inventarioDeVacunacion);

    void edit(InventarioDeVacunacion inventarioDeVacunacion);

    void remove(InventarioDeVacunacion inventarioDeVacunacion);

    InventarioDeVacunacion find(Object id);

    List<InventarioDeVacunacion> findAll();

    List<InventarioDeVacunacion> findRange(int[] range);

    int count();
    
}
