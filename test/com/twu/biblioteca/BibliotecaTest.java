package com.twu.biblioteca;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    private PrintStream mockOut;
    private JSONReader mockReader;
    private ArgumentCaptor<Object> bookArgumentCaptor = ArgumentCaptor.forClass(Object.class);
    private BlockingListener listener;

    @Before
    public void setUp() throws Exception {
        listener = new BlockingListener();
        mockReader = mock(JSONReader.class);
        when(mockReader.getBookList()).thenReturn(createFakeList());

        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp.main(new String[]{});
        String expected =
                "Welcome to Biblioteca. " +
                        "Your one-stop-shop for great book titles in Bangalore!";
        verify(mockOut).println(expected);
    }

    @Test
    public void testMenuPrompt() {
        BibliotecaApp.main(new String[]{});
        String expected = "Select an option:";
        ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);
        verify(mockOut, atLeastOnce()).println(cap.capture());
        final List<String> capturedArgument = cap.getAllValues();
        assertThat(capturedArgument.get(1).toString(), is(expected));

    }

    @Test
    public void testShowBookTitle() throws InterruptedException {
        BibliotecaApp app = new BibliotecaApp();
        app.reader = mockReader;
        app.onReadEvent();
        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
        assertThat(capturedArgument.get(0).toString(), startsWith("Test Book"));

    }

    @Test
    public void testShowBookTitleAuthorYear() throws InterruptedException {
        BibliotecaApp app = new BibliotecaApp();
        app.reader = mockReader;
        app.onReadEvent();
        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
        assertThat(capturedArgument.get(0).toString(),
                is("Test Book | Foo Bar | 999"));
    }


    @Test
    public void testMultipleBooksDisplay() throws InterruptedException {
        BibliotecaApp app = new BibliotecaApp();
        app.reader = mockReader;
        app.onReadEvent();
        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
        assertThat(capturedArgument.get(1).toString(),
                is("Another One | Rubber Ducky | 1"));
    }


    private List<Book> createFakeList() {
        List<Book> li = new LinkedList<>();
        Book b = new Book();
        b.year = 999;
        b.title = "Test Book";
        b.author = "Foo Bar";
        li.add(b);
        b = new Book();
        b.year = 1;
        b.title = "Another One";
        b.author = "Rubber Ducky";
        li.add(b);
        return li;
    }
}
