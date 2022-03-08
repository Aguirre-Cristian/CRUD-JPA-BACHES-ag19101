package com.mycompany.tpi2022.entity;

import com.mycompany.tpi2022.entity.ObjetoEstado;
import com.mycompany.tpi2022.entity.TipoObjeto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-05T14:44:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Objeto.class)
public class Objeto_ { 

    public static volatile SingularAttribute<Objeto, BigDecimal> longitud;
    public static volatile SingularAttribute<Objeto, BigDecimal> latitud;
    public static volatile SingularAttribute<Objeto, TipoObjeto> idTipoObjeto;
    public static volatile SingularAttribute<Objeto, Long> idObjeto;
    public static volatile SingularAttribute<Objeto, String> observaciones;
    public static volatile SingularAttribute<Objeto, String> nombre;
    public static volatile ListAttribute<Objeto, ObjetoEstado> objetoEstadoList;

}