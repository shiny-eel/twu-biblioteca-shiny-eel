package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CheckoutBookActionTest {

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
        } catch (NoSuchElementException e) {
        }
        assertThat(harness.getOutput(), (containsString("Enter a book title to checkout:")));
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