package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaApp {


    public static void main(String[] args) throws IOException{
        MainMenu menu = initMenu();
        ArrayList<Book> books = initBooks();
        ConsoleHelper consoleTestHelper = new ConsoleHelper();
        Library library = new Library(menu,books, consoleTestHelper);
        int option = 0;
        library.welcome();
        System.out.println(menu.getMenu());
        do {
            option = consoleTestHelper.getInteger();
            library.excuteOptions(option);
        }while (true);

    }

    private static MainMenu initMenu(){
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("List books");
        menuItems.add("Check out a book");
        menuItems.add("Return a book");
        return new MainMenu(menuItems);
    }

    private static ArrayList<Book> initBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("book1","a1","1"));
        books.add(new Book("book2","a2","2"));
        books.add(new Book("book3","a3","3"));
        books.add(new Book("book4","a4","4"));
        return books;
    }

}
