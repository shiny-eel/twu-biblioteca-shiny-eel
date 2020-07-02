package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;

import java.util.List;

public class ActionManager {

    private BibliotecaApp app;
    private List<Action> actions;

    public ActionManager(BibliotecaApp app) {
        this.app = app;
    }

    public void start() {
        displayMenu();
    }


    private void displayMenu() {
        System.out.println("Select an option:");
//        for (Action action : actions) {
//            System.out.println(ac);
//        }
    }


}
