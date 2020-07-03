package com.twu.biblioteca.io;

public class Printer {

    private static Printer singleton = new Printer();

    protected Printer() {

    }

    public static Printer get() {
        return singleton;
    }

    public void println(String s) {
        System.out.println(s);
    }

}
