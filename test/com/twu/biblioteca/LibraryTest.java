package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
public class LibraryTest {
    private ArrayList<Publication> books;
    private ArrayList<Publication> movies;
    private ArrayList<UserAccount> users;
    private MainMenu menu;
    private ArrayList<String> menuItems;
    private ConsoleTestHelper consoleTestHelper;
    private Library library;
    @Before
    public void setup(){
        books = new ArrayList<Publication>();
        books.add(new Book("book1","a1","1"));
        books.add(new Book("book2","a2","2"));
        books.add(new Book("book3","a3","3"));

        movies = new ArrayList<Publication>();
        movies.add(new Movie("movie1","1","d1",7));
        movies.add(new Movie("movie2","2","d2",5));
        movies.add(new Movie("movie3","3","d3",4));

        menuItems = new ArrayList<String>();
        menuItems.add("List books");
        menuItems.add("Check out a book");
        menuItems.add("Return a book");
        menuItems.add("List movies");
        menuItems.add("Check out a movie");
        menu = new MainMenu(menuItems);

        users = new ArrayList<UserAccount>();
        users.add(new UserAccount("123","abcd"));

        consoleTestHelper = new ConsoleTestHelper();

        library = new Library(menu,books,movies, users,consoleTestHelper);
    }

    private void print_list(ArrayList<Publication> publications) throws Exception{
        for (Publication pub:publications
                ) {
            assertThat(consoleTestHelper.getOutput(),containsString(pub.getDetails()));
        }
    }
    @Test
    public void should_print_book_list() throws Exception{
        library.excuteOptions(1);
        print_list(books);
    }
    @Test
    public void should_check_out_book() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        assertThat(consoleTestHelper.getOutput(),containsString("Thank you! Enjoy the book"));
    }
    @Test
    public void should_not_check_out_book() throws Exception{
        consoleTestHelper.setInput("book4");
        library.excuteOptions(2);
        assertThat(consoleTestHelper.getOutput(),containsString("That book is not available."));
    }
    @Test
    public void should_not_check_out_book_when_checked() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        assertThat(consoleTestHelper.getOutput(),containsString("That book is not available."));
    }
    @Test
    public void should_return_book() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        consoleTestHelper.setInput("book1");
        library.excuteOptions(3);
        assertThat(consoleTestHelper.getOutput(),containsString("Thank you for returning the book."));
    }
    @Test
    public void should_notify_invalid_book() throws Exception {
        consoleTestHelper.setInput("book4");
        library.excuteOptions(3);
        assertThat(consoleTestHelper.getOutput(), containsString("That is not a valid book to return."));
    }
    @Test
    public void should_list_movies() throws Exception{
        library.excuteOptions(4);
        print_list(movies);

    }
    @Test
    public void should_check_out_movie() throws Exception{
        consoleTestHelper.setInput("movie1");
        library.excuteOptions(5);
        assertThat(consoleTestHelper.getOutput(),containsString("Thank you! Enjoy the movie"));
    }
    @Test
    public void should_user_login() throws Exception{
        consoleTestHelper.setInput("123-abcd");
        assertEquals(library.login(),true);
    }
    @Test
    public void should_not_login() throws Exception{
        consoleTestHelper.setInput("123-addd");
        assertEquals(library.login(),false);
    }
    @Test
    public void should_quit() throws Exception{
        library.excuteOptions(menuItems.size());
        assertThat(consoleTestHelper.getOutput(),containsString("Quit"));

    }


}
