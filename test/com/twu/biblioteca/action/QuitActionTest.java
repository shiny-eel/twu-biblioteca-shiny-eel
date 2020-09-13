package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.IOHarness;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitActionTest {


    @Test
    public void quitActionTest() {
        IOHarness harness = new IOHarness();
        BibliotecaApp mockBib = mock(BibliotecaApp.class);
        QuitAction quitAction = new QuitAction(harness.createTestIO(""), mockBib);
        quitAction.execute();

        verify(mockBib).quit();
    }

}