package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year_published;
    private boolean isCheckOut;

    public Book(String title, String author, String year_published) {
        this.title = title;
        this.author = author;
        this.year_published = year_published;
        isCheckOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear_published() {
        return year_published;
    }

    public String getBookDetails(){ return title + " " + author + " " + year_published; }

    public boolean checkOut(){
        if (isCheckOut) return false;
        else{
            isCheckOut = true;
            return true;
        }
    }
    public boolean returnBook(){
        if (isCheckOut){
            isCheckOut = false;
            return true;
        }
        else return true;
    }

    public boolean isCheckOut(){
        return isCheckOut;
    }
}
