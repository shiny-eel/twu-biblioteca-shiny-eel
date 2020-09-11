package com.twu.biblioteca.action.item;

import com.twu.biblioteca.*;
import com.twu.biblioteca.action.item.ListMoviesAction;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMoviesActionTest {


    @Test
    public void titleTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);

        ListMoviesAction action = new ListMoviesAction(mockLib, harness.createTestIO(""));
        assertThat(action.getTitle(), is("List of movies"));
    }

    @Test
    public void libraryCalledTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);

        ListMoviesAction action = new ListMoviesAction(mockLib, harness.createTestIO(""));
        action.execute();

        verify(mockLib).getMovieList();
    }

    @Test
    public void listDisplayedTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        List<Movie> movies = ItemFactoryTest.createFakeMovies();
        ListMoviesAction action = new ListMoviesAction(mockLib, harness.createTestIO(""));
        when(mockLib.getMovieList()).thenReturn(movies);
        action.execute();

        String expected = "Test | Foo Bar | 999 | unrated\n" + "Hello | World | 1 | 5\n";
        assertThat(harness.getOutput(), containsString(expected));

    }
}