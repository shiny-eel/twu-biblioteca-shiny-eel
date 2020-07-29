package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class BibliotecaApp {

    protected IO p;
    BookFactory reader;
    ActionManager actionManager;

    public BibliotecaApp(IO p) {
        this.p = p;
    }

    public static void main(String[] args) {
        new BibliotecaApp(IO.get()).initialise();
    }

    public void initialise() {
        p.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
        actionManager = new ActionManager(this, p);
        actionManager.start();
    }


    private void requestBookList() {
        reader = new BookFactory(this);
        reader.createBooks();

    }

    public List<Book> getBookList() {
        return reader.getBookList();
    }


}
