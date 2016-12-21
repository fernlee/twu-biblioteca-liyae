package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private MainMenu mainMenu;
    private ArrayList<Publication> books;
    private ArrayList<Publication> movies;
    private ArrayList<UserAccount> users;
    private ConsoleWrapper console;
    private UserAccount currentUser;
    private boolean isLogin;
    private CheckOutInfo checkOutInfo;

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
        console.println("Please log in with the format xxx-xxxx!(123-abcd)");
        String str[] = console.getInput().split("-");
        String libnum = str[0];
        String pwd = str[1];
        for (UserAccount user:users){
            if(user.isAuthentic(libnum,pwd)) {
                currentUser = user;
                checkOutInfo = new CheckOutInfo(user);
                isLogin = true;
                return isLogin;
            }
        }
        isLogin = false;
        return isLogin;
    }

    public void logout() throws Exception{
        currentUser = null;
        isLogin = false;
        console.println("User has log out");
    }

    public void excuteOptions(int option) throws IOException{
        if (!mainMenu.isValidOption(option)){
            console.println("Select a valid option!");
        }
        else if (option == mainMenu.getNumberOfOptions()){
            console.println("Quit");
            System.exit(0);
        }
        else if (option == 1) {
            console.println("Books:");
            print_list(books);
        }
        else if (option == 4) {
            console.println("Movies:");
            print_list(movies);
        }
        if (isLogin) {
           if (option == 2) {
                console.println("Please input the name of the book to check out");
                check_out(console.getInput(), books);
            } else if (option == 3) {
                console.println("Please input the name of the book to return");
                return_item(console.getInput(),books);
            } else if (option == 5) {
                console.println("Please input the name of the movie to check out");
                check_out(console.getInput(), movies);
            }
            else if (option == 6){
               console.println("This is your information");
               show_user_info();
           }else if (option == 7){
                show_check_out_list();
           }
        }
        else console.println("Please login to check and return books");
        console.println("Choose an Option:");
    }

    public void show_check_out_list(){
        console.println(checkOutInfo.getUserID() + " has borrowed:\n" + checkOutInfo.showCheckOutItems());
    }

    public CheckOutInfo getCheckOutInfo(){
        return checkOutInfo;
    }
    private void show_user_info(){
       console.println(currentUser.getUserInfo());
    }
    private void check_out(String title, ArrayList<Publication> publications) {
        String type = publications.get(0).getType();
        for (Publication pub: publications
             ) {
            if (pub.getName().equals(title) && (pub.checkOut())){
                checkOutInfo.addCheckOutItem(pub);
                console.println("Thank you! Enjoy the "+type);
                return;
            }
        }
        console.println("That " + type + " is not available.");
    }

    private void return_item(String title,ArrayList<Publication> publications){
        String type = publications.get(0).getType();
        for (Publication pub:publications
                ) {
            if (pub.getName().equals(title) && (pub.returnToLib())){
                checkOutInfo.returnItem(pub);
                console.println("Thank you for returning the" + type);
                return;
            }
        }
        console.println("That is not a valid" + type + "to return.");
    }

    private void print_list(ArrayList<Publication> publications) {
        for (Publication pub:publications
             ) {
            if (!pub.isCheckOut()) console.println(pub.getDetails());
        }
    }

}
