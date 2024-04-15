package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa.entity.Author;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Author> authorTypedQuery = manager.createQuery("select c from Author c", Author.class);
        List<Author> authorList = authorTypedQuery.getResultList();

        for (int i = 0; i < authorList.size(); i++) {
            System.out.println(authorList.get(i).getName());
        }


    }
}
