package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.IO;

public abstract class Action {

    protected BibliotecaApp app;
    protected IO io;

    public Action(BibliotecaApp app, IO io) {
        this.app = app;
        this.io = io;

    }


    abstract String getTitle();

    abstract void execute();
}
