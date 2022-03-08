/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.TipoObjeto;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author crisagui
 */
public class tipoObjetoBean {
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
    
        public void crear(boolean estado, Date fecha) {
        TipoObjeto tipo_objeto = new TipoObjeto();

        tipo_objeto.setActivo(estado);
        tipo_objeto.setFechaCreacion(fecha);

        em.getTransaction().begin();
        em.persist(tipo_objeto);
        em.getTransaction().commit();

    }

    public void buscar(Integer id) {
        TipoObjeto tipo_objeto = new TipoObjeto();

        tipo_objeto = em.find(TipoObjeto.class, id);
        if (tipo_objeto != null) {
            System.out.println(tipo_objeto);
        } else {
            System.out.println("No se encontro el registro");
        }
    }

    public void actualizar(Integer id, boolean estado, Date fecha) {
        TipoObjeto tipo_objeto = new TipoObjeto();
        tipo_objeto = em.find(TipoObjeto.class, id);

        if (tipo_objeto != null) {
            tipo_objeto.setActivo(estado);
            tipo_objeto.setFechaCreacion(fecha);

            em.getTransaction().begin();
            em.persist(tipo_objeto);
            em.getTransaction().commit();

        } else {
            System.out.println("No se encontro el registro a actualizar");
        }

    }

    public void eliminar(Integer id) {
        TipoObjeto tipo_objeto = new TipoObjeto();
        tipo_objeto = em.find(TipoObjeto.class, id);

        if (tipo_objeto != null) {
            em.getTransaction().begin();
            em.remove(tipo_objeto);
            em.getTransaction().commit();
        } else {
            System.out.println("No se encontro el registro a elminar");
        }
    }
        
}
