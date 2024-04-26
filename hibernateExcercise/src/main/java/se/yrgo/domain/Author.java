package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private int age;
    @OneToMany
    @JoinColumn(name="AUTHOR_FK")
    private Set<Book> setOfBooks;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
        this.setOfBooks = new HashSet<Book>();
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

    public void addBookToSet(Book book) {
        this.setOfBooks.add(book);
    }

    public Set<Book> getSetOfBooks() {
        Set<Book>unmodifiable=
                Collections.unmodifiableSet(this.setOfBooks);
        return unmodifiable;
    }

}
