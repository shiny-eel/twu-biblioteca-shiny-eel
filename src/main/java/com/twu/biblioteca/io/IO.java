package com.twu.biblioteca.io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class IO {
    Scanner in;
    PrintStream out;
    InputStream is;
    public IO(InputStream inputStream, PrintStream outStream) {
        is = inputStream;
        in = new Scanner(inputStream);
        out = outStream;
    }

    public void println(String s) {
        out.println(s);
    }

    public String getInput() {
        return in.nextLine();
    }

    public String readPassword(String prompt) {
        String password = "";
        PasswordThread pt = new PasswordThread();
        Thread mask = new Thread(pt);
        mask.start();
        password =  in.nextLine();
        pt.finish();
        return password;
    }

    public static final String getPassword() {
        PasswordThread maskingThread = new PasswordThread();
        Thread thread = new Thread(maskingThread);
        thread.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String output = "none found";

        try {
            output = in.readLine();
//            System.out.println(output);

        } catch (IOException e) {
            output = "fail";
        }
        maskingThread.finish();

        return output;
    }
}
