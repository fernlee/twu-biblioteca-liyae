package com.twu.biblioteca;

public class ConsoleHelper {
    private StringBuilder output = new StringBuilder();
    private String input;
    public void println(String str){
        output.append(str).append("\n");
    }
    public void setInput(String str){
        input = str;
    }
    public String getInput(){
        return input;
    }
    public String getOutput(){
        return output.toString();
    }
}
