package com.restoraunt.util;

public class CashManager {
    private static double totalCash;

    public static double getTotalCash() {
        return totalCash;
    }

    public static void setTotalCash(double addCash) {
        totalCash += addCash;
    }
}
