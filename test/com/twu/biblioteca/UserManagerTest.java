package com.twu.biblioteca;

import com.twu.biblioteca.user.Customer;
import com.twu.biblioteca.user.UserManager;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserManagerTest {
    @Test
    public void should_log_in() throws Exception{
        Customer customer = mock(Customer.class);
        UserManager.addUserCredential(customer);
        when(customer.isAuthentic("123","abcd")).thenReturn(true);
        UserManager.login("123","abcd");
        verify(customer).login();


    }
}
