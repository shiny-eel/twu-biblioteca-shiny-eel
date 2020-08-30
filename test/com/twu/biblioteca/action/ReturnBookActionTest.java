package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
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
    public void callReturnTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Test Book";
        IO io = harness.createTestIO(book);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        action.execute();
        verify(mockLib).returnBook(book);

    }

    @Test
    public void callReturnCorrectTitleTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Foo Bar";
        IO io = harness.createTestIO(book);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        action.execute();
        verify(mockLib).returnBook(book);
    }

    @Test
    public void successMsgTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Foo Bar";
        when(mockLib.returnBook(book)).thenReturn(true);
        IO io = harness.createTestIO(book);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        action.execute();
        assertThat(harness.getOutput(), containsString("Thank you for returning the book\n"));
    }

    @Test
    public void failMsgTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Foo Bar";
        when(mockLib.returnBook(book)).thenReturn(false);
        IO io = harness.createTestIO(book);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        action.execute();
        assertThat(harness.getOutput(), containsString("That is not a valid book to return.\n"));
    }
}