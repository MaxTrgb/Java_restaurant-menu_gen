package com.restoraunt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {

    private final Iterable<Menu> items;
    private final double totalCost;
    private final boolean megaDiscountApplied;
    private final boolean mealDiscountApplied;
    private final double discountAmount;

    public Iterable<Menu> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
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

    public Receipt(Discount discount, Iterable<Menu> choices, int totalPrice) {
        this.items = choices;
        this.totalCost = totalPrice;
        this.megaDiscountApplied = discount.isMegaDiscountApplied();
        this.mealDiscountApplied = discount.isMealDiscountApplied();
        this.discountAmount = discount.getDiscountAmount();
    }

}
