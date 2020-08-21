package com.twu.biblioteca;

public class Book {

    String title;
    String author;
    int year;
    private boolean isAvailable;



    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
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
