/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.Estado;
import com.mycompany.tpi2022.entity.Objeto;
import com.mycompany.tpi2022.entity.ObjetoEstado;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author crisagui
 */
public class objetoEstadoBean {
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
    
    public void crear(Integer id_estado, Long id_objeto, boolean actual, Date fecha, String observaciones) {

        Estado estado = new Estado();
        Objeto objeto = new Objeto();
        ObjetoEstado obj_estado = new ObjetoEstado();

        estado = em.find(Estado.class, id_estado);
        objeto = em.find(Objeto.class, id_objeto);

        if (estado != null && objeto != null) {

            obj_estado.setIdObjeto(objeto);
            obj_estado.setIdEstado(estado);
            obj_estado.setActual(actual);
            obj_estado.setFechaAlcanzado(fecha);
            obj_estado.setObservaciones(observaciones);

            em.getTransaction().begin();
            em.persist(obj_estado);
            em.getTransaction().commit();

        } else {
            System.out.println("ERROR INESPERADO!!");
        }

    }
    
    
    public Long buscar(int id){
        ObjetoEstado objeto;
        objeto = em.find(ObjetoEstado.class, id);
        if (objeto != null){
            JOptionPane.showMessageDialog(null,objeto.getIdObjetoEstado());
            return objeto.getIdObjetoEstado();
        }else{
            JOptionPane.showMessageDialog(null, "El estado no se encontro");
            return null;
        }  
    }
    
   public void actualizar(Long id, Integer id_estado, Long id_objeto, boolean actual, Date fecha, String observaciones) {
        ObjetoEstado obj_estado = new ObjetoEstado();
        obj_estado = em.find(ObjetoEstado.class, id);

        if (obj_estado != null) {
            
            Estado estado = new Estado();
            Objeto objeto = new Objeto();

            estado = em.find(Estado.class, id_estado);
            objeto = em.find(Objeto.class, id_objeto);

            if (estado != null && objeto != null) {

                obj_estado.setIdObjeto(objeto);
                obj_estado.setIdEstado(estado);
                obj_estado.setActual(actual);
                obj_estado.setFechaAlcanzado(fecha);
                obj_estado.setObservaciones(observaciones);

                em.getTransaction().begin();
                em.persist(obj_estado);
                em.getTransaction().commit();

            } else {
                System.out.println("Algo salio mal");
            }
        } else {
            System.out.println("No se emcontro el registro a actualizar");
        }
    }
    
    
    public void Eliminar(Long id){
        try {
            em.getTransaction().begin();
            ObjetoEstado objetoEstado;
                objetoEstado = em.getReference(ObjetoEstado.class, id);
                objetoEstado.getIdObjetoEstado();
            
            Estado idEstado = objetoEstado.getIdEstado();
            if (idEstado != null) {
                idEstado.getObjetoEstadoList().remove(objetoEstado);
                idEstado = em.merge(idEstado);
            }
            Objeto idObjeto = objetoEstado.getIdObjeto();
            if (idObjeto != null) {
                idObjeto.getObjetoEstadoList().remove(objetoEstado);
                idObjeto = em.merge(idObjeto);
            }
            em.remove(objetoEstado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
