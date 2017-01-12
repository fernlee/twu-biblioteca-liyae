package com.twu.biblioteca.user;

import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = new ArrayList<User>();;
    public static void addUserCredential(User user){
        users.add(user);
    }
    public static ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for (int i = 0; i < users.size(); i++){
            if (!users.get(i).isLibrarian()){
                Customer customer;
                User user = users.get(i);
                customer = (Customer)user;
                customers.add(customer);
            }
        }
        return customers;
    }
    public static User login(String libnum, String pwd) {

        for (User user:users){
            if(user.isAuthentic(libnum,pwd)){
                user.login();
                return user;
            }
        }
        return null;
    }

}
