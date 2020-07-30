package com.twu.biblioteca;

import com.twu.biblioteca.action.ActionManager;
import com.twu.biblioteca.io.MockIO;
import com.twu.biblioteca.io.NoInputGivenException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    static final Logger logger = LogManager.getLogger(BibliotecaTest.class.getName());


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private ByteArrayInputStream testIn;

    private MockIO mockIO;

    @Before
    public void setUp() throws Exception {
        mockIO = new MockIO();
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp(mockIO);
        try {
            app.initialise();
        } catch (NoInputGivenException e) {}
        String expected =
                "Welcome to Biblioteca. " +
                        "Your one-stop-shop for great book titles in Bangalore!";
        assertThat(mockIO.fullOutput, startsWith(expected));
    }

    @Test
    public void testMenuPrompt() {
        BibliotecaApp app = new BibliotecaApp(mockIO);
        try {
            app.initialise();
        } catch (NoInputGivenException e) {}
        String expected = "Select an option:";
        assertThat(mockIO.fullOutput, containsString(expected));

    }


}
