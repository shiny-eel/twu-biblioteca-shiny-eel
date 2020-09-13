package com.twu.biblioteca.account;

public class User {

    private String name;
    private String password;
    private String libraryNum;

    public User(String name, String libraryNum, String password) {
        this.name = name;
        this.libraryNum = libraryNum;
        this.password = password;
    }

    public String getLibraryNum() {
        return libraryNum;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
