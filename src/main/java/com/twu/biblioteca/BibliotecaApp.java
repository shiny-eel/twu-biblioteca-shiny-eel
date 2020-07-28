package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.Printer;

import java.util.List;

public class BibliotecaApp {

    protected Printer p;
    BookFactory reader;
    ActionManager actionManager;

    public BibliotecaApp(Printer p) {
        this.p = p;
    }

    public static void main(String[] args) {
        new BibliotecaApp(Printer.get()).initialise();
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

    private void displayBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
