package com.twu.biblioteca.action;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Item;

import java.util.List;

public class CheckoutMovieAction extends  CheckoutItemAction {

    public CheckoutMovieAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    List<? extends Item> getItems() {
        return lib.getMovieList();
    }

    @Override
    String getItemType() {
        return "movie";
    }

    @Override
    String getTitle() {
        return "Checkout a movie";
    }
}
