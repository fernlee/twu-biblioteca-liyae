package com.twu.biblioteca;

public class UserAccount {
    private String libnum;
    private String pwd;
    private String email;
    private String address;
    private String phone_number;

    public UserAccount(String libnum, String pwd) {
        this.libnum = libnum;
        this.pwd = pwd;
    }

    public UserAccount(String libnum, String pwd, String email, String address, String phone_number) {
        this.libnum = libnum;
        this.pwd = pwd;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
    }

    public String getLibnum(){
        return libnum;
    }

    public boolean isAuthentic(String libnum,String pwd){
        return this.libnum.equals(libnum) && this.pwd.equals(pwd);
    }

    public String getUserInfo(){
        return email + " " + address + " " + phone_number;
    }
}
