package com.twu.biblioteca.action.item;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class ReturnMovieActionTest {

    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        Library mockLib = mock(Library.class);
        ReturnMovieAction action = new ReturnMovieAction(io, mockLib);
        try {
            action.execute();
        } catch (NoSuchElementException e) {
        }
        assertThat(harness.getOutput(), (containsString("Enter a movie title to return:")));
    }


    @Test
    public void successMsgTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Parasite");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Movie> movieList = app.getMovieList();
        Movie testMovie = movieList.get(2);
        testMovie.borrow(mock(User.class));

        ReturnMovieAction action = new ReturnMovieAction(io, app);
        action.execute();
        assertThat(harness.getOutput(), containsString("Thank you for returning the movie\n"));
    }

    @Test
    public void failMsgTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Invalid Movie");
        BibliotecaApp app = new BibliotecaApp(io);

        ReturnMovieAction action = new ReturnMovieAction(io, app);
        action.execute();
        assertThat(harness.getOutput(), containsString("That is not a valid movie to return.\n"));
    }

    @Test
    public void validReturnTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Whiplash");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Movie> movieList = app.getMovieList();
        Movie testMovie = movieList.get(1);
        testMovie.borrow(mock(User.class));

        ReturnMovieAction action = new ReturnMovieAction(io, app);
        action.execute();

        assertThat(testMovie.isAvailable(), is(true));
    }


    @Test
    public void invalidReturnTest() { // Available movie stays available
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Whiplash");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Movie> movieList = app.getMovieList();
        Movie testMovie = movieList.get(1);
//        testMovie.setAvailable(true);

        ReturnMovieAction action = new ReturnMovieAction(io, app);
        action.execute();

        assertThat(testMovie.isAvailable(), is(true));
    }

}