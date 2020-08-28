package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.BankCustomerDTO;
import entities.BankCustomer;
import facades.FacadeCustomer;
import java.util.List;
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


@Path("bankcustomer")
public class BankCustomerResource {
    
    //NOTE: Change Persistence unit name according to your setup
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    FacadeCustomer facade =  FacadeCustomer.getCustomerFacade(emf);
   private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String GetAllCustomers() {
       
        List<BankCustomer> list = facade.getAllCustomer();
        
        return GSON.toJson(list);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getById(BankCustomer entity, @PathParam("id") int id) {
        
        BankCustomerDTO c = new BankCustomerDTO(facade.getCustomerById(id));
        
        return GSON.toJson(c);
    }
}
