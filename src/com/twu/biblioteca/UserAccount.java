package com.twu.biblioteca;

public class UserAccount {
    private String libnum;
    private String pwd;

    public UserAccount(String libnum, String pwd) {
        this.libnum = libnum;
        this.pwd = pwd;
    }

    public boolean isAuthentic(String libnum,String pwd){
        if (this.libnum.equals(libnum)&&this.pwd.equals(pwd)) return true;
        return false;
    }
}
