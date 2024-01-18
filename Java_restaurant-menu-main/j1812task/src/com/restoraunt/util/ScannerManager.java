package com.restoraunt.util;

import java.util.Scanner;

public final class ScannerManager {
    private static Scanner scanner;

    private ScannerManager() {
    }

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
