package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MainMenuTest {
    private MainMenu menu;
    private ArrayList<String> menuItems;
    @Before
    public void setup(){
        menuItems = new ArrayList<String>();
        menuItems.add("1");
        menuItems.add("2");
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
    public void should_check_invalid_choice_when_option_is_0() throws Exception{
        assertThat(menu.isValidOption(0),is(false));
    }
    @Test
    public void should_check_invalid_choice_when_option_is_4() throws Exception{
        assertThat(menu.isValidOption(4),is(false));
    }
    @Test
    public void should_check_valid_choice() throws Exception{
        assertThat(menu.isValidOption(1),is(true));
    }
    @Test
    public void should_check_number_of_options() throws Exception{
        assertThat(menu.isValidOption(2),is(true));
    }

}
