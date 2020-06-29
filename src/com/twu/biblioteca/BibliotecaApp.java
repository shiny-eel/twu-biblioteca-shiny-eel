package com.twu.biblioteca;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().initialise();
    }

    public void initialise() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        List<String> books = getBookList();
        displayBookList(books);
    }


    private List<String> getBookList() {
        List<String> books = new LinkedList<>();
        try {

        Object obj = new JSONParser().parse(new FileReader("res/book-list.json"));
        JSONObject jo = (JSONObject) obj;
        JSONArray bookArray = ((JSONArray)jo.get("books"));
        Iterator bookItr = bookArray.iterator();
        while (bookItr.hasNext()) {
            Iterator<Map.Entry> fieldItr = ((Map) bookItr.next()).entrySet().iterator();
            while(fieldItr.hasNext()) {
                Map.Entry pair = fieldItr.next();
                books.add((String) pair.getValue());
            }
        }
        } catch (Exception e) {
//            books.add("");
            System.out.println(e.getMessage());
            System.out.println("Failed to get book list.");
        }
        return books;
    }
    private void displayBookList(List<String> books) {
        for(String title : books) {
        System.out.println(title);
        }
    }
}
