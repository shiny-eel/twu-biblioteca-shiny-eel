package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Item;

import java.util.LinkedList;
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
    void printHeaders() {
        io.println(Book.getHeader());
    }

    @Override
    List<Item> getItems() {
        List<Item> itemList = new LinkedList<>();
        itemList.addAll(lib.getBookList());
        return itemList;
    }

}
