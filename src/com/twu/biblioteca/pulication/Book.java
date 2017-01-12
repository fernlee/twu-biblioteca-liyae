package com.twu.biblioteca.pulication;

public class Book extends Publication {
    public Book(String name, String author, String year_published) {
        super(name, author, year_published);
        type = "book";

    }
    public Book(int id, String name, String author, String year_published) {
        super(id,name, author, year_published);
        type = "book";
    }
    @Override
    public String toString(){ return getName() + " " + getAuthor() + " " + getYear_published(); }

}
