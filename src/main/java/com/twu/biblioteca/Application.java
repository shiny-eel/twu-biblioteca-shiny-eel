package com.twu.biblioteca;

import com.twu.biblioteca.account.User;

public interface Application {

    void logIn(User user);

    boolean isLoggedIn();

    User getCurrentUser();

    void quit();
}
