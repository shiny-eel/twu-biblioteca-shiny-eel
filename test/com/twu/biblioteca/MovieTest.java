package com.twu.biblioteca;

import item.Movie;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testToString() {
        Movie movie = new Movie("A", "B", 2000);
        assertThat(movie.toString(), is("A | B | 2000 | unrated"));

    }
}