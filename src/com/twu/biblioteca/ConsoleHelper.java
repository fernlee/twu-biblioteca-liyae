package com.twu.biblioteca;

public class ConsoleHelper {
    private StringBuilder output = new StringBuilder();
    public void println(String str){
        output.append(str).append("\n");
    }
    public String getOutput(){
        return output.toString();
    }
}
