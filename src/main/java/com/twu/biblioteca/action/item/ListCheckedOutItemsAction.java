package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Item;
import com.twu.biblioteca.item.Movie;

import java.util.LinkedList;
import java.util.List;

public class ListCheckedOutItemsAction extends ListItemsAction {

    private Application app;

    public ListCheckedOutItemsAction(IO io, Library lib, Application app) {
        super(io, lib);
        this.app = app;
        this.access = Access.RESTRICTED;
        ignoreUnavailable = false;
    }

    @Override
    List<Item> getItems() {
        List<Item> itemList = new LinkedList<>();
        for (Book book: lib.getBookList()) {
            if (!book.isAvailable() && book.getBorrower().equals(app.getCurrentUser()))
                itemList.add(book);
        }
        for (Movie movie: lib.getMovieList()) {
            if (!movie.isAvailable() && movie.getBorrower().equals(app.getCurrentUser()))
                itemList.add(movie);
        }

        return itemList;
    }

    @Override
    protected String getTitle() {
        return null;
//        return "List checked-out items";
    }
}
