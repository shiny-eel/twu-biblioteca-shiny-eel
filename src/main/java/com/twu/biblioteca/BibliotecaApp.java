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
    }

    public void initialise() {
        io.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
        actionManager = new ActionManager(this, io);
        actionManager.start();
    }

    private void requestBookList() {
        bookFactory = new BookFactory(this);
        bookFactory.createBooks();

    }

    @Override
    public List<Book> getBookList() {
        if (bookFactory == null) requestBookList();
        return bookFactory.getBookList();
    }

    @Override
    public boolean checkoutBook(String bookTitle) {
        for (Book book : getBookList()) {
            if (bookTitle.matches(book.title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return true;
                }
            }
        }
        return false;
    }


}
