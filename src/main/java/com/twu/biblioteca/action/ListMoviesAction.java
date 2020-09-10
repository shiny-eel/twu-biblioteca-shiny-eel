package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import item.Movie;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class ListMoviesAction extends Action {

    private static final String SEPARATOR = "--------------------";

    public ListMoviesAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return null;
    }

    @Override
    void execute() {
        List<Movie> movies = lib.getMovieList();
        io.println(SEPARATOR);
        for (Movie movie: movies) {
                io.println(movie.toString());
        }
        io.println(SEPARATOR);
    }
}
