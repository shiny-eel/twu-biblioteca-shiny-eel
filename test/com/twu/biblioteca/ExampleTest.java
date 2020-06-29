package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExampleTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @Test
    public void testWelcomeMessage() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        verify(out).println(expected);

    }
}
