package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.io.MockIO;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActionManagerTest {
    private MockIO mockIO;
    private ActionManager am;

    @Before
    public void setUp() throws Exception {
        mockIO = new MockIO();
        BibliotecaApp mockApp = mock(BibliotecaApp.class);
        when(mockApp.getBookList()).thenReturn(createFakeList());
        am = new ActionManager(mockApp, mockIO);
    }

    @Test
    public void testMenuDisplayOption() {
        am.start();
        assertThat(mockIO.getLast(), is("1. List of books"));
    }

    @Test
    public void testSelectListBooks() {
        mockIO.addInput("1");
        am.start();
        assertThat(mockIO.get(2), is("Test Book | Foo Bar | 999"));
        assertThat(mockIO.getLast(), is("Another One | Rubber Ducky | 1"));
    }

    @Test
    public void testInvalidOptionSelect() {
        mockIO.addInput("0");
        am.start();
        String invalid = "Please select a valid option!";
        assertThat(mockIO.getLast(), is(invalid));

    }

    /**
     * May be needed in future
     *  assertThat(mockIO.getLast(), is("Art of War | Sun Tzu | 500\n" +
     "Infinite Jest | David Foster Wallace | 1996\n" +
     "David and Goliath | Malcolm Gladwell | 2013"));
     *
     */

    private List<Book> createFakeList() {
        List<Book> li = new LinkedList<>();
        Book b = new Book("Test Book", "Foo Bar", 999);
        li.add(b);
        b = new Book("Another One", "Rubber Ducky", 1);
        li.add(b);
        return li;
    }

}