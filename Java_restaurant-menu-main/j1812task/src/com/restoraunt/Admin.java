package com.restoraunt;

import com.restoraunt.util.AdminManager;
import com.restoraunt.util.InputManager;
import com.restoraunt.util.PrintManager;

public final class Admin {
    private Admin() {
    }

    private static boolean isAdmin = false;

    public static boolean isIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(boolean isAdmin) {
        Admin.isAdmin = isAdmin;
    }

    public static void runMangerMenu() {
        isAdmin = true;
        int choice = 0;
        while (choice != 4) {
            PrintManager.printAdminMenu();
            choice = InputManager.inputNum();

            if (choice == 1) {
                AdminManager.setPromotionAdmin();

            } else if (choice == 2) {
                AdminManager.changePrice();

            } else if (choice == 3) {
                AdminManager.displayTotalCash();

            } else {
                break;
            }
        }
    }
}
