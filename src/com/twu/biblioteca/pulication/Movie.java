package com.twu.biblioteca.pulication;

public class Movie extends Publication{
    private int rating;
    public static final int UNRATED = 0;

    public Movie(String name, String year, String director, int rating) {
        super(name,director,year);
        type = "movie";
        this.rating = rating;
    }
    public Movie(int id, String name, String year, String director, int rating) {
        super(id,name,director,year);
        type = "movie";
        this.rating = rating;
    }
    @Override
    public String toString() {
        return name + " " + year_published + " " + author + " " + rating;
    }


}
