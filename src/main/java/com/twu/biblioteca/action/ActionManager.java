package com.twu.biblioteca.action;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.io.IO;

import java.util.LinkedList;
import java.util.List;

public class ActionManager {

    private BibliotecaApp app;
    private IO io;
    private List<Action> actions;

    public ActionManager(BibliotecaApp app, IO io) {
        this.io = io;
        this.app = app;
    }

    public void start() {
        actions = new LinkedList<>();
        actions.add(new ListBooksAction(app, io));
        displayMenu();
        String in = io.getInput();
        int id = Integer.parseInt(in);
        for (Action action : actions) {
            if (action.matches(id)) {
                action.execute();
                break;
            }

        }


    }


    private void displayMenu() {
        io.println("Select an option:");
        int counter = 1;
        for (Action action : actions) {
            io.println(counter + ". " + action.getTitle());
            action.setId(counter);
            counter++;
        }
    }


}
