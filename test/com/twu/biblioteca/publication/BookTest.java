package com.twu.biblioteca.publication;

import com.twu.biblioteca.pulication.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;
    @Before
    public void setup(){
        book = new Book("book1","a1","1");
    }
    @Test
    public void should_print_id(){
        assertEquals(book.getId(),1);
    }
    @Test
    public void should_print_details(){
        assertEquals(book.toString(),"book1 a1 1");
    }
    @Test
    public void should_check_out(){
        assertEquals(book.checkOut(),true);
    }
    @Test
    public void should_not_check_out_when_checked(){
        book.checkOut();
        assertEquals(book.checkOut(),false);
    }
    @Test
    public void should_return_to_library(){
        book.checkOut();
        assertEquals(book.returnToLib(),true);
    }
    @Test
    public void should_not_return_to_library_when_not_checked(){
        assertEquals(book.returnToLib(),false);
    }

}
