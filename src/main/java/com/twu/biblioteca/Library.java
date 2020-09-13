package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;

import java.util.List;


public interface Library {

    List<Book> getBookList();

    List<Movie> getMovieList();

}
