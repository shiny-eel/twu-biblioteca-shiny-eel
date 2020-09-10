package com.twu.biblioteca.item;

public abstract class Item {
    private String title;
    protected int year;
    protected String creator;
    private boolean isAvailable;

    public Item(String title, String creator, int year) {
        this.title = title;
        this.year = year;
        this.creator = creator;
        isAvailable = true;
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
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

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
