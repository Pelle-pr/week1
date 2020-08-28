/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacadeTest;

import entity.Customer;
import facade.CustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Tha-Y
 */
    
public class CustomerFacadeTest {
   private static final EntityManagerFactory ENF = Persistence.createEntityManagerFactory("pu");
    private static final CustomerFacade EF = CustomerFacade.getCustomerFacade(ENF);
    
    public CustomerFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void findById(){
        
       Customer customer = EF.findByID(1);
       assertTrue(customer.getFirstName().equals("Peter"));
        
    }
    @Test
    public void findByLastName (){
        
        List<Customer> customerlist = EF.findByLastName("Rasmussen");
        assertTrue(customerlist.get(0).getLastName().equals("Rasmussen"));
    }
    @Test
    public void numberOfCustomers(){
       
        long result = EF.getNumberOfCustomers();
        assertTrue(result == 9);
    }
    
    @Test
     public void allCustomers(){
      
         List<Customer> customerlist = EF.allCustomer();
         
         assertTrue(customerlist.size() == 9);
     }
     
     @Test
     public void addCustomer (){
         
         
         EF.addCustomer("PelleTest", "Test");
         List <Customer> customerlist = EF.findByLastName("Test");
         assertTrue(customerlist.get(0).getLastName().equals("Test"));
         
         EF.deleteCustomer("PelleTest");
       
         
     }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
