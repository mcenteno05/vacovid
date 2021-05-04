/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.session;

import com.vacovid.entity.VacunaRecibida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JEFRY
 */
@Local
public interface VacunaRecibidaFacadeLocal {

    void create(VacunaRecibida vacunaRecibida);

    void edit(VacunaRecibida vacunaRecibida);

    void remove(VacunaRecibida vacunaRecibida);

    VacunaRecibida find(Object id);

    List<VacunaRecibida> findAll();

    List<VacunaRecibida> findRange(int[] range);

    int count();
    
}
