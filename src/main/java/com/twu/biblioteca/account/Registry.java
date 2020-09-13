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
        User u = new User("Tana Umaga", "111-2222", "allblack");
        u.setDetails("runstraight@tmail.com", "123 45678");
        userMap.put(u.getLibraryNum(), u);

        u = new User("Rangi Heke", "126-0053", "matariki");
        u.setDetails("taonga@bmail.com", "888 5555");

        userMap.put(u.getLibraryNum(), u);
    }

}
