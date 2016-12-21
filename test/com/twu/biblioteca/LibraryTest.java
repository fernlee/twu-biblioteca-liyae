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
    private CheckOutInfo checkOutInfo;
    @Before
    public void setup() throws Exception{
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
        menuItems.add("View user information");
        menu = new MainMenu(menuItems);

        users = new ArrayList<UserAccount>();
        users.add(new UserAccount("123","abcd","11@163.com","address1","123456"));

        consoleTestHelper = new ConsoleTestHelper();

        library = new Library(menu,books,movies, users,consoleTestHelper);
        consoleTestHelper.setInput("123-abcd");
        library.login();
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
    public void should_check_out_book_when_login() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        assertThat(consoleTestHelper.getOutput(),containsString("Thank you! Enjoy the book"));
    }
    @Test
    public void should_show_check_out_item() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(2);
        checkOutInfo = library.getCheckOutInfo();
        library.show_check_out_list();
        assertThat(consoleTestHelper.getOutput(),containsString("123"));
        assertThat(consoleTestHelper.getOutput(),containsString(checkOutInfo.showCheckOutItems()));
    }

    @Test
    public void should_show_user_info() throws Exception{
        library.excuteOptions(6);
        assertThat(consoleTestHelper.getOutput(),containsString(users.get(0).getUserInfo()));
    }
    @Test
    public void should_not_show_user_info_when_not_login() throws Exception{
        library.logout();
        library.excuteOptions(6);
        assertThat(consoleTestHelper.getOutput(),containsString("Please login to check and return books"));
    }


}
