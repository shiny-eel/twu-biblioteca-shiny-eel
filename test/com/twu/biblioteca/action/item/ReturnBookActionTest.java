package com.twu.biblioteca.action.item;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.action.item.ReturnBookAction;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ReturnBookActionTest {

    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        Library mockLib = mock(Library.class);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        try {
            action.execute();
        } catch (NoSuchElementException e) {
        }
        assertThat(harness.getOutput(), (containsString("Enter a book title to return:")));
    }


    @Test
    public void successMsgTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("David and Goliath");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Book> bookList = app.getBookList();
        Book testBook = bookList.get(2);
        testBook.setAvailable(false);

        ReturnBookAction action = new ReturnBookAction(app, io);
        action.execute();
        assertThat(harness.getOutput(), containsString("Thank you for returning the book\n"));
    }

    @Test
    public void failMsgTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Invalid Book");
        BibliotecaApp app = new BibliotecaApp(io);

        ReturnBookAction action = new ReturnBookAction(app, io);
        action.execute();
        assertThat(harness.getOutput(), containsString("That is not a valid book to return.\n"));
    }

    @Test
    public void validReturnTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Infinite Jest");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Book> bookList = app.getBookList();
        Book testBook = bookList.get(1);
        testBook.setAvailable(false);

        ReturnBookAction action = new ReturnBookAction(app, io);
        action.execute();

        assertThat(testBook.isAvailable(), is(true));
    }


    @Test
    public void invalidReturnTest() { // Available book stays available
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("Infinite Jest");
        BibliotecaApp app = new BibliotecaApp(io);

        List<Book> bookList = app.getBookList();
        Book testBook = bookList.get(1);
        testBook.setAvailable(true);

        ReturnBookAction action = new ReturnBookAction(app, io);
        action.execute();

        assertThat(testBook.isAvailable(), is(true));
    }
}