package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> menuItems = new ArrayList<String>();
    
    public MainMenu(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }

    public String showMenu() {
        StringBuilder text = new StringBuilder();
        text.append("Menu:\n");
        for (String item:menuItems
             ) {
            text.append(item).append("\n");
        }
        return text.toString();
    }
    public boolean isValidOption(int option){
        return option > 0 && option <= menuItems.size();
    }

}
