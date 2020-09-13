package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.account.Registry;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ActionManagerTest {
    private ActionManager am;
    private BibliotecaApp mockApp;
    private Registry mockReg;
    private IOHarness ioHarness = new IOHarness();

    @Before
    public void setUp() throws Exception {
        mockApp = mock(BibliotecaApp.class);
        mockReg = mock(Registry.class);
        when(mockApp.getBookList()).thenReturn(ItemFactoryTest.createFakeBooks());
    }

    public void start(String input) {
        IO mockIO = ioHarness.createTestIO(input);
        am = new ActionManager(mockIO, mockApp, mockReg, mockApp);
        try {
            am.start();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testMenuDisplayOptions() { // Accounting for being logged off
        start("");
        String expected = "1. Login\n"
                + "2. List of books\n"
                + "3. List of movies\n"
                + "4. Quit";
        assertThat(ioHarness.getOutput(), containsString(expected));
    }

    @Test
    public void testMenuDisplayOptionsLoggedIn() { // Accounting for being logged in
        when(mockApp.isLoggedIn()).thenReturn(true);
        start("");
        String expected = "1. List of books\n"
                + "2. Checkout a book\n"
                + "3. Return a book\n"
                + "4. List of movies\n"
                + "5. Checkout a movie\n"
                + "6. View user information\n"
                + "7. Quit";
        assertThat(ioHarness.getOutput(), containsString(expected));
    }

    /**
     * "1. List of books\n"
     + "2. Checkout a book\n"
     + "3. Return a book\n"
     + "4. List of movies\n"
     + "5. Checkout a movie\n"
     + "6. Quit";
     */


    @Test
    public void testInvalidOptionSelect() {
        start("0");
        String invalid = "Please select a valid option!";
        assertThat(ioHarness.getOutput(), containsString(invalid));

    }

    @Test
    public void testQuitOptionSelect() {
        when(mockApp.isLoggedIn()).thenReturn(true);
        start("7"); // Assuming 6 is the quit option
        verify(mockApp).quit();
    }

    /**
     * May be needed in future
     * assertThat(mockIO.getLast(), is("Art of War | Sun Tzu | 500\n" +
     * "Infinite Jest | David Foster Wallace | 1996\n" +
     * "David and Goliath | Malcolm Gladwell | 2013"));
     */


}