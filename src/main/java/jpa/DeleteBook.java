package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jpa.entity.Book;

import java.util.Scanner;

public class DeleteBook {
    public static void deleteBook() {
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер книги которую хотите удалить");
        String bookName = scanner.nextLine();
        Book bookFind = manager.find(Book.class, bookName);


        try {
            manager.getTransaction().begin();

            for (int i = 0; i < bookFind.getAuthorBooks().size(); i++) {
                manager.remove(bookFind.getAuthorBooks().get(i));
            }

            manager.remove(bookFind);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        manager.close();
    }
}
