package jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_book")
    private String nameBook;

    private LocalDate date;

    @OneToMany(mappedBy = "book")
    private List<AuthorBooks> authorBooks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<AuthorBooks> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<AuthorBooks> authorBooks) {
        this.authorBooks = authorBooks;
    }
}
