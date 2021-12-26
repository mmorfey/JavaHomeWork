package com.pb.taran.hw12;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final String[] menuItems;

    public Menu(String[] menuItems) {
        this.menuItems = menuItems;
    }

    public int getUsersChoice() {
        Scanner console = new Scanner(System.in);
        String choice;

        ArrayList<String> possibleChoices = new ArrayList<>();

        System.out.println("Выберите код выбранного пункта меню:");
        for (String menuItem: menuItems) {
            System.out.println(menuItem);
            possibleChoices.add(menuItem.substring(0, 1));
        }

        do {
            choice = console.nextLine();
        }
        while (!possibleChoices.contains(choice));

        return Integer.parseInt(choice);
    }
}