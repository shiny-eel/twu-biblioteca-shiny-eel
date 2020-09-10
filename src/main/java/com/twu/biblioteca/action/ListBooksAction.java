package com.twu.biblioteca.action;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class ListBooksAction extends ListItemsAction {


    public ListBooksAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return "List of books";
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getBookList();
    }

}
