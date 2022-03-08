package com.mycompany.tpi2022.entity;

import com.mycompany.tpi2022.entity.Estado;
import com.mycompany.tpi2022.entity.Objeto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-05T14:44:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ObjetoEstado.class)
public class ObjetoEstado_ { 

    public static volatile SingularAttribute<ObjetoEstado, Boolean> actual;
    public static volatile SingularAttribute<ObjetoEstado, Estado> idEstado;
    public static volatile SingularAttribute<ObjetoEstado, Objeto> idObjeto;
    public static volatile SingularAttribute<ObjetoEstado, Long> idObjetoEstado;
    public static volatile SingularAttribute<ObjetoEstado, String> observaciones;
    public static volatile SingularAttribute<ObjetoEstado, Date> fechaAlcanzado;

}