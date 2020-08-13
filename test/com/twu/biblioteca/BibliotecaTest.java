package com.twu.biblioteca;

import com.twu.biblioteca.io.IO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private ByteArrayInputStream testIn;

    private ByteArrayInputStream is;
    private OutputStream out;


    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    public void start(String input) {
        is = new ByteArrayInputStream(input.getBytes());
        IO mockIO = new IO(is, new PrintStream(out));
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
        assertThat(out.toString(), startsWith(expected));
    }

    @Test
    public void testMenuPrompt() {
        start("");
        String expected = "Select an option:";
        assertThat(out.toString(), containsString(expected));

    }


}
