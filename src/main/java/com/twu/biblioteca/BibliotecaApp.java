package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.ItemFactory;
import com.twu.biblioteca.item.Movie;

import java.util.List;

public class BibliotecaApp extends Library {

    protected IO io;
    private List<Movie> movieList;
    private List<Book> bookList;
    ActionManager actionManager;

    public BibliotecaApp(IO io) {
        this.io = io;
        ItemFactory itemFactory = new ItemFactory();
        movieList = itemFactory.getMovieList();
        bookList = itemFactory.getBookList();
    }

    public void initialise() {
        io.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        actionManager = new ActionManager(this, io);
        actionManager.start();
    }


    @Override
    public List<Book> getBookList() {
        return bookList;
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
