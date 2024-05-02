package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa.entity.Author;
import jpa.entity.AuthorBooks;

import java.util.List;
import java.util.Scanner;

public class Select {
    public static void selectBookName() {
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя автора");
        String name = scanner.nextLine();

        TypedQuery<AuthorBooks> authorBooksTypedQuery = manager.createQuery("select c from AuthorBooks c " +
                "where c.author.name = ?1", AuthorBooks.class);
        authorBooksTypedQuery.setParameter(1, name);
        List<AuthorBooks> authorList = authorBooksTypedQuery.getResultList();

        for (int i = 0; i < authorList.size(); i++) {
            System.out.println("книга - " + authorList.get(i).getBook().getNameBook());
        }
    }
}
