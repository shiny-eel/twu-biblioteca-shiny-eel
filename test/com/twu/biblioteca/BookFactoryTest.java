package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BookFactoryTest {

    private BibliotecaApp mockApp;

    public static List<Book> createFakeList() {
        List<Book> li = new LinkedList<>();
        Book b = new Book("Test Book", "Foo Bar", 999);
        li.add(b);
        b = new Book("Another One", "Rubber Ducky", 1);
        li.add(b);
        return li;
    }

    @Before
    public void setUp() throws Exception {
        mockApp = mock(BibliotecaApp.class);

    }

    @Test
    public void testBookTitles() throws Exception {
        BookFactory reader = new BookFactory(mockApp);
        reader.createBooks();
        assertThat(reader.getBookList().get(0).title, is("Art of War"));
        assertThat(reader.getBookList().get(1).title, is("Infinite Jest"));
        assertThat(reader.getBookList().get(2).title, is("David and Goliath"));

    }

    @Test
    public void testBookAuthors() throws Exception {
        BookFactory reader = new BookFactory(mockApp);
        reader.createBooks();
        assertThat(reader.getBookList().get(0).author, is("Sun Tzu"));
        assertThat(reader.getBookList().get(1).author, is("David Foster Wallace"));
        assertThat(reader.getBookList().get(2).author, is("Malcolm Gladwell"));

    }

    @Test
    public void testBookYears() throws Exception {
        BookFactory reader = new BookFactory(mockApp);
        reader.createBooks();
        assertThat(reader.getBookList().get(0).year, is(500));
        assertThat(reader.getBookList().get(1).year, is(1996));
        assertThat(reader.getBookList().get(2).year, is(2013));

    }
}