package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public abstract class Action {

    protected Library lib;
    protected IO io;

    protected enum Access {
        PUBLIC, RESTRICTED, PUBLIC_ONLY
    }

    protected Access access = Access.PUBLIC;

    public Action(Library lib, IO io) {
        this.lib = lib;
        this.io = io;

    }



    protected abstract String getTitle();

    protected abstract void execute();
}
