package com.twu.biblioteca.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class PasswordThread implements Runnable {
    private boolean done;
    public PasswordThread() {
    }

    @Override
    public void run() {
        char echo = '*';
        done = false;
//        String output = "";
//        InputStream is = System.in;
//        int oldPriority = Thread.currentThread().getPriority();
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        try {
            while (!done) {
//                output = output + (char) is.read();
                System.out.print("\010" + echo);
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
//                    return;
                }
            }
//        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
//            Thread.currentThread().setPriority(oldPriority);
        }
    }

    public void finish() {
        this.done = true;
    }
}
