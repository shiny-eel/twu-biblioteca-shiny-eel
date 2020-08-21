package com.twu.biblioteca;

import java.util.List;

/**
 * Responsibility to fulfill requests of a library
 *
 * Such as listing and loaning books
 */
public abstract class Library {

    public abstract List<Book> getBookList();

    public abstract boolean returnBook(String bookTitle);

    public abstract boolean checkoutBook(String bookTitle);

    public void quit() { System.exit(0);}
}
