package com.twu.biblioteca.action.item;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CheckoutMovieActionTest {


    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);
        CheckoutMovieAction action = new CheckoutMovieAction(io, app, app);
        try {
            action.execute();
        } catch (NoSuchElementException e) {
        }
        assertThat(harness.getOutput(), (containsString("Enter a movie title to checkout:")));
    }

    @Test
    public void successMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO(ItemFactoryTest.WHIPLASH_TITLE);
        BibliotecaApp app = new BibliotecaApp(io);
        CheckoutMovieAction action = new CheckoutMovieAction(io, app, app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Thank you! Enjoy the movie")));
    }

    @Test
    public void makeUnavailableTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO(ItemFactoryTest.WHIPLASH_TITLE);
        BibliotecaApp app = new BibliotecaApp(io);
        app.logIn(mock(User.class));
        List<Movie> MovieList = app.getMovieList();
        Movie testMovie = MovieList.get(1);
        assertThat(testMovie.isAvailable(), is(true));

        CheckoutMovieAction action = new CheckoutMovieAction(io, app, app);
        action.execute();

        assertThat(testMovie.isAvailable(), is(false));
    }

    @Test
    public void UnavailableTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO(ItemFactoryTest.WHIPLASH_TITLE);
        BibliotecaApp app = new BibliotecaApp(io);
        app.getMovieList().get(1).borrow(mock(User.class));
        CheckoutMovieAction action = new CheckoutMovieAction(io, app, app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Sorry, that movie is not available")));

    }

    @Test
    public void NonexistentCheckoutTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Non-existent Movie");
        BibliotecaApp app = new BibliotecaApp(io);

        CheckoutMovieAction action = new CheckoutMovieAction(io, app, app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Sorry, that movie is not available")));

    }


}