package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();

        Employee emp = em.find(Employee.class, id);

        return emp;
    }

    public List<Employee> getEmployeesByName(String name) {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select e From Employee e Where e.name = :id");
        query.setParameter("id", name);
        List<Employee> elist = query.getResultList();
        return elist;

    }

    public List<Employee> getAllEmployees() {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select e From Employee e");
        List<Employee> emplist = query.getResultList();
        return emplist;
    }

    public List<Employee> getEmployeesWithHighestSalary() {

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select e from Employee e Where e.Salary = (Select MAX(e.Salary) From Employee e)");
        List<Employee> list = q.getResultList();
        return list;

    }

    public void createEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
     public void deleteEmployee (String s){
         
         EntityManager em = emf.createEntityManager();
         
         try{
             em.getTransaction().begin();
             Query q = em.createQuery("Delete from Employee e Where e.name = :name");
             q.setParameter("name", s);
             q.executeUpdate();
             em.getTransaction().commit();
        }finally {
             em.close();
         }

     }

}
