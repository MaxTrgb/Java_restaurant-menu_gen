package com.restoraunt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputManager {
    private InputManager() {
    }

    public static int inputNum() {
        while (true) {
            String input = ScannerManager.getInstance().next();
            if (isNum(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Wrong input!\nPlease, input only numbers!");
        }
    }

    private static boolean isNum(String input) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
