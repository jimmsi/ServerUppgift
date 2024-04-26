package se.yrgo.domain;

import se.yrgo.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.Set;

public class HarnessTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

/*
        Book book1 = new Book("De vises sten");
        Book book2 = new Book("Hemligheternas kammare");
        Book book3= new Book("Fången från Askaban");
        Author author = new Author("J K Rowling");

        author.addBookToSet(book1);
        author.addBookToSet(book2);
        author.addBookToSet(book3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(author);
*/

        Author authorFromDataBase = session.get(Author.class, 60);

        Set<Book> setOfBooks = authorFromDataBase.getSetOfBooks();
        for (Book book : setOfBooks) {
            System.out.println(book);
        }

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
