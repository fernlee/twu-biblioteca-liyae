package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> menuItems = new ArrayList<String>();
    public MainMenu(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
        menuItems.add("Quit");
    }

    public String getMenu() {
        StringBuilder text = new StringBuilder();
        int index = 0;
        text.append("Menu:\n");
        for (String item:menuItems
             ) {
            text.append(index+1).append(". ").append(item).append("\n");
            index++;
        }
        text.append("Choose an Option:\n");
        return text.toString();
    }
    public boolean isValidOption(int option){
        return option > 0 && option <= menuItems.size();
    }
    public int getNumberOfOptions(){
        return menuItems.size();
    }

}
