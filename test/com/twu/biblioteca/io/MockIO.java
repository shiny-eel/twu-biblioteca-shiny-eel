package com.twu.biblioteca.io;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class MockIO extends IO {

    public List<String> output = new LinkedList<>();
    public ArrayDeque<String> input = new ArrayDeque<>();

    public MockIO() {
        super();
    }

    public void addInput(String in){
        input.add(in);
    }

    @Override
    public String getInput() {
        return input.pollFirst();
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
