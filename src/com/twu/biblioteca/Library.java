package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private MainMenu mainMenu;
    private ArrayList<Publication> books;
    private ArrayList<Publication> movies;
    private ArrayList<UserAccount> users;
    private ConsoleWrapper console;

    public Library(MainMenu mainMenu, ArrayList<Publication> books, ArrayList<Publication> movies, ArrayList<UserAccount> users, ConsoleWrapper consoleTestHelper) {
        this.books = books;
        this.movies = movies;
        this.users = users;
        this.console= consoleTestHelper;
        this.mainMenu = mainMenu;
    }

    public void welcome(){
        console.println("Welcome to Biblioteca!");
    }

    public boolean login() throws IOException {
        console.println("Please log in with the format xxx-xxxx!");
        String str[] = console.getInput().split("-");
        String libnum = str[0];
        String pwd = str[1];
        for (UserAccount user:users){
            if(user.isAuthentic(libnum,pwd)) return true;
        }
        return false;
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
            check_out(console.getInput(), books);
        }
        else if (option == 3){
            return_book(console.getInput());
        }
        else if (option == 4){
            print_list(movies);
        }
        else if (option == 5){
            check_out(console.getInput(), movies);
        }

    }


    private void check_out(String title, ArrayList<Publication> publications) {
        if
        String type = publications.get(0).getType();
        for (Publication pub: publications
             ) {
            if (pub.getName().equals(title) && (pub.checkOut())){
                console.println("Thank you! Enjoy the "+type);
                return;
            }
        }
        console.println("That " + type + " is not available.");
    }

    public void return_book(String title){
        for (Publication book:books
                ) {
            if (book.getName().equals(title) && (book.returnToLib())){
                console.println("Thank you for returning the book");
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
