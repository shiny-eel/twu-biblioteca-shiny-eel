package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookFactoryTest;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookActionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBookCheckoutTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Test Book";
        IO io = harness.createTestIO(book);
        CheckoutBookAction action = new CheckoutBookAction(mockLib, io);
        action.execute();
        verify(mockLib).checkoutBook(book);

    }

    @Test
    public void anotherBookCheckoutTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Another One";
        IO io = harness.createTestIO(book);
        CheckoutBookAction action = new CheckoutBookAction(mockLib, io);
        action.execute();
        verify(mockLib).checkoutBook(book);

    }

    @Test
    public void availabilityChangedTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);
        List<Book> bookList = app.getBookList();
        Book testBook = bookList.get(1);
        assertThat(testBook.isAvailable(), is(true));

        app.checkoutBook("Infinite Jest");
        assertThat(testBook.isAvailable(), is(false));
    }


    @Test
    public void successMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Art of War");
        BibliotecaApp app = new BibliotecaApp(io);
        CheckoutBookAction action = new CheckoutBookAction(app, io);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Thank you! Enjoy the book")));
    }

    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);
        CheckoutBookAction action = new CheckoutBookAction(app, io);
        try {
            action.execute();
        } catch (NoSuchElementException e) {}
        assertThat(harness.getOutput(), (containsString("Enter a book title to checkout:")));
    }

    @Test
    public void invalidCheckoutTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);


        boolean result = app.checkoutBook("Non-existent Book");
        assertThat(result, is(false));

    }

    @Test
    public void invalidMessageTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Another One";
        when(mockLib.checkoutBook(book)).thenReturn(false);
        IO io = harness.createTestIO(book);
        CheckoutBookAction action = new CheckoutBookAction(mockLib, io);
        action.execute();
        assertThat(harness.getOutput(), (containsString("Sorry, that book is not available")));

    }
}