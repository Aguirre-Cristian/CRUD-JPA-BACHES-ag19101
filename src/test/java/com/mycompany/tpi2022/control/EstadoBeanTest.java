/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.control;

import com.mycompany.tpi2022.entity.Estado;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author crisagui
 */
public class EstadoBeanTest {
    
    public EstadoBeanTest() {
    }

    /**
     * Test of crear method, of class EstadoBean.
     */
    EntityManager em = control_persistencia.getEntityManagerFactory().createEntityManager();
   
     @Test
    public void testCrear() {
        System.out.println("crear");
        String nombre = "libertdd";
        Date fecha = new Date();
        String Observaciones = "grandes baches";
        EstadoBean instance = new EstadoBean();
        boolean result=instance.crear(nombre, fecha, Observaciones);
        assertTrue(result);
    }
    /**
     * Test of buscar method, of class EstadoBean.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 6;
        Estado estado = new Estado();
        estado = em.find(Estado.class, id);
        EstadoBean instance = new EstadoBean();
        String resultado=instance.buscar(id);
        assertEquals(estado.getNombre(),resultado);
    }

    /**
     * Test of actualizar method, of class EstadoBean.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        int id = 3;
        String nombre = "sonsonate";
        Date fecha = new Date();
        String Observaciones = "modificado";
        EstadoBean instance = new EstadoBean();
        boolean restd=instance.actualizar(id, nombre, fecha, Observaciones);
        assertTrue(restd);
    }

    /**
     * Test of eliminar method, of class EstadoBean.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 6;
        EstadoBean instance = new EstadoBean();
        instance.eliminar(id);
        assertTrue(instance.buscar(id)==null);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
