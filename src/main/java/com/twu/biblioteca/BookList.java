package com.twu.biblioteca;

import java.util.List;

public class BookList {

    List<Book> books;

    // Needed for Jackson JSON unmarshalling
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
