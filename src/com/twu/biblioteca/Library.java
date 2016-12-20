package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private MainMenu mainMenu;
    private ConsoleHelper consoleHelper;

    public Library(ArrayList<Book> books, MainMenu mainMenu, ConsoleHelper consoleHelper) {
        this.books = books;
        this.consoleHelper = consoleHelper;
        this.mainMenu = mainMenu;
    }

    public void excuteOptions(int option){
        if (!mainMenu.isValidOption(option)){
            consoleHelper.println("Select a valid option!");
        }
        if (option == mainMenu.getNumberOfOptions()){
            consoleHelper.println("Quit");
        }
        else if (option == 1){
            print_book_list();
        }
        else if (option == 2){
            check_out_book(consoleHelper.getInput());
        }

    }
    public void check_out_book(String title){
        for (Book book:books
             ) {
            if (book.getTitle().equals(title) && (book.checkOut())){
                consoleHelper.println("Thank you! Enjoy the book");
                return;
            }
        }
        consoleHelper.println("That book is not available.");
    }

    private void print_book_list(){
        for (Book book:books
             ) {
            if (!book.isCheckOut()) consoleHelper.println(book.getBookDetails());
        }
    }


}
