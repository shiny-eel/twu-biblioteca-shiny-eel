package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

import java.util.HashMap;
import java.util.Map;

public class ActionManager {

    private Library lib;
    private IO io;
    private Map<Integer, Action> actions = new HashMap<>();
    private static final String INVALID_PROMPT = "Please select a valid option!";

    public ActionManager(Library lib, IO io) {
        this.io = io;
        this.lib = lib;
    }

    public void start() {
        createActions();
        while (true) {

            displayMenu();
            int id;
            try {
                id = getUserSelection();
            } catch (InvalidOptionException e) {
                io.println(INVALID_PROMPT);
                continue;
            }
            if (actions.containsKey(id))
                actions.get(id).execute();

        }
    }

    private void createActions() {

        actions.put(1, new ListBooksAction(lib, io));
        actions.put(2, new QuitAction(lib, io));

    }

    private int getUserSelection() throws InvalidOptionException {
        String in = io.getInput();
        int id;
        try {
            id = Integer.parseInt(in);
            if (!actions.containsKey(id))
                throw new InvalidOptionException();
        } catch (NumberFormatException e) {
            throw new InvalidOptionException();
        }
        return id;
    }

    private void displayMenu() {
        io.println("Select an option:");
        for (int i=1; i<=actions.size(); i++) {
            io.println(i + ". " + actions.get(i).getTitle());
        }
    }


}
