package by.iba.schastny.model.dao.impl;

import by.iba.schastny.model.book.Book;
import by.iba.schastny.model.dao.BookDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static by.iba.schastny.constants.ApplicationStringConstants.TABLE_NAME;

@Repository
public class BookDaoImpl  implements BookDao {
    private final static AtomicInteger AUTO_ID = new AtomicInteger(0);
    private final static Map<Integer, Book> books = new HashMap<>();

    private SessionFactory sessionFactory;

    public BookDaoImpl(){}

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM " + "Book").list();
    }

    @Override
    public boolean add(Book book) {
        books.put(AUTO_ID.getAndIncrement(), book);
        return true;
    }

    @Override
    public boolean delete(Book book) {
        books.remove(book.getId());
        return true;
    }

    @Override
    public boolean edit(Book book) {
        books.put(book.getId(), book);
        return true;
    }

    @Override
    public Book getById(int id) {
        return books.get(id);
    }
}
