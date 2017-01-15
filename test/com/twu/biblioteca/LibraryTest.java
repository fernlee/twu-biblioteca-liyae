package com.twu.biblioteca;

import com.twu.biblioteca.pulication.Book;
import com.twu.biblioteca.pulication.Publications;
import com.twu.biblioteca.user.Customer;
import com.twu.biblioteca.user.Librarian;
import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class LibraryTest {
    private Publications books;
    private Book book;
    private Publications movies;
    private Customer customer;
    private Librarian librarian;
    private UserManager userManager;
    private MainMenu menu;
    private ArrayList<String> menuItems;
    private ConsoleTestHelper consoleTestHelper;
    private Library library;
    @Before
    public void setup() throws Exception{
        books = mock(Publications.class);
        movies = mock(Publications.class);
        userManager = mock(UserManager.class);
        menu = new MainMenu(Options.getMeunItems());

        book = new Book(1,"book1","a1","1");
        customer = new Customer("123","abcd","11@163.com","address1","123456");
        customer.login();
        librarian = new Librarian("111","aaaa");
        librarian.login();
        consoleTestHelper = new ConsoleTestHelper();
        library = new Library(menu,books,movies,consoleTestHelper);
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
    public void should_check_out_book_when_log_in() throws Exception{
        library.setCurrentUser(customer);
        consoleTestHelper.setInput("book1");
        library.excuteOptions(Options.CHECK_OUT_BOOK);
        verify(books).checkOut("book1");
    }

    @Test
    public void should_return_book() throws Exception{
        library.setCurrentUser(customer);
        consoleTestHelper.setInput("book1");
        library.excuteOptions(Options.RETURN_BOOK);
        verify(books).returnPub("book1");
    }

    @Test
    public void should_customer_login() throws Exception{
        consoleTestHelper.setInput("123-abcd");
        library.setCurrentUser(null);
        userManager.addUserCredential(customer);
        library.excuteOptions(Options.LOG_IN);
        assertEquals(customer,library.getCurrentUser());
    }
    @Test
    public void should_not_login() throws Exception{
        library.setCurrentUser(null);
        consoleTestHelper.setInput("123-addd");
        library.excuteOptions(Options.LOG_IN);
        assertEquals(library.getCurrentUser(),null);

    }
    @Test
    public void should_show_user_info() throws Exception{
        customer = mock(Customer.class);
        library.setCurrentUser(customer);
        when(customer.isLogin()).thenReturn(true);
        library.excuteOptions(Options.SHOW_USER_INFO);
        verify(customer).getUserInfo();
    }
    @Test
    public void should_not_show_user_info_when_not_login() throws Exception{
        librarian = null;
        library.excuteOptions(Options.SHOW_CHECK_LIST);
        verify(userManager, times(0));
    }


}
