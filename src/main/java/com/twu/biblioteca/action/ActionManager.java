package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

import java.util.HashMap;
import java.util.Map;

public class ActionManager {

    private static final String INVALID_PROMPT = "Please select a valid option!";
    private Library lib;
    private IO io;
    private Map<Integer, Action> actions = new HashMap<>();

    public ActionManager(Library lib, IO io) {
        this.io = io;
        this.lib = lib;
    }

    public void start() {
        createActions();
        while (true) { // Infinite loop for CLI menu

            displayMenu();
            String input = io.getInput();
            int id;

            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) { // Not a number
                io.println(INVALID_PROMPT);
                continue;
            }
            if (actions.containsKey(id)) {
                actions.get(id).execute();
            } else { // A number but not a valid option
                io.println(INVALID_PROMPT);
            }
        }
    }

    private void createActions() {
        actions.put(1, new ListBooksAction(lib, io));
        actions.put(2, new CheckoutBookAction(lib, io));
        actions.put(3, new ReturnBookAction(lib, io));
        actions.put(4, new ListMoviesAction(lib, io));
        actions.put(5, new QuitAction(lib, io));
    }

    private void displayMenu() {
        io.println("Select an option:");
        for (int i = 1; i <= actions.size(); i++) {
            io.println(i + ". " + actions.get(i).getTitle());
        }
    }


}
