/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.Estado;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

/**
 *
 * @author crisagui
 */
public class EstadoBean {
    
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
    
    public boolean crear(String nombre, Date fecha, String Observaciones){
        EntityTransaction tx = em.getTransaction();
        try{
            Estado estado = new Estado();
            estado.setNombre(nombre);
            estado.setFechaCreacion(fecha);
            estado.setObservaciones(Observaciones);
            tx.begin();
            em.persist(estado);
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
    
    
    public String buscar(int id){
        Estado estado;
        estado = em.find(Estado.class, id);
        if (estado != null){
            JOptionPane.showMessageDialog(null,estado.getNombre());
            return estado.getNombre();
        }else{
            JOptionPane.showMessageDialog(null, "El estado no se encontro");
            return null;
        }  
    }
    
    public boolean actualizar(int id, String nombre, Date fecha, String Observaciones){
        Estado estado = new Estado();
        estado = em.find(Estado.class, id);
        EntityTransaction tx = em.getTransaction();
        if(estado != null){
            try{
            estado.setNombre(nombre);
            estado.setFechaCreacion(fecha);
            estado.setObservaciones(Observaciones);
            
            tx.begin();
            em.merge(estado);
            tx.commit();
            return true;
            }finally{
                if(tx !=null){
                em.close();
            }
            }
        }else{
            JOptionPane.showMessageDialog(null,"El estado no se encontro para actualizar");
            return false;
        }
        
    }
    
    
    public boolean eliminar(int id){
        Estado estado;
        estado = em.find(Estado.class, id);
        if(estado != null){
            em.getTransaction().begin();
            em.remove(estado);
            em.getTransaction().commit();
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"El estado no se encontro para eliminarlo");
            return false;
        }
    }
    
}