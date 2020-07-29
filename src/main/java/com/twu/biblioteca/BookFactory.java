package com.twu.biblioteca;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BookFactory {
    static final Logger log = LogManager.getLogger(BookFactory.class.getName());
    private List<Book> bookList;
    BibliotecaApp app;


    public BookFactory(BibliotecaApp app) {
        this.app = app;
    }

    public void createBooks() {
        bookList = new LinkedList<>();
        bookList.add(new Book("Art of War", "Sun Tzu", 500));
        bookList.add(new Book("Infinite Jest", "David Foster Wallace", 1996));
        bookList.add(new Book("David and Goliath", "Malcolm Gladwell", 2013));

    }

    public List<Book> getBookList() {
        return bookList;
    }

}
