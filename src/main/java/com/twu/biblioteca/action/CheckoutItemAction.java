package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class CheckoutItemAction extends Action {

    private static final String SUCCESS_MSG = "Thank you! Enjoy the %s\n";
    private static final String PROMPT = "Enter a %s title to checkout:";
    private static final String FAIL_MSG = "Sorry, that %s is not available";

    public CheckoutItemAction(Library lib, IO io) {
        super(lib, io);
    }

    abstract List<? extends Item> getItems();
    abstract String getItemType();

    @Override
    void execute() {
        io.println(String.format(PROMPT, getItemType()));
        String requestTitle = io.getInput();
        requestTitle = requestTitle.toLowerCase();
        for (Item item: getItems()) {
            if (requestTitle.matches(item.getTitle().toLowerCase())) {
                if (item.isAvailable()) {
                    item.setAvailable(false);
                    io.println(String.format(SUCCESS_MSG, getItemType()));
                    return;

                }
            }
        }
        io.println(String.format(FAIL_MSG, getItemType()));

    }

}
