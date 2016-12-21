package com.twu.biblioteca;

public class Book implements Publication{
    private String name;
    private String author;
    private String year_published;
    private boolean isCheckOut;
    private String type;

    public Book(String name, String author, String year_published) {
        this.name = name;
        this.author = author;
        this.year_published = year_published;
        isCheckOut = false;
        type = "book";
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear_published() {
        return year_published;
    }

    @Override
    public String getDetails(){ return name + " " + author + " " + year_published; }

    @Override
    public boolean checkOut(){
        if (isCheckOut) return false;
        else{
            isCheckOut = true;
            return true;
        }
    }
    @Override
    public boolean returnToLib(){
        if (isCheckOut){
            isCheckOut = false;
            return true;
        }
        else return true;
    }
    @Override
    public boolean isCheckOut(){
        return isCheckOut;
    }
    @Override
    public String getType(){
        return type;
    }
}
