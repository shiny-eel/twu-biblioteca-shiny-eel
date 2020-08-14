package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitActionTest {


    @Test
    public void quitActionTest() {
        IOHarness harness = new IOHarness();
        Library mockLib = mock(Library.class);
        QuitAction quitAction = new QuitAction(mockLib, harness.createTestIO(""));
        quitAction.execute();

        verify(mockLib).quit();
    }

}