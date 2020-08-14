package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookFactoryTest;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ActionManagerTest {
    private ActionManager am;
    private BibliotecaApp mockApp;
    private ByteArrayInputStream is;
    private IOHarness ioHarness = new IOHarness();

    @Before
    public void setUp() throws Exception {
        mockApp = mock(BibliotecaApp.class);
        when(mockApp.getBookList()).thenReturn(BookFactoryTest.createFakeList());
    }

    public void start(String input) {
        IO mockIO = ioHarness.createTestIO(input);
        am = new ActionManager(mockApp, mockIO);
        try {
            am.start();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testMenuDisplayOptions() {
        start("");
        String expected = "1. List of books\n" + "2. Quit";
        assertThat(ioHarness.getOutput(), containsString(expected));
    }


    @Test
    public void testSelectListBooks() {
        start("1");
        String expected = "Test Book | Foo Bar | 999\n" + "Another One | Rubber Ducky | 1";
        assertThat(ioHarness.getOutput(), containsString(expected));
    }

    @Test
    public void testInvalidOptionSelect() {
        start("0");
        String invalid = "Please select a valid option!";
        assertThat(ioHarness.getOutput(), containsString(invalid));

    }

    @Test
    public void testQuitOptionSelect() {
        start("2"); // Assuming 2 is the quit option
        verify(mockApp).quit();
    }

    /**
     * May be needed in future
     * assertThat(mockIO.getLast(), is("Art of War | Sun Tzu | 500\n" +
     * "Infinite Jest | David Foster Wallace | 1996\n" +
     * "David and Goliath | Malcolm Gladwell | 2013"));
     */



}