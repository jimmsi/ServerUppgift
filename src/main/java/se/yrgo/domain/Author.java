package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private int age;
    @OneToMany
    @JoinColumn(name = "AUTHOR_FK")
    private List<Book> listOfBooks;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
        this.listOfBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public void addBookToList (Book book) {
        this.listOfBooks.add(book);
    }

    public List<Book> getListOfBooks() {
        List<Book>unmodifiable=
                Collections.unmodifiableList(this.listOfBooks);
        return unmodifiable;
    }

}
