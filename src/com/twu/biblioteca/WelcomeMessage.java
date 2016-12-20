package com.twu.biblioteca;

public class WelcomeMessage {
    private String msg;
    public WelcomeMessage(String msg) {
        this.msg = msg;
    }
    public String showWelcomeMsg(){
        return msg;
    }
}
