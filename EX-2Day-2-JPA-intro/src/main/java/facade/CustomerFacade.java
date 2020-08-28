package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tha-Y
 */
public class CustomerFacade {
    
    
  
    
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {}

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
    public Customer findByID(int id){
        
        EntityManager em = emf.createEntityManager();
        
        try{
            Customer customer = em.find(Customer.class, id);
            return customer;
            
        }finally{
            em.close();
        }
    }
    
    public List<Customer> findByLastName (String name){
        
        
       EntityManager em = emf.createEntityManager();
      
       try{
           TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c WHERE c.lastName = ?1", Customer.class);
           q.setParameter(1, name);
           return q.getResultList();
           
           
       }finally{
           em.close();
       }
    }
    
    public long getNumberOfCustomers(){
        
        EntityManager em = emf.createEntityManager();
        
        try{
            Query q = em.createQuery("Select Count(c) from Customer c");
           Long result = (long) q.getSingleResult();
            return result;
        }finally{
            em.close();
        }
    }
    
     public List<Customer> allCustomer(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
     
     public void addCustomer (String firstName, String lastName){
         
         EntityManager em = emf.createEntityManager();
         Customer c = new Customer(firstName, lastName);
         try{
             em.getTransaction().begin();
             em.persist(c);
             em.getTransaction().commit();
            
             
         }finally {
             em.close();
         }
     }
     public void deleteCustomer (String s){
         
         EntityManager em = emf.createEntityManager();
         
         try{
             em.getTransaction().begin();
             Query q = em.createQuery("Delete from Customer c Where c.firstName = :firstname");
             q.setParameter("firstname", s);
             q.executeUpdate();
             em.getTransaction().commit();
        }finally {
             em.close();
         }

     }
    
}
