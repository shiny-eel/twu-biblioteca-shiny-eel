package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class JSONReaderTest {

    private BlockingListener listener;
    private BibliotecaApp mockApp;

    @Before
    public void setUp() throws Exception {
        listener = new BlockingListener();
        mockApp = mock(BibliotecaApp.class);

    }


    @Test
    public void testReadJSON() throws Exception {
        JSONReader reader = new JSONReader(mockApp);
        reader.addListener(listener);
        reader.read("resources/book-list.json");
        listener.waitForReader();
        assertThat(reader.bookList.get(0).title, is("Art of War"));
        assertThat(reader.bookList.get(1).title, is("Infinite Jest"));
        assertThat(reader.bookList.get(2).title, is("David and Goliath"));

    }

    @Test
    public void testReadJSONDeep() throws Exception {
        JSONReader reader = new JSONReader(mockApp);
        reader.addListener(listener);
        reader.read("resources/book-list.json");
        listener.waitForReader();
        assertThat(reader.bookList.get(0).author, is("Sun Tzu"));
        assertThat(reader.bookList.get(1).author, is("David Foster Wallace"));
        assertThat(reader.bookList.get(2).author, is("Malcolm Gladwell"));

    }
}