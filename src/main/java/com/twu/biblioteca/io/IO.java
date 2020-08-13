package com.twu.biblioteca.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IO {
    Scanner in;
    PrintStream out;

    public IO(InputStream inputStream, PrintStream outStream) {
        in = new Scanner(inputStream);
        out = outStream;
    }

    public void println(String s) {
        out.println(s);
    }

    public String getInput() {
        return in.nextLine();
    }

}
