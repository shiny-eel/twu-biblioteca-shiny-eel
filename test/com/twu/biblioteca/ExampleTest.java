package com.twu.biblioteca;

import org.junit.Rule;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExampleTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<List<String>> captor;


    @Test
    public void testWelcomeMessage() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        BibliotecaApp.main(new String[]{});
        verify(out, times(1)).println(captor.capture());
        List<String> args = captor.getValue();
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(args.get(0), is(expected));
    }
}
