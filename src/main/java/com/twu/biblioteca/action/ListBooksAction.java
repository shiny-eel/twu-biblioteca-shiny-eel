package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;

public class ListBooksAction extends Action {

    public ListBooksAction(BibliotecaApp app) {
        super(app);
    }

    @Override
    String getTitle() {
        return "List of books";
    }

    @Override
    void execute() {

    }
}
