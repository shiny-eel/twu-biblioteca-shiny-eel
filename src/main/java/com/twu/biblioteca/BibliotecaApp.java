package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class BibliotecaApp extends Library {

    protected IO io;
    BookFactory reader;
    ActionManager actionManager;

    public BibliotecaApp(IO io) {
        this.io = io;
    }

    public void initialise() {
        io.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
        actionManager = new ActionManager(this, io);
        actionManager.start();
    }

    private void requestBookList() {
        reader = new BookFactory(this);
        reader.createBooks();

    }

    @Override
    public List<Book> getBookList() {
        if (reader == null) requestBookList();
        return reader.getBookList();
    }


}
