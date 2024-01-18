package com.restoraunt;


import com.restoraunt.util.MenuManager;
import com.restoraunt.util.PrintManager;
import com.restoraunt.util.ScannerManager;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String choiceMenu = "y";

        while (!Objects.equals(choiceMenu, "n")) {
            PrintManager.printIntro();
            PrintManager.printMenu();

            MenuManager.runMainMenu();

            PrintManager.printMenuAgain();
            choiceMenu = ScannerManager.getInstance().next();
        }
    }
}
