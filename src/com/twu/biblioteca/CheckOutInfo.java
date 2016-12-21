package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutInfo {
    private UserAccount user;
    private ArrayList<Publication> pubs;

    public CheckOutInfo(UserAccount user) {
        this.user = user;
        pubs = new ArrayList<Publication>();
    }
    public String getUserID(){
        return user.getLibnum();
    }
    public ArrayList<Publication> getCheckOutItems(){
        return pubs;
    }
    public String showCheckOutItems(){
        StringBuilder str = new StringBuilder();
        for (Publication pub: pubs) {
            str.append(pub.getDetails()).append("\n");
        }
        return str.toString();
    }
    public boolean addCheckOutItem(Publication pub){
        if(pubs.add(pub)) return true;
        return false;
    }

    public boolean returnItem(Publication pub){
        if (pubs.remove(pub)) return true;
        return false;
    }

}
