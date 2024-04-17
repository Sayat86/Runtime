package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.entity.Author;

import java.util.Scanner;

public class CreateAuthor {
    public static void createAuthor() {
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя автора, который хотите создать");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию автора");
        String lastName = scanner.nextLine();

        try {
            manager.getTransaction().begin();

            Author author = new Author();
            author.setName(name);
            author.setLastName(lastName);
            manager.persist(author);


            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        manager.close();
    }
}
