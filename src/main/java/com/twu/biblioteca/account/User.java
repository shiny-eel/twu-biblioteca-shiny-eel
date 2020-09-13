package com.twu.biblioteca.account;

public class User {

    private String name;
    private String password;
    private String libraryNum;

    private String email;
    private String phoneNumber;

    public User(String name, String libraryNum, String password) {
        this.name = name;
        this.libraryNum = libraryNum;
        this.password = password;
    }

    public void setDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
