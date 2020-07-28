package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.IO;

import java.util.LinkedList;
import java.util.List;

public class ActionManager {

    private BibliotecaApp app;
    private IO p;
    private List<Action> actions;

    public ActionManager(BibliotecaApp app, IO p) {
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
        int counter = 1;
        for (Action action : actions) {
            p.println(counter + ". " + action.getTitle());
            counter++;
        }
    }


}
