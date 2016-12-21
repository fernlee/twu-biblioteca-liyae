package com.twu.biblioteca;

public class UserAccount {
    private String libnum;
    private String pwd;

    public UserAccount(String libnum, String pwd) {
        this.libnum = libnum;
        this.pwd = pwd;
    }

    public String getLibnum(){
        return libnum;
    }

    public boolean isAuthentic(String libnum,String pwd){
        return this.libnum.equals(libnum) && this.pwd.equals(pwd);
    }
}
