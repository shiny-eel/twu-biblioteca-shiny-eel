package com.twu.biblioteca.io;

import java.util.Scanner;

public class IO {
    Scanner in;

    private static IO singleton = new IO();

    protected IO() {
        in = new Scanner(System.in);
    }

    public static IO get() {
        return singleton;
    }

    public void println(String s) {
        System.out.println(s);
    }

    public String getInput() {
        return in.nextLine();
    }

}
