package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;

import java.util.List;

/**
 * Responsibility to fulfill requests of a library
 * <p>
 * Such as listing and loaning books
 */
public abstract class Library {

    public abstract List<Book> getBookList();

//    public abstract boolean returnBook(String bookTitle);

//    public abstract boolean checkoutBook(String bookTitle);


    public abstract List<Movie> getMovieList();
    public abstract boolean checkoutMovie(String bookTitle);

    public void quit() {
        System.exit(0);
    }
}
