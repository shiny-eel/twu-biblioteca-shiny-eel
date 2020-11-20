package com.twu.biblioteca.io;

import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IO {
    private Scanner in;
    private PrintStream out;
//    private Console console;
    public IO(InputStream inputStream, PrintStream outStream) {
        in = new Scanner(inputStream);
        out = outStream;
//        this.console = console;
    }

    public void println(String s) {
        out.println(s);
    }

    public String getInput() {
        return in.nextLine();
    }

    public String getInputHidden() {
        Console console = System.console();
        if (console == null) {
            out.println("Error with system console.");
            return null;
        }

        return new String(console.readPassword());
    }

}
