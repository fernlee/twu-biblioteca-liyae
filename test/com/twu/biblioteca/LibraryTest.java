package com.twu.biblioteca;

import com.twu.biblioteca.pulication.Publications;
import com.twu.biblioteca.user.Customer;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class LibraryTest {
    private Publications books;
    private Publications movies;
    private ArrayList<User> users;
    private MainMenu menu;
    private ArrayList<String> menuItems;
    private ConsoleTestHelper consoleTestHelper;
    private Library library;
    @Before
    public void setup() throws Exception{
        books = mock(Publications.class);
        movies = mock(Publications.class);
        menu = mock(MainMenu.class);
        users = new ArrayList<User>();
        users.add(new Customer("123","abcd","11@163.com","address1","123456"));

        consoleTestHelper = new ConsoleTestHelper();
        library = new Library(menu,books,movies,consoleTestHelper);

        //library.login();

    }
    @Test
    public void should_log_in() throws Exception{
        library.excuteOptions(Options.LOG_IN);
    }
    @Test
    public void should_print_book_list() throws Exception{
        library.excuteOptions(Options.LIST_BOOKS);
        verify(books).display();
    }
    @Test
    public void should_check_out_book() throws Exception{
        consoleTestHelper.setInput("book1");
        library.excuteOptions(Options.CHECK_OUT_BOOK);
        verify(books).checkOut("book1");

    }

    @Test
    public void should_return_book() throws Exception{

        library.excuteOptions(Options.RETURN_BOOK);
    }
    @Test
    public void should_notify_invalid_book() throws Exception {
        consoleTestHelper.setInput("book4");
        library.excuteOptions(Options.RETURN_MOVIE);
    }
    @Test
    public void should_list_movies() throws Exception{
        library.excuteOptions(Options.LIST_MOVIES);
        movies.display();

    }
    @Test
    public void should_check_out_movie() throws Exception{
        consoleTestHelper.setInput("movie1");
        library.excuteOptions(Options.CHECK_OUT_MOVIE);
    }
    @Test
    public void should_user_login() throws Exception{
       library.excuteOptions(Options.LOG_IN);
    }
//    @Test
//    public void should_not_login() throws Exception{
//        consoleTestHelper.setInput("123-addd");
//        assertEquals(library.login(),false);
//    }
//    @Test
//    public void should_check_out_book_when_login() throws Exception{
//        consoleTestHelper.setInput("book1");
//        library.excuteOptions(2);
//        assertThat(consoleTestHelper.getOutput(),containsString("Thank you! Enjoy the book"));
//    }
//    @Test
//    public void should_show_check_out_item() throws Exception{
//        consoleTestHelper.setInput("book1");
//        library.excuteOptions(2);
//        checkOutInfo = library.getCheckOutInfo();
//        library.show_check_out_list();
//        assertThat(consoleTestHelper.getOutput(),containsString("123"));
//        assertThat(consoleTestHelper.getOutput(),containsString(checkOutInfo.showCheckOutItems()));
//    }
//
//    @Test
//    public void should_show_user_info() throws Exception{
//        library.excuteOptions(6);
//        assertThat(consoleTestHelper.getOutput(),containsString(users.get(0).getUserInfo()));
//    }
//    @Test
//    public void should_not_show_user_info_when_not_login() throws Exception{
//        library.logout();
//        library.excuteOptions(6);
//        assertThat(consoleTestHelper.getOutput(),containsString("Please login to check and return books"));
//    }


}
