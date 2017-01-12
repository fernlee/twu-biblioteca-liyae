package com.twu.biblioteca.user;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibarianTest {
    @Test
    public void should_print_customer_check_out_list() throws Exception{
        Librarian librarian = new Librarian("123","abcd");
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = mock(Customer.class);
        customers.add(customer);

        librarian.showCheckOutList(customers);
        verify(customer).showCheckOutItems();
    }
}
