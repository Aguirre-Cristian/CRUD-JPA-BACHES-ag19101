/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpi2022.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author crisagui
 */
@Entity
@Table(name = "objeto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Objeto.findAll", query = "SELECT o FROM Objeto o"),
    @NamedQuery(name = "Objeto.findByIdObjeto", query = "SELECT o FROM Objeto o WHERE o.idObjeto = :idObjeto"),
    @NamedQuery(name = "Objeto.findByLongitud", query = "SELECT o FROM Objeto o WHERE o.longitud = :longitud"),
    @NamedQuery(name = "Objeto.findByLatitud", query = "SELECT o FROM Objeto o WHERE o.latitud = :latitud"),
    @NamedQuery(name = "Objeto.findByNombre", query = "SELECT o FROM Objeto o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Objeto.findByObservaciones", query = "SELECT o FROM Objeto o WHERE o.observaciones = :observaciones")})
public class Objeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_objeto", nullable = false)
    private Long idObjeto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud", precision = 8, scale = 6)
    private BigDecimal longitud;
    @Column(name = "latitud", precision = 9, scale = 6)
    private BigDecimal latitud;
    @Column(name = "nombre", length = 155)
    private String nombre;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_tipo_objeto", referencedColumnName = "id_tipo_objeto")
    @ManyToOne
    private TipoObjeto idTipoObjeto;
    @OneToMany(mappedBy = "idObjeto")
    private List<ObjetoEstado> objetoEstadoList;

    public Objeto() {
    }

    public Objeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Long getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TipoObjeto getIdTipoObjeto() {
        return idTipoObjeto;
    }

    public void setIdTipoObjeto(TipoObjeto idTipoObjeto) {
        this.idTipoObjeto = idTipoObjeto;
    }

    public List<ObjetoEstado> getObjetoEstadoList() {
        return objetoEstadoList;
    }

    public void setObjetoEstadoList(List<ObjetoEstado> objetoEstadoList) {
        this.objetoEstadoList = objetoEstadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObjeto != null ? idObjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objeto)) {
            return false;
        }
        Objeto other = (Objeto) object;
        if ((this.idObjeto == null && other.idObjeto != null) || (this.idObjeto != null && !this.idObjeto.equals(other.idObjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tpi2022.entity.Objeto[ idObjeto=" + idObjeto + " ]";
    }

    public void setFechaCreacion(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdTipoObjeto(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdTipoObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
