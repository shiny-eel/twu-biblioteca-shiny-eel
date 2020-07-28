package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.MockIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private ByteArrayInputStream testIn;

    private MockIO mockOut;
    private BookFactory mockReader;
    private ArgumentCaptor<Object> bookArgumentCaptor = ArgumentCaptor.forClass(Object.class);

    @Before
    public void setUp() throws Exception {
        mockReader = mock(BookFactory.class);
        when(mockReader.getBookList()).thenReturn(createFakeList());

        mockOut = new MockIO();
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp(mockOut);
        app.initialise();
        String expected =
                "Welcome to Biblioteca. " +
                        "Your one-stop-shop for great book titles in Bangalore!";
        assertThat(mockOut.get(0), is(expected));
    }

    @Test
    public void testMenuPrompt() {
        BibliotecaApp app = new BibliotecaApp(mockOut);
        app.initialise();
        String expected = "Select an option:";
        assertThat(mockOut.get(1).toString(), is(expected));

    }

    @Test
    public void testMenuDisplayOption() {
        BibliotecaApp mockApp = mock(BibliotecaApp.class);
        ActionManager am = new ActionManager(mockApp, mockOut);
        am.start();
        assertThat(mockOut.getLast(), is("1. List of books"));
    }

    @Test
    public void testSelectListBooks() {
        BibliotecaApp mockApp = mock(BibliotecaApp.class);
//        when(mockApp.re()).thenReturn(createFakeList());

        ActionManager am = new ActionManager(mockApp, mockOut);
        am.start();
        giveInput("1\n");
        assertThat(mockOut.getLast(), is("Art of War | Sun Tzu | 500\n" +
                "Infinite Jest | David Foster Wallace | 1996\n" +
                "David and Goliath | Malcolm Gladwell | 2013"));
    }

    private void giveInput(String in){
        testIn = new ByteArrayInputStream(in.getBytes());
        System.setIn(testIn);
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
