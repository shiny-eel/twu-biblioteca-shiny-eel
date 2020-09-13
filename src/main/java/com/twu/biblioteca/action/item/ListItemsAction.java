package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class ListItemsAction extends Action {

    private static final String SEPARATOR = "--------------------";
    Library lib;

    public ListItemsAction(IO io, Library lib) {
        super(io);
        this.lib = lib;
    }

    abstract List<? extends Item> getItems();

    @Override
    protected void execute() {
        List<? extends Item> items = getItems();
        io.println(SEPARATOR);
        for (Item item : items) {
            if (item.isAvailable())
                io.println(item.toString());
        }
        io.println(SEPARATOR);
    }
}
