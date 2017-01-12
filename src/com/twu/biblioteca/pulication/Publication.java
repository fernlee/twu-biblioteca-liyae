package com.twu.biblioteca;

public abstract class Publication {
    protected String name;
    protected String author;
    protected String year_published;
    protected boolean isCheckOut;
    protected String type;

    public Publication(String name, String author, String year_published) {
        this.name = name;
        this.author = author;
        this.year_published = year_published;
        isCheckOut = false;
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

    public boolean checkOut(){
        if (isCheckOut) return false;
        else{
            isCheckOut = true;
            return true;
        }
    }

    public boolean returnToLib(){
        if (isCheckOut){
            isCheckOut = false;
            return true;
        }
        else return true;
    }

    public boolean isCheckOut(){
        return isCheckOut;
    }

    public String getType(){
        return type;
    }
}
