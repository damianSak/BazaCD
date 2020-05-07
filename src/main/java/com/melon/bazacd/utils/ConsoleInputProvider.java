package com.melon.bazacd.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputProvider {

    static Scanner scanner = new Scanner(System.in);

    public static int readIntFromUserHandlingEmptyInput() {
        int number = 0;
        boolean isThereException;
        do {
            try {
                isThereException= false;
                    number = scanner.nextInt();

                if(String.valueOf(number).length()==0){
                    System.out.println("Nie wprowadzono żadnej liczby");
                }
            } catch (InputMismatchException e) {
                isThereException = true;
                System.out.println("Wprowadzona wartość nie jest liczbą całkowitą, podaj własciwą liczbę");
            }
        } while (String.valueOf(number).length()==0 || isThereException);
        return number;
    }

    public static String readStringFromUserHandlingEmptyInput() {
        String string;
        do {
            string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Nie wprowadzono żadnego słowa");
            }

        } while (string.isEmpty());
        return string;
    }

    public static void closeScanner() {
        scanner.close();
    }

}
