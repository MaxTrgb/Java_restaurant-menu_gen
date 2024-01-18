package com.restoraunt;

import com.restoraunt.util.InputManager;
import com.restoraunt.util.PrintManager;
import com.restoraunt.util.ScannerManager;

import java.util.List;
import java.util.Scanner;

public class Discount {

    private boolean megaDiscountApplied = false;
    private boolean mealDiscountApplied = false;
    private double discountAmount = 0.0;
    private int discountCode = 0;

    public void applyDiscount(List<Menu> choices, int totalPrice) {

        PrintManager.printDiscountInfo();

        int discountOption = ScannerManager.getInstance().nextInt();

        switch (discountOption) {
            case 1:
                applyMegaDiscount(totalPrice);
                break;
            case 2:
                applyMealDiscount(choices);
                break;
            case 3:
                System.out.println("No discount applied.");
                break;
            default:
                System.out.println("Invalid option. No discount applied.");
                break;
        }
    }

    private void applyMegaDiscount(int totalPrice) {
        boolean validCode = false;
        do {
            PrintManager.printCode();
            discountCode = InputManager.inputNum();

            if (discountCode >= 1000 && discountCode <= 9999) {
                double discountPercentage = 0.2;
                discountAmount = totalPrice * discountPercentage;
                megaDiscountApplied = true;
                double discountedPrice = totalPrice - discountAmount;
                System.out.println("Mega Discount Applied: -" + discountAmount + "$");
                System.out.println("Discounted Price: " + discountedPrice + "$");
                validCode = true;

            } else {
                PrintManager.invalidCode();
            }
        } while (!validCode);
    }

    private void applyMealDiscount(List<Menu> choices) {
        boolean validCode = false;
        do {
            PrintManager.printCode();
            discountCode = InputManager.inputNum();

            if (discountCode >= 1000 && discountCode <= 9999) {
                System.out.println("Select the meal to apply the discount to:");

                for (Menu choice : choices) {
                    System.out.println(choice);
                }

                String discountedMeal = ScannerManager.getInstance().next();

                Menu discountedMenu = Menu.getMenuByName(discountedMeal);

                if (discountedMenu != null && choices.contains(discountedMenu)) {
                    double discountPercentage = 0.1;
                    discountAmount = discountedMenu.getValue() * discountPercentage;
                    mealDiscountApplied = true;
                    System.out.println("Discount Applied to " + discountedMenu + ": -" + discountAmount + "$");
                } else {
                    System.out.println("Invalid meal selection. No discount applied.");
                }

                validCode = true;

            } else {
                PrintManager.invalidCode();
            }
        } while (!validCode);
    }

    public boolean isMegaDiscountApplied() {
        return megaDiscountApplied;
    }

    public boolean isMealDiscountApplied() {
        return mealDiscountApplied;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public int calculateDiscountedPrice(int totalPrice) {
        return totalPrice;
    }

    //private
}
