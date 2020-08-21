package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class ReturnBookAction extends Action {

    private static final String SUCCESS_MSG = "Thank you for returning the book\n";
    private static final String FAIL_MSG = "That is not a valid book to return.\n";
    private static final String PROMPT = "Enter a book title to return:";

    public ReturnBookAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return "Return a book";
    }

    @Override
    void execute() {
        io.println(PROMPT);
        String input = io.getInput();
        boolean success = lib.returnBook(input);
        if (success) {
            io.println(SUCCESS_MSG);
        } else {
            io.println(FAIL_MSG);
        }
    }
}
