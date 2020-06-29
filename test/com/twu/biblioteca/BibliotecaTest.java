package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    private PrintStream mockOut;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp.main(new String[]{});
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        verify(mockOut).println(expected);
    }

    @Test
    public void testShowBookTitle() {
        BibliotecaApp.main(new String[]{});
        verify(mockOut, atLeastOnce()).println(captor.capture());
        final List<String> capturedArgument = captor.getAllValues();
        assertThat(capturedArgument, hasItem(startsWith("Art of War")));
        assertThat(capturedArgument, hasItem(startsWith("Infinite Jest")));
        assertThat(capturedArgument, hasItem(startsWith("David and Goliath")));
    }

    @Test
    public void testShowBookTitleAuthorYear() {
        BibliotecaApp.main(new String[]{});
        verify(mockOut, atLeast(4)).println(captor.capture());
        final List<String> capturedArgument = captor.getAllValues();
        assertThat(capturedArgument, hasItem("Art of War | Sun Tzu | 500"));
        assertThat(capturedArgument, hasItem("Infinite Jest | David Foster Wallace | 1996"));
        assertThat(capturedArgument, hasItem("David and Goliath | Malcolm Gladwell | 2013"));
    }
}
