package com.twu.biblioteca.action;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.account.Registry;
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
    private Registry reg;
    private List<Action> actions = new LinkedList<>();
    private Map<Integer, Action> availableActions = new HashMap<>();

    public ActionManager(IO io, Library lib, Registry reg, Application app) {
        this.io = io;
        this.lib = lib;
        this.app = app;
        this.reg = reg;

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
        actions.add(new LoginAction(io, reg, app));
        actions.add(new ListBooksAction(io, lib));
        actions.add(new CheckoutBookAction(io, lib));
        actions.add(new ReturnBookAction(io, lib));
        actions.add(new ListMoviesAction(io, lib));
        actions.add(new CheckoutMovieAction(io, lib));
        actions.add(new ViewInfoAction(io, app));
        actions.add(new QuitAction(io, app));
    }

    private void displayMenu() {
        io.println("Select an option:");
        availableActions.clear();
        boolean isLoggedIn = app.isLoggedIn();
        int id = 1;
        for (Action action : actions) {
            if (isLoggedIn && action.access == Action.Access.PUBLIC_ONLY)
                continue; // Do not allow another login
            if (isLoggedIn | action.access != Action.Access.RESTRICTED) {
                availableActions.put(id, action);
                io.println(id + ". " + action.getTitle());
                id++;
            }
        }
    }


}
