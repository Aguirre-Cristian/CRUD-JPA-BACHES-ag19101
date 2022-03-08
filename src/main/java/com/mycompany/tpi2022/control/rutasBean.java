/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.Ruta;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

/**
 *
 * @author crisagui
 */
public class rutasBean {
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
    
    public boolean crear(Ruta ruta){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(ruta);
            tx.commit();
            return true;
        }catch(Exception ex){
            tx.rollback();
        }finally{ 
            if(tx !=null){
                em.close();
            }
        }
        return false;
    }
    
    
    public Ruta buscar(Long id) {
        Ruta ruta;
        try {
            ruta= em.find(Ruta.class, id);
            JOptionPane.showMessageDialog(null, ruta.getNombre());
            return ruta;
        } finally {
            em.close();
        }
    }
    
     public void actualizar(Long id, String nombre, Date fecha, String observaciones) {
        Ruta ruta = new Ruta();
        ruta = em.find(Ruta.class, id);

        if (ruta != null) {

            ruta.setNombre(nombre);
            ruta.setFechaCreacion(fecha);
            ruta.setObservaciones(observaciones);

            em.getTransaction().begin();
            em.persist(ruta);
            em.getTransaction().commit();
        } else {
            System.out.println("No se encontro el registro a eliminar");
        }
    }
 
    public boolean eliminar(Long id){
        try {
            em.getTransaction().begin();
            Ruta ruta;
                ruta = em.getReference(Ruta.class, id);
                ruta.getIdRuta();
            if(ruta !=null){
            em.remove(ruta);
            em.getTransaction().commit();
            }else{
            JOptionPane.showMessageDialog(null,"El estado no se encontro para eliminarlo");
            return false;
            }
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return false;
    }
    
}
