package com.twu.biblioteca.action.item;

import com.twu.biblioteca.*;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMoviesActionTest {
    IOHarness harness;
    Library lib;

    @Before
    public void setUp(){
        harness = new IOHarness();
        lib = mock(Library.class);

    }
    @Test
    public void titleTest() {
        

        ListMoviesAction action = new ListMoviesAction(harness.createTestIO(""), lib);
        assertThat(action.getTitle(), is("List of movies"));
    }

    @Test
    public void libraryCalledTest() {
       
        ListMoviesAction action = new ListMoviesAction(harness.createTestIO(""), lib);
        action.execute();

        verify(lib).getMovieList();
    }


    @Test
    public void columnTitleTest() {
        List<Movie> movies = ItemFactoryTest.createFakeMovies();
        when(lib.getMovieList()).thenReturn(movies);

        ListMoviesAction action = new ListMoviesAction(harness.createTestIO(""), lib);
        action.execute();


        assertThat(harness.getOutput(), containsString(
                "Title                 | Director              | Year | Rating"));

    }


    @Test
    public void listDisplayedTest() {

        List<Movie> movies = ItemFactoryTest.createFakeMovies();
        when(lib.getMovieList()).thenReturn(movies);
        ListMoviesAction action = new ListMoviesAction(harness.createTestIO(""), lib);
        action.execute();

        String expected = "Test                  | Foo Bar               |  999 | unrated\n" +
                "Hello                 | World                 |    1 | 5";
        assertThat(harness.getOutput(), containsString(expected));

    }
}