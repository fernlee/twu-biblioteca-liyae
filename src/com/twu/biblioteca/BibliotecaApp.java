package com.twu.biblioteca;

import com.twu.biblioteca.pulication.Book;
import com.twu.biblioteca.pulication.Movie;
import com.twu.biblioteca.pulication.Publications;
import com.twu.biblioteca.user.Customer;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.UserManager;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaApp {


    public static void main(String[] args) throws IOException{
        MainMenu menu = initMenu();
        Publications books = initBooks();
        Publications movies = initMovies();
        initUsers();
        ConsoleHelper consoleTestHelper = new ConsoleHelper();
        Library library = new Library(menu,books, movies, consoleTestHelper);
        int option = 0;
        System.out.println(menu.getMenu());
        do {
            option = consoleTestHelper.getInteger();
            library.excuteOptions(option);
        }while (true);

    }

    private static MainMenu initMenu(){
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("Log in");
        menuItems.add("List books");
        menuItems.add("Check out a book");
        menuItems.add("Return a book");
        menuItems.add("List movies");
        menuItems.add("Check out a movie");
        menuItems.add("Return a movie");
        menuItems.add("View user information");
        menuItems.add("Viem check-out items (only available for librarian)");
        return new MainMenu(menuItems);
    }

    private static Publications initBooks(){
        Publications books = new Publications();
        books.add(new Book(1,"book1","a1","1"));
        books.add(new Book(2,"book2","a2","2"));
        books.add(new Book(3,"book3","a3","3"));
        books.add(new Book(4,"book4","a4","4"));
        return books;
    }

    private static Publications initMovies(){
        Publications movies = new Publications();
        movies.add(new Movie(1,"movie1","1","d1",7));
        movies.add(new Movie(2,"movie2","2","d2",5));
        movies.add(new Movie(3,"movie3","3","d3",4));
        return movies;
    }

    private static void initUsers(){
        UserManager.addUserCredential(new Customer("123","abcd","11@163.com","address1","123456"));
        UserManager.addUserCredential(new Librarian("111","aaaa"));
    }


}
