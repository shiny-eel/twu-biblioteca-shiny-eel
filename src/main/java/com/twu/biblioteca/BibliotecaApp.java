package com.twu.biblioteca;

import com.twu.biblioteca.account.Registry;
import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.ItemFactory;
import com.twu.biblioteca.item.Movie;

import java.util.List;

public class BibliotecaApp implements Library, Application, Personal {

    protected IO io;
    private List<Movie> movieList;
    private List<Book> bookList;
    ActionManager actionManager;
    private Registry registry;

    public BibliotecaApp(IO io) {
        this.io = io;
        ItemFactory itemFactory = new ItemFactory();
        movieList = itemFactory.getMovieList();
        bookList = itemFactory.getBookList();
        registry = new Registry();
    }

    public void initialise() {
        io.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        actionManager = new ActionManager(this, io, this);
        actionManager.start();
    }


    @Override
    public List<Book> getBookList() {
        return bookList;
    }


    @Override
    public List<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public void quit() {
        System.exit(0);
    }

//    @Override
//    public Registry getRegistry() {
//        return null;
//    }

    @Override
    public boolean isLoggedOn() {
        return false;
    }
}
