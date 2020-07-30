package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.IO;

public class QuitAction extends Action {

    public QuitAction(BibliotecaApp app, IO io) {
        super(app, io);
    }

    @Override
    String getTitle() {
        return "Quit";
    }

    @Override
    void execute() {
//        System.exit(0);
    }
}
