package com.twu.biblioteca;

public class Book {

    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append(" | ")
                .append(author)
                .append(" | ")
                .append(year);
        return sb.toString();
    }
}
