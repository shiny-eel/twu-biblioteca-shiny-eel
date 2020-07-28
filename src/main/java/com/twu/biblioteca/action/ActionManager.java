package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.Printer;

import java.util.LinkedList;
import java.util.List;

public class ActionManager {

    private BibliotecaApp app;
    private Printer p;
    private List<Action> actions;

    public ActionManager(BibliotecaApp app, Printer p) {
        this.p = p;
        this.app = app;
    }

    public void start() {
        actions = new LinkedList<>();
        actions.add(new ListBooksAction(app));
        displayMenu();
    }


    private void displayMenu() {
        p.println("Select an option:");
        for (Action action : actions) {
            p.println(action.getTitle());
        }
    }


}
