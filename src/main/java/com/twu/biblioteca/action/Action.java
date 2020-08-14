package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public abstract class Action {

    protected Library lib;
    protected IO io;

    public Action(Library lib, IO io) {
        this.lib = lib;
        this.io = io;

    }

    abstract String getTitle();

    abstract void execute();
}
