package com.twu.biblioteca;


import java.util.ArrayList;

public class Labrary {
    private ArrayList<Book> books;
    private MainMenu mainMenu;
    private ConsoleHelper consoleHelper;

    public Labrary(ArrayList<Book> books,  MainMenu mainMenu,ConsoleHelper consoleHelper) {
        this.books = books;
        this.consoleHelper = consoleHelper;
        this.mainMenu = mainMenu;
    }

    public void excuteOptions(int option){
        if (option == mainMenu.getNumberOfOptions()){
            consoleHelper.println("Quit");
        }
        else if (option == 1){
            print_book_list();
        }
    }

    private void print_book_list(){
        for (Book book:books
             ) {
            consoleHelper.println(book.getBookDetails());
        }
    }


}
