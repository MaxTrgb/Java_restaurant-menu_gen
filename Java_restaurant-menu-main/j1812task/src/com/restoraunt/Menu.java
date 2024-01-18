package com.restoraunt;

public enum Menu {
    PIZZA(13, false),
    BURGER(10, false),
    PASTA(18, false),
    CHICKEN(11, false),
    SALAD(9, false),
    SOUP(7, false),
    POTATO(5, false);


    private int value;
    private boolean isPromotion;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name();
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    Menu(int value, boolean isPromotion) {
        this.value = value;
        this.isPromotion = isPromotion;
    }

    public static Menu getMenuByName(String value) {
        String temp = value.toUpperCase();
        for (Menu menu : Menu.values()) {
            if (menu.name().equals(temp)) {
                return menu;
            }
        }
        return null;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
