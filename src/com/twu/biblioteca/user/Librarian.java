package com.twu.biblioteca.user;

import java.util.ArrayList;

public class Librarian extends User{
    public Librarian(String libnum, String pwd) {
        super(libnum,pwd);
    }
    public void showCheckOutList(ArrayList<Customer> customers){
        for (Customer customer : customers){
                customer.showCheckOutItems();
        }
    }
    @Override
    public boolean isLibrarian(){
        return true;
    }
}
