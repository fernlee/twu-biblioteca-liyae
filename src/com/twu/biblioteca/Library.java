package com.twu.biblioteca;


import com.twu.biblioteca.pulication.Publications;
import com.twu.biblioteca.user.Customer;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserManager;

import java.io.IOException;

public class Library {
    private MainMenu mainMenu;
    private WelcomeMessage welcomeMessage;
    private Publications movies;
    private Publications books;
    private ConsoleWrapper console;
    private Customer customer;
    private Librarian librarian;

    public Library(MainMenu mainMenu,Publications books, Publications movies, ConsoleWrapper consoleTestHelper) {

        this.movies = movies;
        this.books = books;
        this.console= consoleTestHelper;
        this.mainMenu = mainMenu;
    }

    public void excuteOptions(int option) throws IOException{
        if (!mainMenu.isValidOption(option)){
            console.println("Select a valid option!");
        }
        else if (option == mainMenu.getNumberOfOptions()){
            console.println("Quit");
            return;
        }
        else if (option == Options.LIST_BOOKS) {
            console.println("Books:");
            System.out.println(books.display());
        }
        else if (option == Options.LIST_MOVIES) {
            console.println("Movies:");
            System.out.println(movies.display());
        }
        else if (option == Options.LOG_IN){
            System.out.println("Please log in with the format xxx-xxxx!(123-abcd)");
            String input = console.getInput();
            User currentUser = UserManager.login(input.split("-")[0],input.split("-")[1]);
            if(currentUser == null){
                console.println("Sorry, wrong library number or password");
            }
            else {
               if(currentUser.isLibrarian()) {
                   librarian = (Librarian)currentUser;
                   if (customer != null) customer.logout();
               }
               else {
                   customer = (Customer)currentUser;
                   if (librarian != null) librarian.logout();
               }
            }
        }
        if (customer !=null && customer.isLogin()) {
           if (option == Options.CHECK_OUT_BOOK) {
                console.println("Please input the name of the book to check out");
                customer.checkOutItem(books.checkOut(console.getInput()));
            } else if (option == Options.RETURN_BOOK) {
                console.println("Please input the name of the book to return");
                customer.returnCheckOutItem(books.returnPub(console.getInput()));
            } else if (option == Options.CHECK_OUT_MOVIE) {
                console.println("Please input the name of the movie to check out");
                customer.checkOutItem(movies.checkOut(console.getInput()));
            }else if (option == Options.RETURN_MOVIE){
               console.println("Please input the name of the movie to return");
               customer.returnCheckOutItem(movies.returnPub(console.getInput()));
           }
            else if (option == Options.SHOW_USER_INFO && customer != null){
               console.println("This is your information");
               System.out.println(customer.getUserInfo());

           }
        }

        if (librarian != null && librarian.isLogin()){
            if (option == Options.SHOW_CHECK_LIST){
                librarian.showCheckOutList(UserManager.getCustomers());
            }
        }
        console.println("Choose an Option:");
    }

    public void setCurrentUser(User user){
        if (user != null) {
            if (user.isLibrarian()) librarian = (Librarian) user;
            else customer = (Customer) user;
        }
        else {
            customer = null;
            librarian = null;
        }

    }

    public User getCurrentUser(){
        if (customer != null && customer.isLogin())
            return customer;
        else if (librarian!=null && librarian.isLogin())
            return librarian;
        return null;
    }

}
