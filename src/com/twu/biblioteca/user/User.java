package com.twu.biblioteca.user;

abstract public class User {
    protected String libnum;
    protected String pwd;
    protected boolean login;

    public User(String libnum, String pwd) {
        this.libnum = libnum;
        this.pwd = pwd;
        login = false;
    }

    public boolean isAuthentic(String libnum, String pwd){
        return this.libnum.equals(libnum) && this.pwd.equals(pwd);
    }

    public boolean isLogin(){
        return login;
    }
    public void login() {login = true; }
    public void logout(){login = false;}
    abstract public boolean isLibrarian();

}
