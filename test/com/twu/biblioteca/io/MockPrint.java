package com.twu.biblioteca.io;

import com.twu.biblioteca.io.Printer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class MockPrint extends Printer {

    public List<String> output = new LinkedList<>();

    public MockPrint() {
        super();
    }

    public String getLast() {
        return output.get(output.size() - 1);
    }
    public String get(int i) { return output.get(i); }

    @Override
    public void println(String x) {
        output.add(x);
        super.println(x);
    }
}
