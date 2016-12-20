package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleTestHelper implements ConsoleWrapper{
    private StringBuilder output = new StringBuilder();
    private String input;
    @Override
    public void println(String str){
        System.out.println(str);
        output.append(str).append("\n");
    }
    @Override
    public int getInteger() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(inputReader.readLine());
    }
    @Override
    public String getInput() throws IOException{
       return input;
    }
    @Override
    public String getOutput(){
        return output.toString();
    }

    @Override
    public void setInput(String str) {
        input = str;
    }
}
