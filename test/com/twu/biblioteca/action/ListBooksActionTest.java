package com.twu.biblioteca.action;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookFactoryTest;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.not;
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

        assertThat(harness.getOutput(), containsString("Test Book | Foo Bar | 999\n" + "Another One | Rubber Ducky | 1\n"));

    }

    @Test
    public void ignoreCheckedOutBookTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        List<Book> books = BookFactoryTest.createFakeList();
        books.get(0).setAvailable(false);
        when(mockLib.getBookList()).thenReturn(books);
        ListBooksAction listBooksAction = new ListBooksAction(mockLib, harness.createTestIO(""));
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString("Another One | Rubber Ducky | 1\n"));
        assertThat(harness.getOutput(), not(containsString( "Test Book | Foo Bar | 999\n")));


    }

}