package com.twu.biblioteca;

public class Movie implements Publication {
    private String name;
    private String year;
    private String director;
    private int rating;
    private boolean isCheckOut;
    private String type;
    public static final int UNRATED = 0;

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        isCheckOut = false;
        type = "movie";
    }

    @Override
    public String getDetails() {
        return name + " " + year + " " + director + " " + rating;
    }

    @Override
    public boolean isCheckOut() {
        return isCheckOut;
    }

    @Override
    public boolean checkOut() {
        if (isCheckOut) return false;
        else{
            isCheckOut = true;
            return true;
        }
    }

    @Override
    public boolean returnToLib() {
        return false;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getType(){
        return type;
    }
}