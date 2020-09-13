package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.account.Registry;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.action.item.ListMoviesAction;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ViewInfoActionTest {


    @Test
    public void titleTest() {
        IOHarness harness = new IOHarness();
        BibliotecaApp app = mock(BibliotecaApp.class);
        ViewInfoAction action = new ViewInfoAction(harness.createTestIO(""), app);
        assertThat(action.getTitle(), is("View user information"));
    }


    @Test
    public void infoDisplayedTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("");
        BibliotecaApp app = mock(BibliotecaApp.class);
        when(app.getCurrentUser()).thenReturn(createUser());

        ViewInfoAction action = new ViewInfoAction(io, app);
        action.execute();

        String expected = "Tana Umaga\n"
                + "runstraight@tmail.com\n"
                + "123 45678\n";
        assertThat(harness.getOutput(), containsString(expected));

    }

    private User createUser() {
        User u = new User("Tana Umaga", "11", "abc");
        u.setDetails("runstraight@tmail.com", "123 45678");
        return u;
    }

}