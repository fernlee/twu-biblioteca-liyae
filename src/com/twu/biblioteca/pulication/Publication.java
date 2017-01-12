package com.twu.biblioteca.pulication;

public abstract class Publication {
    protected String name;
    protected String author;
    protected String year_published;
    protected boolean isCheckOut;
    protected String type;
    protected int id = 0;
    public Publication(int id, String name, String author, String year_published) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year_published = year_published;
        isCheckOut = false;
    }

    public Publication(String name, String author, String year_published) {
        this.name = name;
        this.author = author;
        this.year_published = year_published;
        isCheckOut = false;
    }

    public String getName() {
        return name;
    }
    public String getAuthor(){return author;}
    public String getYear_published() {
        return year_published;
    }
    public int getId() {
        return id;
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
        return false;
    }

    public boolean isCheckOut(){
        return isCheckOut;
    }

    public String getType(){
        return type;
    }

    abstract public String toString();
}
