package com.twu.biblioteca;

public class Book {

    String title;
    String author;
    int year;

    // Needed for Jackson JSON unmarshalling
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
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
