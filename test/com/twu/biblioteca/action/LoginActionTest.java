package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.account.Registry;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginActionTest {

    @Test
    public void promptMessageTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("111-1111");
        BibliotecaApp app = new BibliotecaApp(io);
        Registry mockReg = mock(Registry.class);
        LoginAction action = new LoginAction(io, mockReg, app);
        try {
            action.execute();
        } catch (NoSuchElementException e) {
        }
        assertThat(harness.getOutput(), (containsString("Enter your library number:")));
        assertThat(harness.getOutput(), (containsString("Enter your password:")));
    }

    @Test
    public void successfulLoginTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("123-4567\nmypassword");
        BibliotecaApp app = new BibliotecaApp(io);

        LoginAction action = new LoginAction(io, createMockReg(), app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Login successful")));

        assertThat(app.isLoggedIn(), is(true));
    }

    @Test
    public void incorrectPasswordTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("123-4567\nincorrectpassword");
        BibliotecaApp app = new BibliotecaApp(io);

        LoginAction action = new LoginAction(io, createMockReg(), app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Login failed")));
    }

    @Test
    public void incorrectIDTest() {
        IOHarness harness = new IOHarness();
        IO io = harness.createTestIO("123-9999\nincorrectpassword");
        BibliotecaApp app = new BibliotecaApp(io);

        LoginAction action = new LoginAction(io, createMockReg(), app);
        action.execute();

        assertThat(harness.getOutput(), (containsString("Login failed")));
    }

    private static Registry createMockReg() {
        Registry mockReg = mock(Registry.class);
        User u = new User("Tane", "123-4567", "mypassword");
        when(mockReg.getUser("123-4567")).thenReturn(u);
        return mockReg;
    }

}