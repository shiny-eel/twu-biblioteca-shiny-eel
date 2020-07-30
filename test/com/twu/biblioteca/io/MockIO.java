package com.twu.biblioteca.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MockIO extends IO {

    public List<String> output = new LinkedList<>();
    public String fullOutput = "";
    public ArrayDeque<String> input = new ArrayDeque<>();

    public MockIO() {
        super();
    }

    public void addInput(String in){
        input.add(in);
    }

    @Override
    public String getInput() {
        if (input.size() > 0)
            return input.pollFirst();

        throw(new NoInputGivenException());
    }

    public void setFileInput(String filePath) throws IOException {
        File file = new File(filePath);
        in = new Scanner(file);
    }


    public String getLast() {
        return output.get(output.size() - 1);
    }

    public String getLast(int i) {
        return output.get(output.size() - 1 - i);
    }

    public String get(int i) { return output.get(i); }

    @Override
    public void println(String x) {
        output.add(x);
        fullOutput += x + "\n";
        super.println(x);
    }
}
