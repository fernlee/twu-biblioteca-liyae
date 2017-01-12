package com.twu.biblioteca.pulication;

import java.util.ArrayList;

public class Publications {
    private ArrayList<Publication> publications;

    public Publications(){
        publications = new ArrayList<Publication>();
    }

    public boolean add(Publication publication){
        return publications.add(publication);
    }
    public boolean remove(Publication publication){ return publications.remove(publication);}
    public int size(){return publications.size();}

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Publication pub:publications
                ) {
            if (!pub.isCheckOut()) stringBuilder.append(pub.toString()+"\n");
        }
        return stringBuilder.toString();
    }
    public String displayBorrowedPubs(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Publication pub:publications
                ) {
            stringBuilder.append(pub.toString()+"\n");
        }
        return stringBuilder.toString();
    }
    public Publication checkOut(String title) {
        String type = getType();
        for (Publication pub: publications
                ) {
            if (pub.getName().equals(title) && pub.checkOut()){
                System.out.println("Thank you! Enjoy the "+type);
                return pub;
            }
        }
        System.out.println("That " + type + " is not available.");
        return null;
    }

    public Publication returnPub(String title){
        String type = getType();
        for (Publication pub:publications
                ) {
            if (pub.getName().equals(title) && (pub.returnToLib())){
                System.out.println("Thank you for returning the " + type + ".");
                return pub;
            }
        }
        System.out.println("That is not a valid " + type + " to return.");
        return null;
    }

    private String getType() {
        if (!publications.isEmpty()) {
            return publications.get(0).getType();
        }
        else {
            return "Empty Publication";
        }
    }

}
