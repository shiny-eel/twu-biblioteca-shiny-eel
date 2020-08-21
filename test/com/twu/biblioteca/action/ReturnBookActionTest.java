package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookActionTest {

    @Test
    public void callReturnTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        String book = "Test Book";
        IO io = harness.createTestIO(book);
        ReturnBookAction action = new ReturnBookAction(mockLib, io);
        action.execute();
        verify(mockLib).returnBook(book);

    }



}