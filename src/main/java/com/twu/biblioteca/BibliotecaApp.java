package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp implements ReaderListener {

    JSONReader reader;

    public static void main(String[] args) {
        new BibliotecaApp().initialise();
    }

    public void initialise() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        requestBookList();
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
        displayBookList(reader.getBookList());
    }
}
