package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class ListBooksAction extends Action {

    public ListBooksAction(BibliotecaApp app, IO io) {
        super(app, io);
    }

    @Override
    String getTitle() {
        return "List of books";
    }

    @Override
    void execute() {
        List<Book> books = app.getBookList();
        for (Book book : books) {
            io.println(book.toString());
        }
    }

}
