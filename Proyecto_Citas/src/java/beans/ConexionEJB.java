
package beans;

import entidades_POJO.Empleado;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Eric
 */
@Stateless
public class ConexionEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public static Empleado em;
    
    public boolean existeEmpleado(Empleado e) {
        EntityManager em = emf.createEntityManager();
        Empleado encontrada = em.find(Empleado.class, e.getDni());
        em.close();
        return encontrada != null;
    }
    
    public Empleado findEmpleadoByDni (String dni){
        Query q = emf.createEntityManager().createNamedQuery("Empleado.findByDni");
        q.setParameter("dni", dni);
        List<Empleado> result = q.getResultList();
        if(result.isEmpty()){
            return null;
        }else{
           Iterator iter = result.iterator();
        Empleado e = (Empleado) iter.next();
        return e; 
        } 
        
    }
}
