package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class CheckoutBookAction extends Action {

    public CheckoutBookAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return null;
    }

    @Override
    void execute() {
        String bookTitle = io.getInput();
        lib.checkoutBook(bookTitle);
    }
}

