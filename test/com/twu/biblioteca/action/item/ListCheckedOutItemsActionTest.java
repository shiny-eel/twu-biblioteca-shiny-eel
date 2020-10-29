package com.twu.biblioteca.action.item;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListCheckedOutItemsActionTest {

    IOHarness ioHarness;
    BibliotecaApp app;

    @Before
    public void setup() {
        ioHarness = new IOHarness();
        app = mock(BibliotecaApp.class);
        List<Book> bookList = ItemFactoryTest.createFakeBooks(); // No books checked out
        when(app.getBookList()).thenReturn(bookList);
        when(app.getMovieList()).thenReturn(ItemFactoryTest.createFakeMovies());
        when(app.getCurrentUser()).thenReturn(mock(User.class));

    }

    @Test
    public void listNoAvailableItemsTest() {

        ListCheckedOutItemsAction action = new ListCheckedOutItemsAction(ioHarness.createTestIO(""), app, app);
        action.execute();

        assertThat(ioHarness.getOutput(), containsString("There are no items to display.\n"));

    }

    @Test
    public void listCheckedOutBook() {
        IO io = ioHarness.createTestIO("Test Book");

        CheckoutBookAction checkoutAction = new CheckoutBookAction(io, app, app);
        checkoutAction.execute();

        ListCheckedOutItemsAction action = new ListCheckedOutItemsAction(io, app, app);
        action.execute();

        assertThat(ioHarness.getOutput(), containsString("Test Book"));

    }


    @Test
    public void listCheckedOutBookAndMovie() {
        IO io = ioHarness.createTestIO("Test Book\nHello\n");

        CheckoutBookAction checkoutAction = new CheckoutBookAction(io, app, app);
        checkoutAction.execute();

        CheckoutMovieAction checkoutMovieAction = new CheckoutMovieAction(io, app, app);
        checkoutMovieAction.execute();

        ListCheckedOutItemsAction action = new ListCheckedOutItemsAction(io, app, app);
        action.execute();

        assertThat(ioHarness.getOutput(), containsString("Test Book"));
        assertThat(ioHarness.getOutput(), containsString("Hello"));

    }


}