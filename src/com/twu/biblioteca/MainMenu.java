package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> menuItems = new ArrayList<String>();
    private int numberOfOptions;
    public MainMenu(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
        menuItems.add("Quit");
    }

    public String getMenu() {
        StringBuilder text = new StringBuilder();
        text.append("Menu:\n");
        for (String item:menuItems
             ) {
            text.append(item).append("\n");
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
