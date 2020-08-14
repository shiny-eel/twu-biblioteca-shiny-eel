package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class ListBooksAction extends Action {

    public ListBooksAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return "List of books";
    }

    @Override
    void execute() {
        List<Book> books = lib.getBookList();
        for (Book book : books) {
            if (book.isAvailable())
                io.println(book.toString());
        }
    }

}
