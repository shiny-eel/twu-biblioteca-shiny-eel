package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class CheckoutItemAction extends Action {

    private static final String SUCCESS_MSG = "Thank you! Enjoy the %s\n";
    private static final String PROMPT = "Enter a %s title to checkout:";
    private static final String FAIL_MSG = "Sorry, that %s is not available";

    Library lib;
    Application app;

    public CheckoutItemAction(IO io, Library lib, Application app) {
        super(io);
        this.lib = lib;
        this.access = Access.RESTRICTED;
        this.app = app;
    }

    abstract List<? extends Item> getItems();

    abstract String getItemType();

    @Override
    protected void execute() {
        String itemType = getItemType();
        io.println(String.format(PROMPT, itemType));
        String requestTitle = io.getInput();
        requestTitle = requestTitle.toLowerCase();

        for (Item item : getItems()) {
            if (requestTitle.matches(item.getTitle().toLowerCase())) {
                if (item.isAvailable()) {
                    item.borrow(app.getCurrentUser());
                    io.println(String.format(SUCCESS_MSG, itemType));
                    return;

                }
            }
        }
        io.println(String.format(FAIL_MSG, itemType));

    }

}
