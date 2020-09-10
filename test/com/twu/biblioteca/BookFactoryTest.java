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
        BookFactory factory = new BookFactory(mockApp);
        assertThat(factory.getBookList().get(0).getTitle(), is("Art of War"));
        assertThat(factory.getBookList().get(1).getTitle(), is("Infinite Jest"));
        assertThat(factory.getBookList().get(2).getTitle(), is("David and Goliath"));

    }

    @Test
    public void testBookAuthors() throws Exception {
        BookFactory factory = new BookFactory(mockApp);
        assertThat(factory.getBookList().get(0).getAuthor(), is("Sun Tzu"));
        assertThat(factory.getBookList().get(1).getAuthor(), is("David Foster Wallace"));
        assertThat(factory.getBookList().get(2).getAuthor(), is("Malcolm Gladwell"));

    }

    @Test
    public void testBookYears() throws Exception {
        BookFactory factory = new BookFactory(mockApp);
        assertThat(factory.getBookList().get(0).getYear(), is(500));
        assertThat(factory.getBookList().get(1).getYear(), is(1996));
        assertThat(factory.getBookList().get(2).getYear(), is(2013));

    }
}