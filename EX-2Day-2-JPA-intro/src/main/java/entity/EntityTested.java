/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import facade.CustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tha-Y
 */
public class EntityTested {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//        Customer c1 = new Customer("James", "Bond");
//        Customer c2 = new Customer("Pelle", "Rasmussen");
//        Customer c3 = new Customer("Peter", "Henriksen");
//        Customer c4 = new Customer("Jeppe", "Madsen");
//        Customer c5 = new Customer("John", "Snow");
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
//        em.persist(c4);
//        em.persist(c5);
//        em.getTransaction().commit();
//        em.close();
        
        
        
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
       
        System.out.println(facade.findByID(1).toString());
        

        List<Customer> list = facade.findByLastName("Rasmussen");
        
        
        for (Customer customer : list) {
        
            System.out.println(customer.toString());
        }


        System.out.println("Antal customer " +facade.getNumberOfCustomers());

        List<Customer> allc = facade.allCustomer();

        for (Customer customer : allc) {
            System.out.println(customer.toString());

        }
        

       // facade.addCustomer("John", "Prut");

    }


}

