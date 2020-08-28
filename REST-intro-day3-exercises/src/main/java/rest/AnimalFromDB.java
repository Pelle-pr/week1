/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import entity.Animal;
import java.util.List;
import java.util.Random;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Tha-Y
 */
@Path("animals_db")
public class AnimalFromDB {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalFromDB
     */
    public AnimalFromDB() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalFromDB
     *
     * @return an instance of java.lang.String
     */
    @Path("animals")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimals() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            return new Gson().toJson(animals);

        } finally {
            em.close();
        }

    }

    @Path("animalbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getbyID(@PathParam("id") long id) {
        EntityManager em = emf.createEntityManager();

        try {
            Animal animal = em.find(Animal.class, id);

            if (animal == null) {
                return "No animals with that ID";
            } else {
                return new Gson().toJson(animal);
            }

        } finally {
            em.close();

        }
    }

    @Path("animalbytype/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getbyType(@PathParam("type") String type) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Animal> q = em.createQuery("SELECT a FROM Animal a WHERE a.type = ?1", Animal.class);
            q.setParameter(1, type);
            List<Animal> list = q.getResultList();

            if (list.size() == 0) {
                return "No animals with that Type";
            } else {
                return new Gson().toJson(list);
            }

        } finally {
            em.close();

        }
    }

    @Path("random_animal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String randomAnimal() {
        EntityManager em = emf.createEntityManager();
        int max = 10;
        int min = 0;
        Random rn = new Random();

        long randomNumber = rn.nextInt(max - min + 1) + 1;
        try {
            Animal animal = em.find(Animal.class, randomNumber);

            if (animal == null) {
                return "No animals with that ID";
            } else {
                return new Gson().toJson(animal);
            }

        } finally {
            em.close();

        }

    }

}

/**
 * PUT method for updating or creating an instance of AnimalFromDB
 *
 * @param content representation for the resource
 */
