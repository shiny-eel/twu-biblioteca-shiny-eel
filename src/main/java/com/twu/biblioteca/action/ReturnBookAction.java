package com.twu.biblioteca.action;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.io.IO;

public class ReturnBookAction extends Action {

    private static final String SUCCESS_MSG = "Thank you for returning the book\n";
    private static final String FAIL_MSG = "That is not a valid book to return.\n";
    private static final String PROMPT = "Enter a book title to return:";

    public ReturnBookAction(Library lib, IO io) {
        super(lib, io);
    }

    @Override
    String getTitle() {
        return "Return a book";
    }

    @Override
    void execute() {
        io.println(PROMPT);
        String bookTitle = io.getInput();
        bookTitle = bookTitle.toLowerCase();
        for (Book book : lib.getBookList()) {
            if (bookTitle.matches(book.getTitle().toLowerCase())) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    io.println(SUCCESS_MSG);
                    return;
                }
            }
        }
        io.println(FAIL_MSG);
    }
}
