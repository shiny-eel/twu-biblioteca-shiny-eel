package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookFactoryTest;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookActionTest {

    @Test
    public void TestBookCheckoutTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Test Book";
        IO io = harness.createTestIO(book);
        CheckoutBookAction action = new CheckoutBookAction(mockLib, io);
        action.execute();
        verify(mockLib).checkoutBook(book);

    }

    @Test
    public void AnotherBookCheckoutTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Another One";
        IO io = harness.createTestIO(book);
        CheckoutBookAction action = new CheckoutBookAction(mockLib, io);
        action.execute();
        verify(mockLib).checkoutBook(book);

    }

    @Test
    public void ListChangedTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = new BibliotecaApp(io);
        ListBooksAction listAction = new ListBooksAction(app, io);

        listAction.execute();
        assertThat(harness.getOutput(), (containsString("Art of War | Sun Tzu | 500")));

        harness.clearOutput();
        app.checkoutBook("Art of War");
        listAction.execute();
        assertThat(harness.getOutput(), not(containsString("Art of War | Sun Tzu | 500")));

    }
}