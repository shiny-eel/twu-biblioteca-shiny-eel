package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MovieFactoryTest {

    public static List<Movie> createFakeList() {
        List<Movie> li = new LinkedList<>();
        Movie b = new Movie("Test", "Foo Bar", 999);
        li.add(b);
        b = new Movie("Hello", "World", 1, 5);
        li.add(b);
        return li;
    }


    @Test
    public void testMovieTitles()  {
        MovieFactory reader = new MovieFactory();
        assertThat(reader.getMovieList().get(0).title, is("Black Panther"));
        assertThat(reader.getMovieList().get(1).title, is("Whiplash"));
        assertThat(reader.getMovieList().get(2).title, is("Parasite"));

    }

    @Test
    public void testMovieDirectors()  {
        MovieFactory reader = new MovieFactory();
        assertThat(reader.getMovieList().get(0).director, is("Chadwick Boseman"));
        assertThat(reader.getMovieList().get(1).director, is("Damien Chazelle"));
        assertThat(reader.getMovieList().get(2).director, is("Bong Joon-ho"));

    }

    @Test
    public void testMovieYears() {
        MovieFactory reader = new MovieFactory();
        assertThat(reader.getMovieList().get(0).year, is(2018));
        assertThat(reader.getMovieList().get(1).year, is(2013));
        assertThat(reader.getMovieList().get(2).year, is(2019));

    }

    @Test
    public void testMovieRatings()  {
        MovieFactory reader = new MovieFactory();
        assertThat(reader.getMovieList().get(0).rating, is(0));
        assertThat(reader.getMovieList().get(1).rating, is(8));
        assertThat(reader.getMovieList().get(2).rating, is(9));

    }

    @Test
    public void testIllegalRating() { // illegal ratings to be set to 0
        Movie m = new Movie("A", "B", 1, -10);
        assertThat(m.rating, is(0));
    }
}