package com.twu.biblioteca.item;

import com.twu.biblioteca.account.User;

public abstract class Item {
    protected int year;
    protected String creator;
    private String title;
    private User borrower;

    public Item(String title, String creator, int year) {
        this.title = title;
        this.year = year;
        this.creator = creator;
    }

    public void borrow(User borrower) {
        this.borrower = borrower;
    }

    public void returnItem(){
        this.borrower = null;
    }

    public String getCreator() {
        return creator;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return borrower == null;
    }
    public User getBorrower() { return borrower; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append(" | ")
                .append(creator)
                .append(" | ")
                .append(year);
        return sb.toString();
    }
}
