package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.item.Item;
import com.twu.biblioteca.io.IO;

import java.util.List;

public class ListMoviesAction extends ListItemsAction {


    public ListMoviesAction(IO io, Library lib) {
        super(io, lib);
    }

    @Override
    protected String getTitle() {
        return "List of movies";
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getMovieList();
    }
}
