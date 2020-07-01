package com.twu.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class JSONReader {
    List<ReaderListener> listeners;
    List<Book> bookList;

    public JSONReader() {
        listeners = new LinkedList<>();
    }

    public void addListener(ReaderListener listener) {
        listeners.add(listener);
    }

    public void read(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            bookList = objectMapper.readValue(new File(path), BookList.class).books;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get book list.");
        }

        for (ReaderListener l : listeners) {
            l.onReadEvent();
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
