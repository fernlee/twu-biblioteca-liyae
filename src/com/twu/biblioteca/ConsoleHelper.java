package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper implements ConsoleWrapper{
    @Override
    public void println(String str){
        System.out.println(str);
    }
    @Override
    public int getInteger() throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(inputReader.readLine());
    }
    @Override
    public String getInput() throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        return inputReader.readLine();
    }

    @Override
    public String getOutput() {
        return null;
    }

    @Override
    public void setInput(String str){}
}
