package com.twu.biblioteca;

import java.util.ArrayList;

public class Options {
    public static final int LOG_IN = 1;
    public static final int LIST_BOOKS = 2;
    public static final int CHECK_OUT_BOOK = 3;
    public static final int RETURN_BOOK = 4;
    public static final int LIST_MOVIES = 5;
    public static final int CHECK_OUT_MOVIE = 6;
    public static final int RETURN_MOVIE = 7;
    public static final int SHOW_USER_INFO = 8;
    public static final int SHOW_CHECK_LIST = 9;

    private static ArrayList<String> menuItems = new ArrayList<String>();
    public static ArrayList<String> getMeunItems(){
        menuItems.add("Log in");
        menuItems.add("List books");
        menuItems.add("Check out a book");
        menuItems.add("Return a book");
        menuItems.add("List movies");
        menuItems.add("Check out a movie");
        menuItems.add("Return a movie");
        menuItems.add("View user information");
        menuItems.add("Viem check-out items (only available for librarian)");
        return menuItems;
    }
}
