package com.twu.biblioteca.publication;

import com.twu.biblioteca.pulication.Book;
import com.twu.biblioteca.pulication.Publications;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PublicationsTest {
    private Publications publications;
    private Book book1;
    private Book book2;
    private Book book3;
    @Before
    public void setup(){
        publications = new Publications();
        book1 = new Book(1,"book1","a1","1");
        book2 = new Book(2,"book2","a2","2");
        book3 = new Book(3,"book3","a3","3");
        publications.add(book1);
        publications.add(book2);
        publications.add(book3);
    }

    @Test
    public void should_check_out(){
        assertEquals(publications.checkOut("book1"),book1);
    }
    @Test
    public void should_not_check_out_when_invalid_book(){
        assertEquals(publications.checkOut("book4"),null);
    }
    @Test
    public void should_return_when_check_out(){
        publications.checkOut("book2");
        assertEquals(publications.returnPub("book2"),book2);
    }
    @Test
    public void should_not_return_when_not_check_out(){
        assertEquals(publications.returnPub("book1"),null);
    }

    @Test
    public void should_not_return_when_invalid_book(){assertEquals(publications.checkOut("book4"),null);}
    @Test
    public void should_print_list(){
        assertEquals(publications.display(),book1.toString()+ "\n" +book2.toString()+ "\n" +book3.toString()+"\n");
    }
}
