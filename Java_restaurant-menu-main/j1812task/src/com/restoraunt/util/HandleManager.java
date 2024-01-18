package com.restoraunt.util;

import com.restoraunt.Admin;
import com.restoraunt.Menu;
import com.restoraunt.MenuList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.restoraunt.Menu.getMenuByName;

public class HandleManager {
    private List<Menu> choices = new MenuList();

    public List<Menu> getChoices() {
        return choices;
    }

    public void addChoice() {

        readChoice();

        int totalPrice = MenuManager.countPrice(choices);
        System.out.println("Total: " + totalPrice);

        for (Menu s : choices) {
            System.out.println(getMenuByName(s.getName()));
        }
    }

    public void readChoice() {
        String choice = ScannerManager.getInstance().next();
        processChoice(choice);
    }

    private void processChoice(String choice) {
        while (!Objects.equals(choice, "confirm")) {
            Menu men = Menu.getMenuByName(choice);
            if (men != null) {
                choices.add(men);
            } else if (choice.equals("admin")) {
                Admin.runMangerMenu();
                break;
            } else {
                System.out.println("Invalid choice");
            }
            choice = ScannerManager.getInstance().next();

        }
    }
}
