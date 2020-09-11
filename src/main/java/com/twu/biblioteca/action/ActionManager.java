package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.item.*;
import com.twu.biblioteca.io.IO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ActionManager {

    private static final String INVALID_PROMPT = "Please select a valid option!";
    private Library lib;
    private Application app;
    private IO io;
    private List<Action> actions = new LinkedList<>();
    private Map<Integer, Action> availableActions = new HashMap<>();

    public ActionManager(Library lib, IO io, Application app) {
        this.io = io;
        this.lib = lib;
        this.app = app;
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
            if (availableActions.containsKey(id)) {
                availableActions.get(id).execute();
            } else { // A number but not a valid option
                io.println(INVALID_PROMPT);
            }
        }
    }

    private void createActions() {
        actions.add(new LoginAction(lib, io));
        actions.add(new ListBooksAction(lib, io));
        actions.add(new CheckoutBookAction(lib, io));
        actions.add(new ReturnBookAction(lib, io));
        actions.add(new ListMoviesAction(lib, io));
        actions.add(new CheckoutMovieAction(lib, io));
        actions.add(new QuitAction(lib, io, app));
    }

    private void displayMenu() {
        io.println("Select an option:");
        availableActions.clear();
        boolean isLoggedOn = app.isLoggedOn();
        int id = 1;
        for (Action action : actions) {
            if (isLoggedOn | action.access == Action.Access.PUBLIC) {
                availableActions.put(id, action);
                io.println(id + ". " + action.getTitle());
                id++;
            }
        }
    }


}
