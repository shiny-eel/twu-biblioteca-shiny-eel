package com.twu.biblioteca.item;

public class Movie extends Item {

    private int rating = 0;

    public Movie(String title, String director, int year, int rating) {
        super(title, director, year);
        this.rating = (rating >= 0 ? rating : 0);
    }

    public Movie(String title, String director, int year) {
        super(title, director, year);

    }

    public String getDirector() {
        return creator;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        String ratingStr = (rating == 0 ? "unrated" : String.valueOf(rating));
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" | ")
                .append(ratingStr);
        return sb.toString();
    }

}
