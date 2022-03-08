/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.Objeto;
import com.mycompany.tpi2022.entity.ObjetoEstado;
import com.mycompany.tpi2022.entity.TipoObjeto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author crisagui
 */
public class ObjetoBean {
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
    
       public void crear(Integer id_tipo_objeto, BigDecimal longitud, BigDecimal latitud, String nombre, String observaciones) {

        Objeto objeto = new Objeto();
        TipoObjeto tipo_objeto = new TipoObjeto();

        tipo_objeto = em.find(TipoObjeto.class, id_tipo_objeto);

        objeto.setIdTipoObjeto(tipo_objeto);
        objeto.setLongitud(longitud);
        objeto.setLatitud(latitud);
        objeto.setNombre(nombre);
        objeto.setObservaciones(observaciones);

        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }
    
    public String buscar(long id){
        Objeto objeto;
        objeto = em.find(Objeto.class, id);
        if (objeto != null){
            JOptionPane.showMessageDialog(null,objeto.getNombre());
            return objeto.getNombre();
        }else{
            JOptionPane.showMessageDialog(null, "El estado no se encontro");
            return null;
        }  
    }
    
    public void actualizar(Long id, Integer id_tipo_objeto, BigDecimal longitud, BigDecimal latitud, String nombre, String observaciones) {
        Objeto objeto = new Objeto();
        objeto = em.find(Objeto.class, id);

        if (objeto != null) {
            TipoObjeto tipo_objeto = new TipoObjeto();

            tipo_objeto = em.find(TipoObjeto.class, id_tipo_objeto);

            objeto.setIdTipoObjeto(tipo_objeto);
            objeto.setLongitud(longitud);
            objeto.setLatitud(latitud);
            objeto.setNombre(nombre);
            objeto.setObservaciones(observaciones);

            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } else {
            System.out.println("No se encontro el objeto que desea actualizar");
        }
    }
    
    public void eliminar(long id) {
        try {
            em.getTransaction().begin();
            Objeto objeto;
                objeto = em.getReference(Objeto.class, id);
                objeto.getIdObjeto();
            TipoObjeto idTipoObjeto = objeto.getIdTipoObjeto();
            if (idTipoObjeto != null) {
                idTipoObjeto.getObjetoList().remove(objeto);
                idTipoObjeto = em.merge(idTipoObjeto);
            }
            List<ObjetoEstado> objetoEstadoList = objeto.getObjetoEstadoList();
            for (ObjetoEstado objetoEstadoListObjetoEstado : objetoEstadoList) {
                objetoEstadoListObjetoEstado.setIdObjeto(null);
                objetoEstadoListObjetoEstado = em.merge(objetoEstadoListObjetoEstado);
            }
            em.remove(objeto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
