package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private MainMenu mainMenu;
    private ArrayList<Publication> books;
    private ArrayList<Publication> movies;
    private ConsoleWrapper console;

    public Library(MainMenu mainMenu, ArrayList<Publication> books, ArrayList<Publication> movies, ConsoleWrapper consoleTestHelper) {
        this.books = books;
        this.movies = movies;
        this.console= consoleTestHelper;
        this.mainMenu = mainMenu;
    }

    public void welcome(){
        console.println("Welcome to Biblioteca!");
    }

    public void excuteOptions(int option) throws IOException{
        if (!mainMenu.isValidOption(option)){
            console.println("Select a valid option!");
        }
        if (option == mainMenu.getNumberOfOptions()){
            console.println("Quit");
            System.exit(0);
        }
        else if (option == 1){
            print_list(books);
        }
        else if (option == 2){
            check_out_book(console.getInput());
        }
        else if (option == 3){
            return_book(console.getInput());
        }
        else if (option == 4){
            print_list(movies);
        }
        else if (option == 5){
            check_out_book(console.getInput());
        }

    }
    public void check_out_book(String title){
        for (Publication book:books
             ) {
            if (book.getName().equals(title) && (book.checkOut())){
                console.println("Thank you! Enjoy the book");
                return;
            }
        }
        console.println("That book is not available.");
    }

    public void return_book(String title){
        for (Publication book:books
                ) {
            if (book.getName().equals(title) && (book.returnToLib())){
                console.println("Thank you for returning the book.");
                return;
            }
        }
        console.println("That is not a valid book to return.");
    }


    private void print_list(ArrayList<Publication> publications) {
        for (Publication pub:publications
             ) {
            if (!pub.isCheckOut()) console.println(pub.getDetails());
        }
    }


}
