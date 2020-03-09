package by.iba.schastny.service.impl;

import by.iba.schastny.model.book.Book;
import by.iba.schastny.model.dao.BookDao;
import by.iba.schastny.model.dao.impl.BookDaoImpl;
import by.iba.schastny.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }






}
