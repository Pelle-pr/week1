package facades;

import dto.BankCustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeCustomer {

    private static FacadeCustomer instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeCustomer() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeCustomer getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeCustomer();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
 

   

    public BankCustomer getCustomerById(int id) {
        EntityManager em = emf.createEntityManager();

        BankCustomer c1 = em.find(BankCustomer.class, id);

        return c1;
    }

    public List<BankCustomer> getCustomerByName(String name) {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select b From BankCustomer b Where b.firstName = :name");
        query.setParameter("name", name);
        List<BankCustomer> clist = query.getResultList();
        return clist;

    }

    public List<BankCustomer> getAllCustomer() {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select b From BankCustomer b");
        List<BankCustomer> clist = query.getResultList();
        return clist;
    }

   

    public void addCustomer(BankCustomer c) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    public BankCustomerDTO DTOgetCustomerByID(int id){
        
        BankCustomerDTO c = new BankCustomerDTO(FacadeCustomer.instance.getCustomerById(id));
        
        return c;
        
    }
    
    public List<BankCustomerDTO> DTOgetCustomerByName(String name) {
        
        List<BankCustomer> list = FacadeCustomer.instance.getCustomerByName(name);
        List<BankCustomerDTO> dtolist = new ArrayList<>();
        
        for (BankCustomer bankCustomer : list) {
            dtolist.add(new BankCustomerDTO(bankCustomer));
            
        }
        return dtolist;
        
    }


}
