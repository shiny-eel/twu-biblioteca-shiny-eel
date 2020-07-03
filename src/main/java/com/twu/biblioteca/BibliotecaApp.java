package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.Printer;

import java.util.List;

public class BibliotecaApp implements ReaderListener {

    JSONReader reader;
    ActionManager actionManager;
    protected Printer p;

    public static void main(String[] args) {
        new BibliotecaApp(Printer.get()).initialise();
    }

    public BibliotecaApp(Printer p) {
        this.p = p;
    }

    public void initialise() {
        p.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
        actionManager = new ActionManager(this, p);
        actionManager.start();
    }


    private void requestBookList() {
        String path = "resources/book-list.json";
        reader = new JSONReader(this);
        reader.addListener(this);
        reader.read(path);

    }

    private void displayBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }


    @Override
    public void onReadEvent() {
//        displayBookList(reader.getBookList());


    }
}
