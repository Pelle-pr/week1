package facades;

import entities.Employee;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeFacadeTest {
    private static final EntityManagerFactory ENF = Persistence.createEntityManagerFactory("pu");
    private static final EmployeeFacade EF = EmployeeFacade.getEmployeeFacade(ENF);
    public EmployeeFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
    @BeforeEach
    public void setUp() {
       
      
       
        }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    /**
     * Test a method here.
     */
    @Test
    public void getEmployeeById() {
        
        Employee e = EF.getEmployeeById(1);
       
        assertTrue(e.getName().equals("Pelle Rasmussen"));
    }
    
    @Test
    public void getEmployeesByName() {
        
        List<Employee> elist = EF.getEmployeesByName("Pelle Rasmussen");
        assertTrue(elist.get(0).getName().equals("Pelle Rasmussen"));
        
    }
    @Test
    public void getAllEmployess(){
        
        List<Employee> elist = EF.getAllEmployees();
        assertTrue(elist.size() == 5);
    }
    @Test
    public void getEmployeesWithHighestSalary(){
        
        List<Employee> elist = EF.getEmployeesWithHighestSalary();
        assertTrue(elist.get(0).getName().equals("John Snow"));
    }
    @Test
    public void addEmployee(){
        
        Employee e = new Employee("Test", "Testvej 12", new BigDecimal(400));
        EF.createEmployee(e);
        
        List<Employee> elist = EF.getEmployeesByName("Test");
        assertTrue(elist.get(0).getName().equals("Test"));
        
        EF.deleteEmployee("Test");
        
    }
    
}
