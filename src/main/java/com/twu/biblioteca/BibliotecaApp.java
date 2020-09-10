package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class BibliotecaApp extends Library {

    protected IO io;
    BookFactory bookFactory;
    ActionManager actionManager;

    public BibliotecaApp(IO io) {
        this.io = io;
        bookFactory = new BookFactory(this);

    }

    public void initialise() {
        io.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        actionManager = new ActionManager(this, io);
        actionManager.start();
    }


    @Override
    public List<Book> getBookList() {
        return bookFactory.getBookList();
    }
    

    @Override
    public List<Movie> getMovieList() {
        return null;
    }

    @Override
    public boolean checkoutMovie(String bookTitle) {
        return false;
    }
}
