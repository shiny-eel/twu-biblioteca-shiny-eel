package com.twu.biblioteca.action.item;

import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.action.item.ListBooksAction;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListBooksActionTest {

    @Test
    public void listBooksTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        when(mockLib.getBookList()).thenReturn(ItemFactoryTest.createFakeBooks());
        ListBooksAction listBooksAction = new ListBooksAction(mockLib, harness.createTestIO(""));
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString("Test Book | Foo Bar | 999\n" + "Another One | Rubber Ducky | 1\n"));

    }

    @Test
    public void ignoreCheckedOutBookTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        List<Book> books = ItemFactoryTest.createFakeBooks();
        books.get(0).setAvailable(false);
        when(mockLib.getBookList()).thenReturn(books);
        ListBooksAction listBooksAction = new ListBooksAction(mockLib, harness.createTestIO(""));
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString("Another One | Rubber Ducky | 1\n"));
        assertThat(harness.getOutput(), not(containsString("Test Book | Foo Bar | 999\n")));


    }

}