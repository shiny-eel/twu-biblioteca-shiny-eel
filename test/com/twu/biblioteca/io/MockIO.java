package com.twu.biblioteca.io;

import java.util.LinkedList;
import java.util.List;

public class MockIO extends IO {

    public List<String> output = new LinkedList<>();

    public MockIO() {
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
