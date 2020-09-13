package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.account.Registry;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;

public class LoginAction extends Action {
    private static final String PROMPT_LIB_NUMBER = "Enter your library number:";
    private static final String PROMPT_PASSWORD = "Enter your password:";
    private static final String SUCCESS_MSG = "Login successful\n";
    private static final String FAIL_MSG = "Login failed\n";

    private Registry registry;
    private Application app;

    public LoginAction(IO io, Registry registry, Application app) {
        super(io);
        this.registry = registry;
        this.app = app;
        this.access = Access.PUBLIC_ONLY;
    }

    @Override
    protected String getTitle() {
        return "Login";
    }

    @Override
    protected void execute() {
        io.println(PROMPT_LIB_NUMBER);
        String id = io.getInput();
        io.println(PROMPT_PASSWORD);
        String password = io.getInput();

        User user = registry.getUser(id);
        if (user != null && user.getPassword().equals(password)) {
            io.println(SUCCESS_MSG);
            app.logIn(user);
        } else {
            io.println(FAIL_MSG);
        }
    }
}
