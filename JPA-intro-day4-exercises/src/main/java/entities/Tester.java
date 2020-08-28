/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tha-Y
 */
public class Tester {
    
    public static void main(String[] args) {
        
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
//        Employee e1 = new Employee("Pelle Rasmussen", "Smedeløkken 66", new BigDecimal (50000));
//        Employee e2 = new Employee("Johan Madsen", "Rønnevej 55", new BigDecimal (40000));
//        Employee e3 = new Employee("Lola Hansen", "Tejnvej 12", new BigDecimal (25000));
//        Employee e4 = new Employee("John Snow", "Lille Madsegade 64", new BigDecimal (65000));
//        Employee e5 = new Employee("Mari Haugen", "Nexøvej 52", new BigDecimal (10000));
//        
//        try{
//            
//            em.getTransaction().begin();
//            em.persist(e1);
//            em.persist(e2);
//            em.persist(e3);
//            em.persist(e4);
//            em.persist(e5);
//            em.getTransaction().commit();
//        } finally{
//            em.close();
//        }
    }
    
    
}
