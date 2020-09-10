package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class ListItemsAction extends Action {

    private static final String SEPARATOR = "--------------------";

    public ListItemsAction(Library lib, IO io) {
        super(lib, io);
    }

    abstract List<? extends Item> getItems();

    @Override
    void execute() {
        List<? extends Item> items = getItems();
        io.println(SEPARATOR);
        for (Item item : items) {
            if (item.isAvailable())
                io.println(item.toString());
        }
        io.println(SEPARATOR);
    }
}
