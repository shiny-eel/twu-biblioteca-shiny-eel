package com.twu.biblioteca;

import com.twu.biblioteca.io.IO;

public class Main {

    public static void main(String[] args) {
        new BibliotecaApp(new IO(System.in, System.out)).initialise();
    }

}
