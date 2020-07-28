package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.MockPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    private MockPrint mockOut;
    private BookFactory mockReader;
    private ArgumentCaptor<Object> bookArgumentCaptor = ArgumentCaptor.forClass(Object.class);
    private BlockingListener listener;

    @Before
    public void setUp() throws Exception {
        listener = new BlockingListener();
        mockReader = mock(BookFactory.class);
        when(mockReader.getBookList()).thenReturn(createFakeList());

        mockOut = new MockPrint();
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
        assertThat(mockOut.output.get(1), is("List of books"));
    }
//
//    @Test
//    public void testShowBookTitle() throws InterruptedException {
//        BibliotecaApp app = new BibliotecaApp();
//        app.reader = mockReader;
//        app.onReadEvent();
//        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
//        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
//        assertThat(capturedArgument.get(0).toString(), startsWith("Test Book"));
//
//    }
//
//    @Test
//    public void testShowBookTitleAuthorYear() throws InterruptedException {
//        BibliotecaApp app = new BibliotecaApp();
//        app.reader = mockReader;
//        app.onReadEvent();
//        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
//        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
//        assertThat(capturedArgument.get(0).toString(),
//                is("Test Book | Foo Bar | 999"));
//    }
//
//
//    @Test
//    public void testMultipleBooksDisplay() throws InterruptedException {
//        BibliotecaApp app = new BibliotecaApp();
//        app.reader = mockReader;
//        app.onReadEvent();
//        verify(mockOut, atLeastOnce()).println(bookArgumentCaptor.capture());
//        final List<Object> capturedArgument = bookArgumentCaptor.getAllValues();
//        assertThat(capturedArgument.get(1).toString(),
//                is("Another One | Rubber Ducky | 1"));
//    }


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
