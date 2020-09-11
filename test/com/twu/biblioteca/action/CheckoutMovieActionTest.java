package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckoutMovieActionTest {


    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);
        CheckoutMovieAction action = new CheckoutMovieAction(app, io);
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
        CheckoutMovieAction action = new CheckoutMovieAction(app, io);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Thank you! Enjoy the movie")));
    }

    @Test
    public void makeUnavailableTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO(ItemFactoryTest.WHIPLASH_TITLE);
        BibliotecaApp app = new BibliotecaApp(io);
        List<Movie> MovieList = app.getMovieList();
        Movie testMovie = MovieList.get(1);
        assertThat(testMovie.isAvailable(), is(true));

        CheckoutMovieAction action = new CheckoutMovieAction(app, io);
        action.execute();

        assertThat(testMovie.isAvailable(), is(false));
    }

    @Test
    public void UnavailableTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO(ItemFactoryTest.WHIPLASH_TITLE);
        BibliotecaApp app = new BibliotecaApp(io);
        app.getMovieList().get(1).setAvailable(false);
        CheckoutMovieAction action = new CheckoutMovieAction(app, io);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Sorry, that movie is not available")));

    }

    @Test
    public void NonexistentCheckoutTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Non-existent Movie");
        BibliotecaApp app = new BibliotecaApp(io);

        CheckoutMovieAction action = new CheckoutMovieAction(app, io);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Sorry, that movie is not available")));

    }


}