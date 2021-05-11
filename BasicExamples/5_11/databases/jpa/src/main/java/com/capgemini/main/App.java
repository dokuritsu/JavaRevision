package com.capgemini.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.entity.Employee;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // Create object
        Employee e = new Employee();
        e.setId(103);
        e.setName("David");

        entityManager.persist(e);
        entityTransaction.commit();
        System.out.println("Employee successfully inserted...");

        // Read 
        Employee emp = entityManager.find(Employee.class, 103);
        System.out.println(emp.getId());
        System.out.println(emp.getName());

        // Update
        entityTransaction.begin();
        emp.setName("Michael");
        entityTransaction.commit();

        // Just to view before and after
        Employee emp2 = entityManager.find(Employee.class, 103);
        System.out.println(emp2.getId());
        System.out.println(emp2.getName());

        // Delete
        entityTransaction.begin();
        entityManager.remove(emp2);
        entityTransaction.commit();
        entityManager.close();
    }       
}
