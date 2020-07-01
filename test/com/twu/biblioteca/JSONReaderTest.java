package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JSONReaderTest {

    private BlockingListener listener;

    @Before
    public void setUp() throws Exception {
        listener = new BlockingListener();

    }

    @Test
    public void testReadJSON() throws Exception {
        JSONReader reader = new JSONReader();
        reader.addListener(listener);
        reader.read("resources/book-list.json");
        listener.waitForReader();
        assertThat(reader.bookList.get(0).title, is("Art of War"));
        assertThat(reader.bookList.get(1).title, is("Infinite Jest"));
        assertThat(reader.bookList.get(2).title, is("David and Goliath"));

    }
}