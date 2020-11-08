package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public abstract class ReturnItemAction extends Action {

    private static final String SUCCESS_MSG = "Thank you for returning the %s\n";
    private static final String FAIL_MSG = "That is not a valid %s to return.\n";
    private static final String PROMPT = "Enter a %s title to return:";
    private static final String TITLE = "Return a %s";

    protected Library lib;

    public ReturnItemAction(IO io, Library lib) {
        super(io);
        this.lib = lib;
        this.access = Access.RESTRICTED;
    }

    abstract List<? extends Item> getItems();

    abstract String getItemType();

    @Override
    protected String getTitle() {
        return String.format(TITLE, getItemType());
    }

    @Override
    protected void execute() {
        String itemType = getItemType();
        io.println(String.format(PROMPT, itemType));
        String itemTitle = io.getInput();
        itemTitle = itemTitle.toLowerCase();
        for (Item item : getItems()) {
            if (itemTitle.matches(item.getTitle().toLowerCase())) {
                if (!item.isAvailable()) {
                    item.returnItem();
                    io.println(String.format(SUCCESS_MSG, itemType));
                    return;
                }
            }
        }
        io.println(String.format(FAIL_MSG, itemType));
    }
}
