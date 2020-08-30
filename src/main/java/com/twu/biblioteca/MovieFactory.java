package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class MovieFactory {
    private List<Movie> movies;

    public MovieFactory() {
        movies = new LinkedList<>();
        movies.add(new Movie("Black Panther", "Chadwick Boseman", 2018));
        movies.add(new Movie("Whiplash", "Damien Chazelle", 2013, 8));
        movies.add(new Movie("Parasite", "Bong Joon-ho", 2019, 9));

    }

    public List<Movie> getMovieList() {
        return movies;
    }
}
