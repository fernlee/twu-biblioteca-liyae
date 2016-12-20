package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
public class LibraryTest {
    private ArrayList<Book> books;
    private MainMenu menu;
    private ArrayList<String> menuItems;
    private ConsoleHelper consoleHelper;
    private Library library;
    @Before
    public void setup(){
        books = new ArrayList<Book>();
        books.add(new Book("book1","a1","1"));
        books.add(new Book("book2","a2","2"));
        books.add(new Book("book3","a3","3"));

        menuItems = new ArrayList<String>();
        menuItems.add("List books");
        menuItems.add("Check out a book");
        menu = new MainMenu(menuItems);

        consoleHelper = new ConsoleHelper();

        library = new Library(books,menu,consoleHelper);
    }
    @Test
    public void should_quit() throws Exception{
        library.excuteOptions(menuItems.size());
        assertThat(consoleHelper.getOutput(),containsString("Quit"));

    }
    @Test
    public void should_print_book_list() throws Exception{
        library.excuteOptions(1);
        for (Book book:books
             ) {
            assertThat(consoleHelper.getOutput(),containsString(book.getBookDetails()));
        }
    }
    @Test
    public void should_check_out_book() throws Exception{
        consoleHelper.setInput("book1");
        library.excuteOptions(2);
        assertThat(consoleHelper.getOutput(),containsString("Thank you! Enjoy the book"));
    }
    @Test
    public void should_not_check_out_book() throws Exception{
        consoleHelper.setInput("book4");
        library.excuteOptions(2);
        assertThat(consoleHelper.getOutput(),containsString("That book is not available."));
    }


}
