package com.twu.biblioteca;

import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private ByteArrayInputStream testIn;
    private IOHarness ioHarness = new IOHarness();
    private ByteArrayInputStream is;


    public void start(String input) {
        IO mockIO = ioHarness.createTestIO(input);
        BibliotecaApp app = new BibliotecaApp(mockIO);
        try {
            app.initialise();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testWelcomeMessage() {
        start("");
        String expected =
                "Welcome to Biblioteca. " +
                        "Your one-stop-shop for great book titles in Bangalore!";
        assertThat(ioHarness.getOutput(), startsWith(expected));
    }

    @Test
    public void testMenuPrompt() {
        start("");
        String expected = "Select an option:";
        assertThat(ioHarness.getOutput(), containsString(expected));

    }




}
