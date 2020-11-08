package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class ReturnMovieAction extends ReturnItemAction {

    public ReturnMovieAction(IO io, Library lib) {
        super(io, lib);
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getMovieList();
    }

    @Override
    String getItemType() {
        return "movie";
    }
}
