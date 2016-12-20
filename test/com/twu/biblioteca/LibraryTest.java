package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
public class LibraryTest {
    private ArrayList<Book> books;
    private MainMenu menu;
    private ArrayList<String> menuItems;
    private ConsoleHelper consoleHelper;
    private Labrary labrary;
    @Before
    public void setup(){
        books = new ArrayList<Book>();
        books.add(new Book("book1","a1","1"));
        books.add(new Book("book2","a2","2"));

        menuItems = new ArrayList<String>();
        menuItems.add("List Books");
        menu = new MainMenu(menuItems);

        consoleHelper = new ConsoleHelper();

        labrary = new Labrary(books,menu,consoleHelper);
    }
    @Test
    public void should_quit() throws Exception{
        labrary.excuteOptions(menuItems.size());
        assertThat(consoleHelper.getOutput(),containsString("Quit"));

    }
    @Test
    public void should_print_book_list() throws Exception{
        labrary.excuteOptions(1);
        for (Book book:books
             ) {
            assertThat(consoleHelper.getOutput(),containsString(book.getBookDetails()));
        }
    }

}
