package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class ReturnBookAction extends ReturnItemAction {



    public ReturnBookAction(IO io, Library lib) {
        super(io, lib);
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getBookList();
    }

    @Override
    String getItemType() {
        return "book";
    }


}
