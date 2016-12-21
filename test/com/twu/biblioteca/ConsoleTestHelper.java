package com.twu.biblioteca;



public class ConsoleTestHelper implements ConsoleWrapper{
    private StringBuilder output = new StringBuilder();
    private String input;
    @Override
    public void println(String str){
        output.append(str).append("\n");
    }
    @Override
    public int getInteger() {
        return Integer.parseInt(input);
    }
    @Override
    public String getInput(){
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
