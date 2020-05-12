package entidades_POJO;

import entidades_POJO.Citas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-12T11:11:49")
@StaticMetamodel(Tramites.class)
public class Tramites_ { 

    public static volatile SingularAttribute<Tramites, String> nombreTramite;
    public static volatile CollectionAttribute<Tramites, Citas> citasCollection;
    public static volatile SingularAttribute<Tramites, Integer> id;

}