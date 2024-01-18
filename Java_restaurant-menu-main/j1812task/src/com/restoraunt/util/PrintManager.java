package com.restoraunt.util;

import com.restoraunt.Menu;
import com.restoraunt.Receipt;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class PrintManager {

    private PrintManager() {
    }

    public static void printIntro() {
        System.out.println("Welcome to our Web Restaurant!");
        System.out.println("You can add your selected dishes to your order by entering the dish name,");
        System.out.println("for example, 'burger'.");
        System.out.println("When you're finished, type 'confirm' to confirm your order.");
        System.out.println("Please choose from the menu options:");
    }

    public static void printDiscountInfo() {
        System.out.println("Do you have a discount?");
        System.out.println("1. Mega discount coupon (valid for the entire check)");
        System.out.println("2. Discount coupon (valid for one meal)");
        System.out.println("3. No discount");
    }

    public static void printReceipt(Receipt receipt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        System.out.println("\nReceipt generated at: " + formattedDate);
        System.out.println("Items Purchased:");

        for (Menu item : receipt.getItems()) {
            System.out.println(item);
        }

        if (receipt.isMegaDiscountApplied()) {
            System.out.println("Mega Discount Applied: -20%");
        }

        if (receipt.isMealDiscountApplied()) {
            System.out.println("Meal Discount Applied: -10% on selected item");
        }

        System.out.println("Total Cost: " + (receipt.getTotalCost() - receipt.getDiscountAmount()) + "$");
        CashManager.setTotalCash((receipt.getTotalCost()- receipt.getDiscountAmount()));
    }

    public static void printMenu() {
        for (Menu menu : Menu.values()) {
            String itemName;
            if (menu.isPromotion()) {
                itemName = menu.toString() + " (Promotion)";
            } else {
                itemName = menu.toString();
            }

            int itemPrice;
            if (menu.isPromotion()) {
                itemPrice = menu.getValue() / 2;
            } else {
                itemPrice = menu.getValue();
            }

            System.out.println(itemName + " -- " + itemPrice + "$");
        }
    }

    public static void printCode() {
        System.out.println("Enter you discount code:");
    }

    public static void invalidCode() {
        System.out.println("Invalid code!");
    }

    public static void printAdminMenu() {
        System.out.println("1.Set 'The Price of the Day'");
        System.out.println("2.Change product price");
        System.out.println("3.Display bank");
        System.out.println("4.Exit");
    }

    public static void printMenuAgain() {
        System.out.println("Do you want to make another order?(y/n)");
    }

    public static void printMenuForAdmin() {
        System.out.println("PIZZA\nBURGER\nPASTA\nCHICKEN\nSALAD\nSOUP\nPOTATO");
    }

    public static void printChangePrice() {
        System.out.println("Enter new price:");
    }
}
