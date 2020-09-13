package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class CheckoutBookAction extends CheckoutItemAction {


    public CheckoutBookAction(IO io, Library lib) {
        super(io, lib);
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getBookList();
    }

    @Override
    protected String getTitle() {
        return "Checkout a book";
    }

    @Override
    String getItemType() {
        return "book";
    }
}

