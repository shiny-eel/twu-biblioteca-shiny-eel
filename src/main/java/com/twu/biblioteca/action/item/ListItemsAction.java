package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class ListItemsAction extends Action {

    private static final String SEPARATOR = "---------------------------------------------------------------------";
    protected static final String NO_ITEMS_MSG = "There are no items to display.";
    protected boolean ignoreUnavailable = true;

    Library lib;

    public ListItemsAction(IO io, Library lib) {
        super(io);
        this.lib = lib;
    }

    abstract List<Item> getItems();

    abstract void printHeaders();

    @Override
    protected void execute() {
        List<? extends Item> items = getItems();
        io.println(SEPARATOR);
        printHeaders();
        io.println(SEPARATOR);
        if (items.size() < 1)
                io.println(NO_ITEMS_MSG);
        for (Item item : items) {
            if (!ignoreUnavailable || item.isAvailable())
                io.println(item.toString());
        }
        io.println(SEPARATOR);
    }
}
