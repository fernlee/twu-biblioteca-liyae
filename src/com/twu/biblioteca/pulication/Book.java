package com.twu.biblioteca;

public class Book extends Publication {

    public Book(String name, String author, String year_published) {
        super(name, author, year_published);
        type = "book";
    }

    public String toString(){ return getName() + " " + getName() + " " + getYear_published(); }

}
