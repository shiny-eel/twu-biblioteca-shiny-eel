package com.twu.biblioteca.action.item;

import com.twu.biblioteca.Application;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.action.Action;
import com.twu.biblioteca.io.IO;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Item;
import com.twu.biblioteca.item.Movie;

import java.util.LinkedList;
import java.util.List;

public class ListCheckedOutItemsAction extends Action {

    private Application app;
    private Library lib;
    private ListBooksAction listBooksAction;
    private ListMoviesAction listMoviesAction;

    public ListCheckedOutItemsAction(IO io, Library lib, Application app) {
        super(io);
        this.lib = lib;
        this.app = app;
        this.access = Access.RESTRICTED;
    }


    private List<Item> getFilteredItems(List<? extends Item> items) {
        List<Item> output = new LinkedList<>();
        for (Item item: items) {
            if (!item.isAvailable() && item.getBorrower().equals(app.getCurrentUser()))
                output.add(item);
        }
        return output;
    }

    private ListBooksAction createListBooksAction() {
        ListBooksAction action = new ListBooksAction(io, lib){
            @Override
            List<Item> getItems() {

                return getFilteredItems(lib.getBookList());
            }
        };
        action.ignoreUnavailable = false;
        return action;
    }

    private ListMoviesAction createListMoviesAction() {
        ListMoviesAction action = new ListMoviesAction(io, lib){
            @Override
            List<Item> getItems() {
                return getFilteredItems(lib.getMovieList());
            }
        };
        action.ignoreUnavailable = false;
        return action;
    }

    @Override
    protected void execute() {
        listBooksAction = createListBooksAction();
        listMoviesAction = createListMoviesAction();
        listBooksAction.execute();
        listMoviesAction.execute();
    }

    @Override
    protected String getTitle() {
        return "List your checked out items";
    }
}
