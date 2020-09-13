package com.twu.biblioteca.account;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, User> userMap = new HashMap<>();

    public Registry() {
        createUsers();
    }

    public User getUser(String libraryNumber) {
        return userMap.get(libraryNumber);
    }

    private void createUsers() {
        User u = new User("Tana Umaga", "529-8334", "allblack99");
        userMap.put(u.getLibraryNum(), u);

        u = new User("Rangi Heke", "126-0053", "matariki");
        userMap.put(u.getLibraryNum(), u);
    }

}
