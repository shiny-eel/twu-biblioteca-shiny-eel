package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class CheckoutBookAction extends Action {

    private static final String SUCCESS_MSG = "Thank you! Enjoy the book\n";
    private static final String PROMPT = "Enter a book title to checkout:";

    public CheckoutBookAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return "Checkout a book";
    }

    @Override
    void execute() {
        io.println(PROMPT);
        String bookTitle = io.getInput();
        boolean success = lib.checkoutBook(bookTitle);
        if (success)
            io.println(SUCCESS_MSG);
    }
}

