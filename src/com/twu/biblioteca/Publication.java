package com.twu.biblioteca;

public interface Publication {

    String getDetails();
    boolean isCheckOut();
    boolean checkOut();
    boolean returnToLib();
    String getName();
}
