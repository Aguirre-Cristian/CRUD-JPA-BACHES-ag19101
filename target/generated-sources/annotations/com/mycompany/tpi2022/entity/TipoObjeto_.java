package com.mycompany.tpi2022.entity;

import com.mycompany.tpi2022.entity.Objeto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-05T14:44:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoObjeto.class)
public class TipoObjeto_ { 

    public static volatile SingularAttribute<TipoObjeto, Integer> idTipoObjeto;
    public static volatile SingularAttribute<TipoObjeto, Date> fechaCreacion;
    public static volatile ListAttribute<TipoObjeto, Objeto> objetoList;
    public static volatile SingularAttribute<TipoObjeto, Boolean> activo;

}