package com.twu.biblioteca.action;

import com.twu.biblioteca.io.IO;

public abstract class Action {

    protected IO io;
    protected Access access = Access.PUBLIC;

    public Action(IO io) {
        this.io = io;

    }

    protected abstract String getTitle();

    protected abstract void execute();

    protected enum Access {
        PUBLIC, RESTRICTED, PUBLIC_ONLY
    }
}
