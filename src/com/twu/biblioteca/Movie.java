package com.twu.biblioteca;

public class Movie extends Publication{
    private int rating;
    public static final int UNRATED = 0;

    public Movie(String name, String year, String director, int rating) {
        super(name,director,year);
        type = "movie";
        this.rating = rating;
    }

    public String getDetails() {
        return name + " " + year_published + " " + author + " " + rating;
    }

}
