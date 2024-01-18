package com.restoraunt.util;

import com.restoraunt.Menu;

public class AdminManager {
    public static void setPromotionAdmin() {
        PrintManager.printMenuForAdmin();
        System.out.println("Choose meal for promotion:");
        String choice = ScannerManager.getInstance().next();
        promotion(choice);
    }

    public static void changePrice() {
        PrintManager.printMenuForAdmin();
        System.out.println("Choose meal to change price:");
        String choice = ScannerManager.getInstance().next();
        price(choice);
    }

    public static void displayTotalCash() {
        System.out.println("Total Cash in bank: " + CashManager.getTotalCash() + "$");

    }

    private static void promotion(String choice) {
        switch (choice) {
            case "pizza": {
                Menu.PIZZA.setPromotion(true);
                return;
            }
            case "burger": {
                Menu.BURGER.setPromotion(true);
                return;
            }
            case "pasta": {
                Menu.PASTA.setPromotion(true);
                return;
            }
            case "chicken": {
                Menu.CHICKEN.setPromotion(true);
                return;
            }
            case "salad": {
                Menu.SALAD.setPromotion(true);
                return;
            }
            case "soup": {
                Menu.SOUP.setPromotion(true);
                return;
            }
            case "potato": {
                Menu.POTATO.setPromotion(true);
                return;
            }
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void price(String choice) {
        switch (choice) {
            case "pizza": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.PIZZA.setValue(price);
                return;
            }
            case "burger": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.BURGER.setValue(price);
                return;
            }
            case "pasta": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.PASTA.setValue(price);
                return;
            }
            case "chicken": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.CHICKEN.setValue(price);
                return;
            }
            case "salad": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.SALAD.setValue(price);
                return;
            }
            case "soup": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.SOUP.setValue(price);
                return;
            }
            case "potato": {
                PrintManager.printChangePrice();
                int price = InputManager.inputNum();
                Menu.POTATO.setValue(price);
                return;
            }
            default:
                System.out.println("Invalid choice!");
        }
    }

}
