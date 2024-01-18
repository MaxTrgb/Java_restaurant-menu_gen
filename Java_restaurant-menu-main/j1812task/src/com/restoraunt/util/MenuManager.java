package com.restoraunt.util;

import com.restoraunt.Admin;
import com.restoraunt.Discount;
import com.restoraunt.Menu;
import com.restoraunt.Receipt;

import java.util.List;
import java.util.Random;

public final class MenuManager {
    private MenuManager() {}

    public static void runMainMenu(){
        HandleManager menu = new HandleManager();

        menu.addChoice();
        adminCheck(menu);
        System.out.println("Return to main menu...");
        Admin.setIsAdmin(false);
    }

    public static int countPrice(Iterable<Menu> choices) {
        int totPrice = 0;
        for (Menu choice : choices) {
            totPrice += choice.isPromotion() ? choice.getValue() / 2 : choice.getValue();
        }
        return totPrice;

    }
    public static void setRandomPromotion() {
        Menu[] values = Menu.values();
        int randomIndex = new Random().nextInt(values.length);
        Menu menuToPromote = values[randomIndex];
        menuToPromote.setPromotion(true);
    }
    private static void adminCheck(HandleManager menu) {
        if(!Admin.isIsAdmin()) {
            int totalPrice = MenuManager.countPrice(menu.getChoices());

            Discount discount = new Discount();
            discount.applyDiscount(menu.getChoices(), totalPrice);

            Receipt receipt = new Receipt(discount, menu.getChoices(), totalPrice);



            PrintManager.printReceipt(receipt);
            return;
        }
    }
}
