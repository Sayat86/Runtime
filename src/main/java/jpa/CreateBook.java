package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa.entity.Author;
import jpa.entity.AuthorBooks;
import jpa.entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CreateBook {
    public static void createBook() {
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги");
        String nameBook = scanner.nextLine();
        System.out.println("Введите дату публикации");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        TypedQuery<Author> authorTypedQuery = manager.createQuery("select a from Author a", Author.class);
        List<Author> authorList = authorTypedQuery.getResultList();
        int count = 0;
        for (int i = 0; i < authorList.size(); i++) {
            count++;
            System.out.println(count + ")" + authorList.get(i).getName());
        }

        System.out.println("Введите количество авторов у книги");
        int countAuthor = Integer.parseInt(scanner.nextLine());

        try {
            manager.getTransaction().begin();

            Book book = new Book();
            book.setNameBook(nameBook);
            book.setDate(date);
            manager.persist(book);

            for (int i = 0; i < countAuthor; i++) {
                System.out.println("Введите ID автора книги");
                String author = scanner.nextLine();

                Author authorFind = manager.find(Author.class, author);
                while (authorFind == null) {
                    System.out.println("Введите правильное ID имя автора");
                    author = scanner.nextLine();
                    authorFind = manager.find(Author.class, author);
                }
                System.out.println(authorFind.getName());
                AuthorBooks authorBooks = new AuthorBooks();
                authorBooks.setBook(book);
                authorBooks.setAuthor(authorFind);
                manager.persist(authorBooks);
            }


            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        manager.close();
    }
}
