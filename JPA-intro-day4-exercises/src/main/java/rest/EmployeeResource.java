package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.New;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class EmployeeResource {
    
    //NOTE: Change Persistence unit name according to your setup
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    EmployeeFacade facade =  EmployeeFacade.getEmployeeFacade(emf);
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Path("/all")
    @GET
     @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmployees() {
        
       
        List<EmployeeDTO> list = new ArrayList<>();
        
        List<Employee> elist = facade.getAllEmployees();
        
        for (Employee employee : elist) {
            list.add(new EmployeeDTO(employee));
            
        }
       
       
        
        return GSON.toJson(list);
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByID(@PathParam("id") int id ){
        
      
        EmployeeDTO e = new EmployeeDTO(facade.getEmployeeById(id));
        
        return GSON.toJson(e);
        
    }
    
    @Path("/highestpaid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestPaid (){
        
        List<EmployeeDTO> edtolist = new ArrayList<>();
        
        List<Employee> elist = facade.getEmployeesWithHighestSalary();
        
        for (Employee employee : elist) {
            edtolist.add(new EmployeeDTO(employee));
            
            
        }
        return GSON.toJson(edtolist);
        
    }
    
    @Path("/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByName (@PathParam("name") String name){
        
        List<EmployeeDTO> edtolist = new ArrayList<>();
        
        List<Employee> elist = facade.getEmployeesByName(name);
        
        for (Employee employee : elist) {
            edtolist.add(new EmployeeDTO(employee));
            
            
        }
        return GSON.toJson(edtolist);
        
    }
    

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Employee entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
