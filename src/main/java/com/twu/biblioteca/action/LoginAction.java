package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class LoginAction extends Action {

    public LoginAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    protected String getTitle() {
        return "Login";
    }

    @Override
    protected void execute() {

    }
}
