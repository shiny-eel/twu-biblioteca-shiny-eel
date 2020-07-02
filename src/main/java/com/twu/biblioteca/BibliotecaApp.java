package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;

import java.util.List;

public class BibliotecaApp implements ReaderListener {

    JSONReader reader;
    ActionManager actionManager;

    public static void main(String[] args) {
        new BibliotecaApp().initialise();
    }

    public void initialise() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
        actionManager = new ActionManager(this);
        actionManager.start();
    }

    private void requestBookList() {
        String path = "resources/book-list.json";
        reader = new JSONReader();
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
