package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;

public abstract class Action {

    private BibliotecaApp app;
    public Action(BibliotecaApp app) {
        this.app = app;

    }

    abstract String getTitle();
    abstract void execute();
}
