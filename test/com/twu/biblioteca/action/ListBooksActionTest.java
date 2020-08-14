package com.twu.biblioteca.action;

import com.twu.biblioteca.BookFactoryTest;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksActionTest {

    @Test
    public void listBooksTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        when(mockLib.getBookList()).thenReturn(BookFactoryTest.createFakeList());
        ListBooksAction listBooksAction = new ListBooksAction(mockLib, harness.createTestIO(""));
        listBooksAction.execute();

        assertThat(harness.getOutput(), is("Test Book | Foo Bar | 999\n" + "Another One | Rubber Ducky | 1\n"));

    }

}