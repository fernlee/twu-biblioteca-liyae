package com.twu.biblioteca.user;

import com.twu.biblioteca.pulication.Publication;
import com.twu.biblioteca.pulication.Publications;

public class Customer extends User {
    private String email;
    private String address;
    private String phone_number;
    private Publications checkout_list;
    public Customer(String libnum, String pwd) {
        super(libnum,pwd);
        checkout_list = new Publications();
    }

    public Customer(String libnum, String pwd, String email, String address, String phone_number) {
       super(libnum,pwd);
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        checkout_list = new Publications();
    }

    public String getUserInfo(){
        return email + " " + address + " " + phone_number;
    }

    public void showCheckOutItems(){
        if (checkout_list.size() != 0 )
            System.out.println(checkout_list.displayBorrowedPubs());
        else
            System.out.println("No one has borrowed anything");
    }

    public boolean checkOutItem(Publication pub){
        return checkout_list.add(pub);
    }

    public boolean returnCheckOutItem(Publication pub){
        return checkout_list.remove(pub);
    }

    public void setPublications(Publications pubs){
        checkout_list = pubs;
    }
    @Override
    public boolean isLibrarian(){
        return false;
    }

}
