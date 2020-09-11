package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class QuitAction extends Action {

    Application app;
    public QuitAction(Library lib, IO io, Application app) {
        super(lib, io);
        this.app = app;
    }


    @Override
    protected String getTitle() {
        return "Quit";
    }

    @Override
    protected void execute() {
        app.quit();
    }
}
