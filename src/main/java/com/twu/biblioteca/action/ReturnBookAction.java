package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class ReturnBookAction extends Action {

    public ReturnBookAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return null;
    }

    @Override
    void execute() {
        lib.returnBook("Test Book");
    }
}
