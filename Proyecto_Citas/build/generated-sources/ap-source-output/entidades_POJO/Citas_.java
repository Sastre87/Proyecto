package entidades_POJO;

import entidades_POJO.Historial;
import entidades_POJO.Tramites;
import entidades_POJO.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-12T10:43:20")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, String> fecha;
    public static volatile SingularAttribute<Citas, String> hora;
    public static volatile SingularAttribute<Citas, Boolean> llamado;
    public static volatile CollectionAttribute<Citas, Historial> historialCollection;
    public static volatile SingularAttribute<Citas, String> codigoCita;
    public static volatile SingularAttribute<Citas, Tramites> tipoTramite;
    public static volatile SingularAttribute<Citas, Usuario> dniUsuario;

}