package com.twu.biblioteca.item;

public class Book extends Item {

    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    public static String getHeader() {
        return String.format(format, "Title", "Author", "Year");
    }

    public String getAuthor() {
        return creator;
    }

}
