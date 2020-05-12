package entidades_POJO;

import entidades_POJO.Serie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-12T10:43:20")
@StaticMetamodel(Canal.class)
public class Canal_ { 

    public static volatile SingularAttribute<Canal, Integer> idCanal;
    public static volatile CollectionAttribute<Canal, Serie> serieCollection;
    public static volatile SingularAttribute<Canal, String> nombre;

}