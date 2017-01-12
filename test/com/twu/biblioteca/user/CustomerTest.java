package com.twu.biblioteca.user;

import com.twu.biblioteca.pulication.Book;
import com.twu.biblioteca.pulication.Publications;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerTest {
    private Customer user;
    private Publications pubs;
    private Book book;
    @Before
    public void setup(){
        user = new Customer("123","abcd");
        pubs = mock(Publications.class);
        user.setPublications(pubs);
        book = mock(Book.class);
    }
    @Test
    public void should_be_Authentic(){
        assertTrue(user.isAuthentic("123","abcd"));
    }
    @Test
    public void should_not_be_Authentic_when_libnum_is_wrong(){
        assertFalse(user.isAuthentic("133","abcd"));
    }
    @Test
    public void should_not_be_Authentic_when_pwd_is_wrong(){
        assertFalse(user.isAuthentic("123","adcd"));
    }
    @Test
    public void should_check_out_pub_when_login(){
        boolean result = user.checkOutItem(book);
        verify(pubs).add(book);
    }
    @Test
    public void should_return_pub_when_login(){
        user.checkOutItem(book);
        user.returnCheckOutItem(book);
        verify(pubs).remove(book);
    }
    @Test
    public void should_show_check_out_items(){
        when(pubs.size()).thenReturn(1);
        user.showCheckOutItems();
        verify(pubs).displayBorrowedPubs();
    }

}
