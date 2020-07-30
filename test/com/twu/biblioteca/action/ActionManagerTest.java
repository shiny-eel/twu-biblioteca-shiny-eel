package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.io.MockIO;
import com.twu.biblioteca.io.NoInputGivenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActionManagerTest {
    private MockIO mockIO;
    private ActionManager am;
    private BibliotecaApp mockApp;



    @Before
    public void setUp() throws Exception {
        mockIO = new MockIO();
        mockApp = mock(BibliotecaApp.class);
        when(mockApp.getBookList()).thenReturn(createFakeList());
        am = new ActionManager(mockApp, mockIO);
    }

    @Test
    public void testMenuDisplayOptions() {
        startActionManager();
        String expected = "1. List of books\n" + "2. Quit";
        assertThat(mockIO.fullOutput, containsString(expected));
    }


    @Test
    public void testSelectListBooks() {
        mockIO.addInput("1");
        startActionManager();
        String expected = "Test Book | Foo Bar | 999\n" + "Another One | Rubber Ducky | 1";
        assertThat(mockIO.fullOutput, containsString(expected));
    }

    @Test
    public void testInvalidOptionSelect() {
        mockIO.addInput("0");
        startActionManager();
        String invalid = "Please select a valid option!";
        assertThat(mockIO.fullOutput, containsString(invalid));

    }

    @Test
    public void testQuitOptionSelect() {
        mockIO.addInput("2"); // Assuming 2 is the quit option
        startActionManager();
        verify(mockApp).quit();
    }

    /**
     * May be needed in future
     * assertThat(mockIO.getLast(), is("Art of War | Sun Tzu | 500\n" +
     * "Infinite Jest | David Foster Wallace | 1996\n" +
     * "David and Goliath | Malcolm Gladwell | 2013"));
     */

    // Use to ignore mockIO not blocking when no input given
    private void startActionManager() {
        try {
            am.start();
        } catch (NoInputGivenException e) {
        }
    }

    private List<Book> createFakeList() {
        List<Book> li = new LinkedList<>();
        Book b = new Book("Test Book", "Foo Bar", 999);
        li.add(b);
        b = new Book("Another One", "Rubber Ducky", 1);
        li.add(b);
        return li;
    }

}