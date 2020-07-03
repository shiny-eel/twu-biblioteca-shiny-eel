package com.twu.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twu.biblioteca.io.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class JSONReader {
    List<ReaderListener> listeners;
    List<Book> bookList;
    BibliotecaApp app;
    static final Logger log = LogManager.getLogger(JSONReader.class.getName());


    public JSONReader(BibliotecaApp app) {
        listeners = new LinkedList<>();
        this.app = app;
    }

    public void addListener(ReaderListener listener) {
        listeners.add(listener);
    }

    public void read(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            bookList = objectMapper.readValue(new File(path), BookList.class).books;

        } catch (Exception e) {
            log.error("Failed to get book list.");
            log.debug(e.getMessage());
        }

        for (ReaderListener l : listeners) {
            l.onReadEvent();
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
