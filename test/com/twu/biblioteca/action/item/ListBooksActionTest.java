package com.twu.biblioteca.action.item;

import com.twu.biblioteca.ItemFactoryTest;
import com.twu.biblioteca.account.User;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListBooksActionTest {

    IOHarness harness;
    Library lib;

    @Before public void setUp(){
        harness = new IOHarness();
        lib = mock(Library.class);

    }

    @Test
    public void listBooksTest() {
        when(lib.getBookList()).thenReturn(ItemFactoryTest.createFakeBooks());
        ListBooksAction listBooksAction = new ListBooksAction(harness.createTestIO(""), lib);
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString(
                "Test Book             | Foo Bar               |  999\n" +
                "Another One           | Rubber Ducky          |    1\n"));

    }

    @Test
    public void columnTitleTest() {
        when(lib.getBookList()).thenReturn(ItemFactoryTest.createFakeBooks());
        ListBooksAction listBooksAction = new ListBooksAction(harness.createTestIO(""), lib);
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString(
                "Title                 | Author                | Year"));

    }

    @Test
    public void ignoreCheckedOutBookTest() {
        List<Book> books = ItemFactoryTest.createFakeBooks();
        books.get(0).borrow(mock(User.class));
        when(lib.getBookList()).thenReturn(books);

        ListBooksAction listBooksAction = new ListBooksAction(harness.createTestIO(""), lib);
        listBooksAction.execute();

        assertThat(harness.getOutput(), containsString(
                "Another One           | Rubber Ducky          |    1\n"));
        assertThat(harness.getOutput(), not(containsString("Test Book")));


    }

}