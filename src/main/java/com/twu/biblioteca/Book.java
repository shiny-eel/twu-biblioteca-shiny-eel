package com.twu.biblioteca;

public class Book {

    public String getTitle() {
        return title;
    }

    private String title;

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    private String author;
    private int year;
    private boolean isAvailable;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
