package com.twu.biblioteca;

public class Movie {

    protected String title;
    protected String director;
    protected int year;
    protected int rating = 0;

    public Movie(String title, String director, int year, int rating) {
        this(title, director, year);
        this.rating = (rating >= 0 ? rating : 0);
    }

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }


    @Override
    public String toString() {
        String ratingStr = (rating == 0 ? "unrated" : String.valueOf(rating));
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append(" | ")
                .append(director)
                .append(" | ")
                .append(year)
                .append(" | ")
                .append(ratingStr);
        return sb.toString();
    }

}
