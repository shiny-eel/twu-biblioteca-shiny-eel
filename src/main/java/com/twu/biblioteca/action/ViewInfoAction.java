package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;

public class ViewInfoAction extends Action {
    private static final String SEPARATOR = "--------------------";
    private Application app;

    public ViewInfoAction(IO io, Application app) {
        super(io);
        this.app = app;
        this.access = Access.RESTRICTED;
    }

    @Override
    protected String getTitle() {
        return "View user information";
    }

    @Override
    protected void execute() {
        User user = app.getCurrentUser();
        io.println(SEPARATOR);
        io.println(user.getName());
        io.println(user.getEmail());
        io.println(user.getPhoneNumber());
        io.println(SEPARATOR);
    }
}
