package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;

import java.util.List;

/**
 * Responsibility to fulfill requests of a library
 * <p>
 * Such as listing and loaning books
 */
public interface Library {

    List<Book> getBookList();

    List<Movie> getMovieList();

}
