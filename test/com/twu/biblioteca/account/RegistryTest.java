package com.twu.biblioteca.account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RegistryTest {

    @Test
    public void testGetUserAInfo()  {
        String id = "529-8334";
        String pass = "allblack99";
        String name = "Tana Umaga";
        Registry reg = new Registry();
        User u = reg.getUser(id);
        assertThat(u.getLibraryNum(), is(id));
        assertThat(u.getPassword(), is(pass));
        assertThat(u.getName(), is(name));
    }

    @Test
    public void testGetUserBInfo()  {
        String id = "126-0053";
        String pass = "matariki";
        String name = "Rangi Heke";
        Registry reg = new Registry();
        User u = reg.getUser(id);
        assertThat(u.getLibraryNum(), is(id));
        assertThat(u.getPassword(), is(pass));
        assertThat(u.getName(), is(name));
    }
}