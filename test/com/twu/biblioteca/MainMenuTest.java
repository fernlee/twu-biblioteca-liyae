package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private MainMenu menu;
    private ArrayList<String> menuItems;
    @Before
    public void setup(){
        menuItems = new ArrayList<String>();
        menuItems.add("List Books");
        menu = new MainMenu(menuItems);
    }
    @Test
    public void should_print_options() throws Exception{
        String menuText = menu.getMenu();
        for (String item:menuItems
             ) {
            assertThat(menuText,containsString(item));
        }
    }
    @Test
    public void should_check_invalid_choice() throws Exception{
        assertThat(menu.isValidOption(4),is(false));
    }
    @Test
    public void should_check_valid_choice() throws Exception{
        assertThat(menu.isValidOption(1),is(true));
    }
    @Test
    public void should_quit_when_choose_quit() throws Exception{

    }
}
