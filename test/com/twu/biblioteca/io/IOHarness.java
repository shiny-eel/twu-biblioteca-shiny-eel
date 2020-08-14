package com.twu.biblioteca.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IOHarness {
    ByteArrayOutputStream os;

    public IO createTestIO(String input) {
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());
        os = new ByteArrayOutputStream();
        return new IO(is, new PrintStream(os));
    }

    public void clearOutput() {
        os.reset();
    }

    public String getOutput() {
        return os.toString();
    }
}
