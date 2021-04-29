/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.session;

import com.vacovid.entity.ReporteDeVacunacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JEFRY
 */
@Stateless
public class ReporteDeVacunacionFacade extends AbstractFacade<ReporteDeVacunacion> implements ReporteDeVacunacionFacadeLocal {

    @PersistenceContext(unitName = "vacovidPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteDeVacunacionFacade() {
        super(ReporteDeVacunacion.class);
    }
    
}
