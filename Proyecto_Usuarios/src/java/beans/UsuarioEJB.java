/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades_POJO.Citas;
import entidades_POJO.Tramites;
import entidades_POJO.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author jluis
 */
@Stateless
public class UsuarioEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public static Usuario usu;
    
    public boolean existeUsuario(Usuario u) {
        EntityManager em = emf.createEntityManager();
        Usuario encontrada = em.find(Usuario.class, u.getDni());
        em.close();
        return encontrada != null;
    }
    
    public Usuario findEmpleadoByDni (String dni){
        Query q = emf.createEntityManager().createNamedQuery("Usuario.findByDni");
        q.setParameter("dni", dni);
        List<Usuario> result = q.getResultList();
        if(result.isEmpty()){
            return null;
        }else{
           Iterator iter = result.iterator();
        Usuario u = (Usuario) iter.next();
        usu=u;
        return u; 
        } 
        
    }
    
    

    
    public Citas dameCita (String tramite){
      EntityManager em = emf.createEntityManager();
      Citas cita=new Citas();
      
      do{
      Tramites id=idCita(tramite);
      String fechaHora=obtenerfecha();
      String [] extraccion = fechaHora.split(" ");
      String fecha=extraccion [0];
      String hora=extraccion [1];   
      String codigo=random(id.getId());  
      
    
      cita=new Citas(codigo,usu,fecha,hora,false,id) ;
      }while(existeCita(cita));
       
     
      return cita;
   
    }    
    
     public void insertarCita(Citas c){
           EntityManager em = emf.createEntityManager();  
           em.persist(c);
           em.close();
           
           
           
       }
 
    public String obtenerfecha(){
         DateFormat fechaHora= new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
         Date date =new Date();
         
         String dato =fechaHora.format(date);
         return dato;
         
     }
    
        public  Tramites idCita(String tramite){
          int id;
        if(tramite.equalsIgnoreCase("alta")){
           
          id=1;  
        }
        else if(tramite.equalsIgnoreCase("baja"))
        {
          id=2; 
        }
        else if(tramite.equalsIgnoreCase("suspensión"))
        {    
            id=3;
        }
        else {
            id=4;
        }
        Tramites t=new Tramites(id);
        return t;
    }
        
        public String random(int id){
           
        String codigo;
        Random aleatorio = new Random();
        int ale=aleatorio.nextInt(1000);
            if(id==1){
                
              codigo="ALT";  
              codigo=codigo+ale;
              
            }
            
            else if(id==2){
                 codigo="BAJ"; 
                 codigo=codigo+ale;
            }
            
             else if(id==3){
                
              codigo="SUS"; 
              codigo=codigo+ale;
            }
             else{
                 codigo="SUP"; 
                  codigo=codigo+ale;
            }

            return codigo;
        }
        
        
       public boolean existeCita(Citas c) {
        EntityManager em = emf.createEntityManager();
        Citas encontrada = em.find(Citas.class, c.getCodigoCita());
        em.close();
        return encontrada != null;
    }
       
       public void nuevoUsuario(Usuario u){
           EntityManager em = emf.createEntityManager();  
           em.persist(u);
           em.close();
           
           
           
       }
        
}