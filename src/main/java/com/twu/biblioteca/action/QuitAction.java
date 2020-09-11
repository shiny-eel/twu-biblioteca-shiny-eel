package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class QuitAction extends Action {

    public QuitAction(Library lib, IO io) {
        super(lib, io);
    }


    @Override
    protected String getTitle() {
        return "Quit";
    }

    @Override
    protected void execute() {
        lib.quit();
    }
}
