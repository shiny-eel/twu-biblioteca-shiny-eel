package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class ListBooksAction extends ListItemsAction {


    public ListBooksAction(IO io, Library lib) {
        super(io, lib);
    }

    @Override
    protected String getTitle() {
        return "List of books";
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getBookList();
    }

}
