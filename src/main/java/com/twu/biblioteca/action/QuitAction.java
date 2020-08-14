package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class QuitAction extends Action {

    public QuitAction(Library lib, IO io) {
        super(lib, io);
    }


    @Override
    String getTitle() {
        return "Quit";
    }

    @Override
    void execute() {
        lib.quit();
    }
}
