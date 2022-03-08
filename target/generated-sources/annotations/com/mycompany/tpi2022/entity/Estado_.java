package com.mycompany.tpi2022.entity;

import com.mycompany.tpi2022.entity.ObjetoEstado;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-05T14:44:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> observaciones;
    public static volatile SingularAttribute<Estado, Date> fechaCreacion;
    public static volatile SingularAttribute<Estado, String> nombre;
    public static volatile ListAttribute<Estado, ObjetoEstado> objetoEstadoList;

}