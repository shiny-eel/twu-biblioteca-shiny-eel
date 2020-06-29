package com.twu.biblioteca;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().initialise();
    }

    public void initialise() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        List<Book> books = getBookList();
        displayBookList(books);
    }

    private List<Book> getBookList() {
        String path = "resources/book-list.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType javaType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Book.class);
//            List<Book> bookList = objectMapper.readValue(new File(path), javaType);

            BookList bookList = objectMapper.readValue(new File(path), BookList.class);

            //            Gson mGson = new Gson();
//            BookList bookList = mGson.fromJson(json, BookList.class);
            return bookList.books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get book list.");
            return null;
        }

    }

    private void displayBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
